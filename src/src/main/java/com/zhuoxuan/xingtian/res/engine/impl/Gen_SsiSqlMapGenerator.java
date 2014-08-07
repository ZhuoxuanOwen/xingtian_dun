package com.zhuoxuan.xingtian.res.engine.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zhuoxuan.common.constants.BuildConstants;
import com.zhuoxuan.common.constants.BuildTaskConstants;
import com.zhuoxuan.common.result.ResultBase;
import com.zhuoxuan.common.util.ExceptionUtil;
import com.zhuoxuan.xingtian.res.engine.CodeTemplateGeneratorEngine;
import com.zhuoxuan.xingtian.res.entity.BuildTaskDO;
import com.zhuoxuan.xingtian.res.entity.FieldDO;
import com.zhuoxuan.xingtian.res.entity.TableDO;

/**
 * @description：Ibatis SqlMap 文件生成
 * @date 2013-12-15 下午04:56:25
 * @version JQ应用开发支撑平台
 * @author：高江涛
 */
public class Gen_SsiSqlMapGenerator extends CodeTemplateGeneratorEngine {

	private  final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public ResultBase<StringBuilder> generatorTemplateCode(BuildTaskDO buildTask , TableDO tableDO) {

		ResultBase<StringBuilder> result = new ResultBase<StringBuilder>();
		try {
			//刷新配置模板
			super.refushBuildTask(buildTask, BuildConstants.TECL_SSI);
			
			StringBuilder sb = new StringBuilder();
			String cName = tableDO.getClassName();
			String aliseName = getLowerName(cName);
			String tName = tableDO.getTableName();
			String tNote = tableDO.getBusinessName() == null ? tableDO.getClassName() : tableDO.getBusinessName();
			String basePakcage = buildTask.getBuildConfig().getPackagePath();
			List<FieldDO> fields = tableDO.getFields();

			// 主键列
			String pKeyColumn = fields.get(0).getFieldName();
			// 主键属性
			String pKeyAttr = fields.get(0).getAttrName();

			sb.append(buildTask.getCodeTemplate().get(BuildTaskConstants.CodeTempKey.SQLMAP_CONFIG_HEAD_KEY));
			sb.append("\n\n<!-- " + tNote + "Ibatis 映射关系配置文件 -->\n\n");
			sb.append("<sqlMap namespace=\"" + aliseName + "manage\">");
			sb.append("\n\t<typeAlias alias=\"" + aliseName + "\" type=\"" + basePakcage + "." + cName + "\" />");
			sb.append("\n\t<typeAlias alias=\"pager\" type=\"com.starsoft.ssi.common.page.entity.Page\" />\n\n");
			// 添加
			sb.append("\t<!--\n\t\t开发负责人："+buildTask.getBuildConfig().getAuthor()+" \n\t\t功能说明：添加" + tNote + " \n\t\t前台 或 后台：   ");
		    sb.append("\n\t\t数据量评估:预估表存储的数据量\n\t-->");
			String statementOne = "";
			String statementTwo = "";
			for (int i = 1; i < fields.size(); i++) {
				FieldDO vo = fields.get(i);
				if (i != 1) {
					statementOne += ",";
					statementTwo += ",";
				}
				if (i % 5 == 0) {
					statementOne += "\n\t\t";
					statementTwo += "\n\t\t";
				}
				statementOne += vo.getFieldName();
				statementTwo += "#" + vo.getAttrName() + "#";
			}
			sb.append("\n\t<insert id=\"add" + cName + "\" parameterClass=\"" + aliseName + "\">\n");
			sb.append("\t<![CDATA[\n\t insert into " + tName + "(");
			sb.append("\t\t"+statementOne);
			sb.append(")\n\tvalues (" + statementTwo);
			sb.append(")\n\t ]]>\n\t</insert>\n\n");

			// 修改
			sb.append("\t<!--\n\t\t开发负责人："+buildTask.getBuildConfig().getAuthor()+" \n\t\t功能说明：修改" + tNote + " \n\t\t前台 或 后台：   ");
		    sb.append("\n\t\t数据量评估:预估表存储的数据量\n\t-->");
			String updateStatement = "";
			for (int i = 1; i < fields.size(); i++) {
				FieldDO vo = fields.get(i);
				if (i == 1) {
					updateStatement += "\n\t\t set " + vo.getFieldName() + "= #" + vo.getAttrName() + "#";
				} else {
					updateStatement += ",\n\t\t" + vo.getFieldName() + "= #" + vo.getAttrName() + "#";
				}
			}
			sb.append("\n\t<update id=\"update" + cName + "\" parameterClass=\"" + aliseName + "\">");
			sb.append("\n\t<![CDATA[\n \t\tupdate " + tName + " ");
			sb.append(updateStatement);
			sb.append(" \n\t where " + pKeyColumn + " = #" + pKeyAttr + "#\n\t]]>\n\t</update>\n\n");

			// 删除
			sb.append("\t<!--\n\t\t开发负责人："+buildTask.getBuildConfig().getAuthor()+" \n\t\t功能说明：删除" + tNote + " \n\t\t前台 或 后台：   ");
		    sb.append("\n\t\t是否物理删除：\n\t\t数据量评估:预估表存储的数据量\n\t-->");
			sb.append("\n\t<delete id=\"delete" + cName + "\" parameterClass=\"String\">");
			sb.append("\n\t<![CDATA[ \n\t\t delete from  " + tName + " ");
			sb.append("where " + pKeyColumn + " = #value#   \n\t]]>\n\t</delete> ");
			sb.append("\n\n");

			// 按照主键查询实体
			sb.append("\t<!--\n\t\t开发负责人："+buildTask.getBuildConfig().getAuthor()+" \n\t\t功能说明： 按照ID查询" + tNote + "\n\t\t前台 或 后台：   ");
		    sb.append("\n\t\t数据量评估:预估表存储的数据量\n\t-->");
			String queryStatement = "";
			for (int i = 0; i < fields.size(); i++) {
				FieldDO vo = fields.get(i);
				if (i != 0) {
					queryStatement += ",\n";
				}
				queryStatement += "\t\t " + vo.getFieldName() + "  " + vo.getAttrName();
			}
			sb.append("\n\t<select id=\"query" + cName + "ById\" parameterClass=\"String\" resultClass=\"" + aliseName + "\">\n\t<![CDATA[ ");
			sb.append("\n\t\tselect" + queryStatement + " \t\t\n\t\tfrom " + tName + " where " + pKeyColumn + " = #value# ");
			sb.append("\n\t]]>\n\t</select>\n\n");

			// 查询分页
			sb.append("\t<!--\n\t\t开发负责人："+buildTask.getBuildConfig().getAuthor()+" \n\t\t功能说明： 分页查询" + tNote + "\n\t\t前台 或 后台：   ");
		    sb.append("\n\t\t数据量评估:预估表存储的数据量\n\t-->");
			sb.append("\n\t<select id=\"query" + cName + "Page\" parameterClass=\"pager\" resultClass=\"" + aliseName + "\">");
			sb.append("\n\t<![CDATA[ \n\t\t select ");
			sb.append(queryStatement);
			sb.append("\n\t\t from " + tName + " ");
			sb.append("\n\t\t limit #start#,#pageSize#  \n\t]]>\n\t</select>\n\n");

			// 查询分页求和
			sb.append("\t<!--\n\t\t开发负责人："+buildTask.getBuildConfig().getAuthor()+" \n\t\t功能说明：查询" + tNote + "分页总记录数\n\t\t前台 或 后台：   ");
		    sb.append("\n\t\t数据量评估:预估表存储的数据量\n\t-->");
			sb.append("\n\t<select id=\"query" + cName + "RowCount\" parameterClass=\"pager\" resultClass=\"Long\">");
			sb.append("\t\n\t <![CDATA[ \n\t\t select count(1)  from   " + tName + " ");
			sb.append("\n\t ]]> \n\t</select>");

			sb.append("\n"+buildTask.getCodeTemplate().get(BuildTaskConstants.CodeTempKey.SQLMAP_CONFIG_END_KEY));

			return result.setReturnRightValue(sb);
		} catch (Exception e) {
			logger.error("根据表资源对象渲染Ibatis SqlMap配置出现异常,原因:" + ExceptionUtil.getStackTrace(e.fillInStackTrace()));
			return result.setReturnErrorMsg("根据表资源对象渲染Ibatis SqlMap配置出现异常。");
		}
	}
	
	/**
	 * 生成查询语句的条件
	 * @param fieldDO
	 * @return
	 */
	public StringBuilder conditionQuery(FieldDO fieldDO){
		StringBuilder sb = new StringBuilder();
		
		return sb;
	}
}
