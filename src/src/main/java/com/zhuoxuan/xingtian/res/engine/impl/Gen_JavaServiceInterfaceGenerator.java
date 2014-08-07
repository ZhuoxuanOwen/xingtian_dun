package com.zhuoxuan.xingtian.res.engine.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
public class Gen_JavaServiceInterfaceGenerator extends CodeTemplateGeneratorEngine {

	private  final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public ResultBase<StringBuilder> generatorTemplateCode(BuildTaskDO buildTask , TableDO tableDO) {

		ResultBase<StringBuilder> result = new ResultBase<StringBuilder>();
		try {
			
			StringBuilder sb = new StringBuilder();
			String basePackageName = buildTask.getBuildConfig().getPackagePath();
			String className = tableDO.getClassName();
			//String entityName = className + buildTask.getBuildConfig().getJavaDoSuffix();
			String aliseName = tableDO.getBusinessName() != null ? tableDO.getBusinessName() : tableDO.getTableDesc();
			if (StringUtil.isEmpty(aliseName)) {
				aliseName = tableDO.getClassName();
			}
			
			sb.append("package " + basePackageName + ".service.impl;\n");
			sb.append("import java.util.List;\n");
			sb.append("import " + basePackageName + ".entity." + className + ";\n");
			sb.append("import " + basePackageName + ".dao." + className + "Dao;");
			sb.append("import org.apache.log4j.Logger;");
			sb.append("import " + basePackageName + ".service." + className + "Service;");
			sb.append("import cn.com.starsoft.jq.common.page.entity.Page;\n"); // 后续记录到数据库中

			sb.append("/**\n *<p>\n *  " + aliseName + " 数据库访问层接口  \n *</p> \n * @author: " + buildTask.getBuildConfig().getAuthor());
			sb.append("\n * @创建时间：" + DateUtil.getDateTime(new Date()) + "");
			sb.append("\n * @产品: " + buildTask.getBuildConfig().getProduct() + "\n * @version:" + buildTask.getBuildConfig().getVersion() + "\n*/ ");

			sb.append("public class " + className + "ServiceImpl implements " + className + "Service {\n\n");

			// 注入数据库访问层对象
			sb.append("private " + className + "Dao " + getLowerName(className) + "Dao;\n\n");
			// Logger4j
			sb.append("private static final Logger logger = Logger.getLogger(" + className + "ServiceImpl.class);\n\n");

			sb.append("public boolean insert" + className + "(" + className + " vo){\n\n"); // 添加
			sb.append("	try { " + getLowerName(className) + "Dao.add" + className + "(vo); return true;} catch (Exception e) {");
			sb.append(" logger.error(\"" + className + "ServiceImpl:insert" + className + " has error ,the cause is:\" + e.getCause());  ");
			sb.append("return false;} \n } \n\n");

			sb.append("public boolean modify" + className + "(" + className + " vo ){\n\n"); // 修改
			sb.append("	try { " + getLowerName(className) + "Dao.update" + className + "(vo); return true;} catch (Exception e) {");
			sb.append(" logger.error(\"" + className + "ServiceImpl:modify" + className + " has error ,the cause is:\" + e.getCause());  ");
			sb.append("return false;} \n } \n\n");

			sb.append("public boolean remove" + className + "(String id){\n\n"); // 删除
			sb.append("	try { " + getLowerName(className) + "Dao.delete" + className + "(id); return true;} catch (Exception e) {");
			sb.append(" logger.error(\"" + className + "ServiceImpl:remove" + className + " has error ,the cause is:\" + e.getCause());  ");
			sb.append("return false;} \n } \n\n");

			sb.append("public " + className + " query" + className + "ById(String " + getLowerName(className) + "Id){"); // ID查询
			sb.append("	" + className + " " + getLowerName(className) + " = null; try {  " + getLowerName(className) + " = " + getLowerName(className) + "Dao.query" + className + "By" + className + "Id(" + getLowerName(className) + "Id);");
			sb.append(" } catch (Exception e) { logger.error(\"" + className + "ServiceImpl:query" + className + "ById has error ,the cause is:\" + e.getCause()); } ");
			sb.append(" return  " + getLowerName(className) + ";} \n\n");

			sb.append("public List<" + className + "> query" + className + "List(Page page){ \n\n"); // 分页查询
			sb.append("List< " + className + "> " + getLowerName(className) + "List = null; try { " + getLowerName(className) + "List = " + getLowerName(className) + "Dao.query" + className + "List(page);");
			sb.append("} catch (Exception e) { logger.error(\" " + className + "ServiceImpl:query" + className + "List(Page) has error ,the cause is:\" + e.getCause()); }");

			sb.append("return " + getLowerName(className) + "List; } \n\n");

			// 数据库访问层对象setter方法
			sb.append(" public void set" + className + "Dao(" + className + "Dao " + getLowerName(className) + "Dao) {  this." + getLowerName(className) + "Dao = " + getLowerName(className) + "Dao;  } ");

			sb.append("\n } \n");
			return result.setReturnRightValue(sb);
		} catch (Exception e) {
			logger.error("根据表资源对象渲染JavaDO出现异常,原因:" + ExceptionUtil.getStackTrace(e.fillInStackTrace()));
			return result.setReturnErrorMsg("根据表资源对象渲染JavaDO出现异常。");
		}

	}
}
