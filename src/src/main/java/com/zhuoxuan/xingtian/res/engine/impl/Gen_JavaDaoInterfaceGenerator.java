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
public class Gen_JavaDaoInterfaceGenerator extends CodeTemplateGeneratorEngine {

	private static final Logger logger = Logger.getLogger(Gen_JavaDaoInterfaceGenerator.class);

	@Override
	public ResultBase<StringBuilder> generatorTemplateCode(BuildTaskDO buildTaskDO, TableDO tableDO) {

		ResultBase<StringBuilder> result = new ResultBase<StringBuilder>();
		try {
			StringBuilder sb = new StringBuilder();
			String basePackageName = buildTaskDO.getBuildConfig().getPackagePath();
			String className = tableDO.getClassName();
			String entityName = className + buildTaskDO.getBuildConfig().getJavaDoSuffix();
			String aliseName = tableDO.getBusinessName() != null ? tableDO.getBusinessName() : tableDO.getClassName();
			if (StringUtil.isEmpty(aliseName)) {
				aliseName = tableDO.getClassName();
			}
			
			sb.append("package " + basePackageName + ".dao;\n\n");
			sb.append("import java.util.List;\n");
			sb.append("import cn.com.starsoft.jq.common.page.entity.Page;\n"); // 后续记录到数据库中
			sb.append("import " + basePackageName + ".entity." + className + ";\n\n");

			sb.append("/**\n *<p>\n *  " + aliseName + " 数据库访问层接口  \n *</p> \n * @author: " + buildTaskDO.getBuildConfig().getAuthor());
			sb.append("\n * @创建时间：" + DateUtil.getDateTime(new Date()) + "");
			sb.append("\n * @产品: " + buildTaskDO.getBuildConfig().getProduct() + "\n * @version:" + buildTaskDO.getBuildConfig().getVersion() + "\n*/ ");

			sb.append("\npublic interface " + className + "Dao { \n\n");

			sb.append("\n\t/** \n\t * 添加" + aliseName);
			sb.append("\n\t * @param " + entityName + " vo  " + aliseName + " 实体对象");
			sb.append("\n\t * @throws Exception 抛出异常 \n\t */");
			sb.append("\n\tpublic void add" + className + "(" + entityName + " vo)  throws Exception;\n\n");

			sb.append("\n\t/** \n\t * 修改" + aliseName);
			sb.append("\n\t * @param " + entityName + " vo  " + aliseName + " 实体对象");
			sb.append("\n\t * @throws Exception 抛出异常 \n\t */");
			sb.append("\n\tpublic void update" + className + "(" + entityName + " vo)  throws Exception;\n\n");

			sb.append("\n\t/** \n\t * 删除" + aliseName);
			sb.append("\n\t * @param " + className + "Id  " + entityName + "主键ID");
			sb.append("\n\t * @throws Exception 抛出异常 \n\t */");
			sb.append("\n\tpublic void delete" + className + "(String " + entityName + "Id)  throws Exception;\n\n");

			sb.append("\n\t/** \n\t * 按照ID查询" + aliseName+"对象");
			sb.append("\n\t * @param " + className + "Id  " + entityName + "主键ID");
			sb.append("\n\t * @throws Exception 抛出异常 \n\t */");
			sb.append("\n\tpublic " + entityName + " query" + className + "By" + className + "Id(String id)  throws Exception;\n\n");
			
			sb.append("\n\t/** \n\t * 按照分页对象查询" + aliseName);
			sb.append("\n\t * @param Page page 分页实体对象");
			sb.append("\n\t * @throws Exception 抛出异常 \n\t */");
			sb.append("\n\tpublic List<" + entityName + ">  query" + className + "List(Page page)  throws Exception;\n\n");

			sb.append("\n\n }");
			return result.setReturnRightValue(sb);
		} catch (Exception e) {
			logger.error("根据表资源对象渲染avaDaoInterface出现异常,原因:" + ExceptionUtil.getStackTrace(e.fillInStackTrace()));
			return result.setReturnErrorMsg("根据表资源对象渲染avaDaoInterface出现异常。");
		}

	}
}
