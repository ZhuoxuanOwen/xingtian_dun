package com.zhuoxuan.xingtian.res.engine.impl;

import java.util.Date;

import org.apache.log4j.Logger;

import com.zhuoxuan.common.result.ResultBase;
import com.zhuoxuan.common.util.DateUtil;
import com.zhuoxuan.common.util.ExceptionUtil;
import com.zhuoxuan.common.util.StringUtil;
import com.zhuoxuan.xingtian.res.engine.CodeTemplateGeneratorEngine;
import com.zhuoxuan.xingtian.res.entity.BuildTaskDO;
import com.zhuoxuan.xingtian.res.entity.TableDO;

/**
 * @description：JavaDO对象生成
 * @date 2013-12-15 下午04:56:25
 * @version JQ应用开发支撑平台
 * @author：高江涛
 */
public class Gen_SsiDaoImplGenerator extends CodeTemplateGeneratorEngine {

	private static final Logger logger = Logger.getLogger(Gen_SsiDaoImplGenerator.class);

	@Override
	public ResultBase<StringBuilder> generatorTemplateCode(BuildTaskDO buildTask, TableDO tableDO) {

		ResultBase<StringBuilder> result = new ResultBase<StringBuilder>();
		try {
			StringBuilder sb = new StringBuilder();
			String basePackageName = buildTask.getBuildConfig().getPackagePath();
			String className = tableDO.getClassName();
			String entityName = className + buildTask.getBuildConfig().getJavaDoSuffix();
			String aliseName = tableDO.getBusinessName() != null ? tableDO.getBusinessName() : tableDO.getTableDesc();
			if (StringUtil.isEmpty(aliseName)) {
				aliseName = tableDO.getClassName();
			}
			String statement_name = getLowerName(className) + "manage"; // Ibatis
			
			// 执行名称
			sb.append("package " + basePackageName + ".dao.impl;\n\n");
			sb.append("import java.util.List;\n");
			sb.append("import " + basePackageName + ".dao." + className + "Dao;\n\n");
			sb.append("import cn.com.starsoft.jq.common.page.entity.Page;\n"); // 后续记录到数据库中
			sb.append("import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport; ");
			sb.append("\nimport " + basePackageName + ".entity." + className + ";\n\n");

			sb.append("/**\n *<p>\n *  " + aliseName + " 数据库访问层实现类  \n *</p> \n * @author: " + buildTask.getBuildConfig().getAuthor());
			sb.append("\n * @创建时间：" + DateUtil.getDateTime(new Date()) + "");
			sb.append("\n * @产品: " + buildTask.getBuildConfig().getProduct() + "\n * @version:" + buildTask.getBuildConfig().getVersion() + "\n*/ ");

			sb.append("\npublic class " + className + "DaoImpl extends SqlMapClientDaoSupport implements " + className + "Dao { \n\n");

			// 添加
			sb.append("\n\tpublic void add" + className + "(" + entityName + " vo)  throws Exception {\n");
			sb.append("\t\tsuper.getSqlMapClientTemplate().insert(\"" + statement_name + ".add" + className + "\", vo);");
			sb.append("\n\t}");

			// 修改
			sb.append("\n\n\tpublic void update" + className + "(" + entityName + " vo)  throws Exception {\n");
			sb.append("\t\tsuper.getSqlMapClientTemplate().update(\"" + statement_name + ".update" + className + "\", vo);");
			sb.append("\n\t}");

			// 删除
			sb.append("\n\n\tpublic void delete" + className + "(String " + getLowerName(className) + "Id)  throws Exception {");
			sb.append("\n\t\tsuper.getSqlMapClientTemplate().delete(\"" + statement_name + "\n\t\t\t.delete" + className + "\"," + getLowerName(className) + "Id);");
			sb.append("\n\t}");

			// 主键ID查询
			sb.append("\n\n\tpublic " + entityName + " query" + className + "By" + className + "Id (String " + getLowerName(className) + "Id)  throws Exception {\n\n");
			sb.append("\t\t" + className + " vo = (" + className + ")super.getSqlMapClientTemplate()\n\t\t\t.queryForObject(\"" + statement_name + ".query" + className + "ById\" , " + getLowerName(className) + "Id);");
			sb.append("\n\t\treturn vo;\n\t}");

			// 集合分页查询
			sb.append("\n\n\t@SuppressWarnings(\"unchecked\")");
			sb.append("\n\tpublic List<" + entityName + "> query" + className + "List(Page page)  throws Exception {\n");
			sb.append("\t\tInteger count = (Integer)getSqlMapClientTemplate()\n\t\t\t.queryForObject(\"" + statement_name + ".query" + className + "RowCount\", page);");
			sb.append("\n\t\tpage.setRowCount(count).commonInit();");
			sb.append("\n\t\tList<" + entityName + "> " + className + "List = getSqlMapClientTemplate()\n\t\t\t.queryForList(\"" + statement_name + ".query" + className + "Page\", page);");
			sb.append("\n\t\treturn  " + className + "List;\n\t}");

			sb.append("\n\n }");
			return result.setReturnRightValue(sb);
		} catch (Exception e) {
			logger.error("根据表资源对象渲染IbatisDao实现类出现异常,原因:" + ExceptionUtil.getStackTrace(e.fillInStackTrace()));
			return result.setReturnErrorMsg("根据表资源对象渲染IbatisDao实现类出现异常。");
		}

	}
}
