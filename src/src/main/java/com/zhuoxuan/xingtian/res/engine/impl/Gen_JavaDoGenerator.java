package com.zhuoxuan.xingtian.res.engine.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zhuoxuan.common.result.ResultBase;
import com.zhuoxuan.common.util.DateUtil;
import com.zhuoxuan.common.util.ExceptionUtil;
import com.zhuoxuan.common.util.StringUtil;
import com.zhuoxuan.xingtian.res.engine.CodeTemplateGeneratorEngine;
import com.zhuoxuan.xingtian.res.entity.BuildTaskDO;
import com.zhuoxuan.xingtian.res.entity.FieldDO;
import com.zhuoxuan.xingtian.res.entity.TableDO;

/**
 * @description：JavaDO对象生成
 * @date 2013-12-15 下午04:56:25
 * @version JQ应用开发支撑平台
 * @author：高江涛
 */
public class Gen_JavaDoGenerator extends CodeTemplateGeneratorEngine {

	private  final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public ResultBase<StringBuilder> generatorTemplateCode(BuildTaskDO buildTask, TableDO tableDO) {

		ResultBase<StringBuilder> result = new ResultBase<StringBuilder>();
		try {
			
			String aliseName = tableDO.getBusinessName() != null ? tableDO.getBusinessName() : tableDO.getClassName();
			if (StringUtil.isEmpty(aliseName)) {
				aliseName = tableDO.getClassName();
			}
			StringBuilder sb = new StringBuilder();
			sb.append("package " + buildTask.getBuildConfig().getPackagePath() + ";\n\n");
			sb.append("import java.io.Serializable;\n");
			sb.append("import java.util.Date;\n\n");
			sb.append("/**\n *<p>\n *  " + aliseName + "DO 实体  \n *</p> \n * @author: " + buildTask.getBuildConfig().getAuthor());
			sb.append("\n * @创建时间：" + DateUtil.getDateTime(new Date()) + "");
			sb.append("\n * @产品: " + buildTask.getBuildConfig().getProduct() + "\n * @version:" + buildTask.getBuildConfig().getVersion() + "\n*/\n\n ");

			sb.append("public class " + tableDO.getClassName() + buildTask.getBuildConfig().getJavaDoSuffix() + " implements Serializable { \n\n ");
			sb.append("\tprivate static final long serialVersionUID = 1L; \n\n");
			String attr = null;
			List<FieldDO> fields = tableDO.getFields();
			// 属性
			for (int i = 0; i < fields.size(); i++) {
				FieldDO cv = fields.get(i);
				attr = cv.getAttrName();
				
				sb.append("\n\t/**\n\t * "+ getAliasName(cv) + "\n\t*/\n");
				if (attr == null) {
					sb.append("\tprivate String " + cv.getFieldName()+ ";\n");
				} else {
					sb.append("\tprivate "+cv.getAttrType()+" " + attr + ";\n");
				}
			}
			// setter 、 getter 方法
			for (int i = 0; i < fields.size(); i++) {
				FieldDO cv = fields.get(i);
				attr = cv.getAttrName();
				sb.append("\n\t/**\n\t * setter for  "+ getAliasName(cv) + "\n\t*/");
				//setter
				if (attr == null) {
					sb.append("\n\tpublic void set" + this.getFieldName(cv.getAttrName()) + "(String " + cv.getAttrName() + "){\n\t\tthis."
							+ cv.getAttrName() + "=" + cv.getAttrName() + ";\n\t}\n");
				} else {
					sb.append("\n\tpublic void set" + this.getFieldName(attr) + "("+cv.getAttrType()+" " + attr + "){\n\t\tthis." + attr + "=" + attr + ";\n\t}\n");
				}
				//getter
				sb.append("\n\t/**\n\t * getter for  "+ getAliasName(cv) + "\n\t*/");
				if (attr == null) {
					sb.append("\n\tpublic "+cv.getAttrType()+" get" + getFieldName(cv.getAttrName()) + "(){\n\t\treturn " + cv.getAttrName() + ";\n\t}\n");
				} else {
					sb.append("\n\tpublic "+cv.getAttrType()+" get" + getFieldName(attr) + "(){\n\t\treturn " + attr + ";\n\t}\n");
				}
			}
			sb.append("\n}");
			return result.setReturnRightValue(sb);
		} catch (Exception e) {
			logger.error("根据表资源对象渲染JavaDO出现异常,原因:" + ExceptionUtil.getStackTrace(e.fillInStackTrace()));
			return result.setReturnErrorMsg("根据表资源对象渲染JavaDO出现异常。");
		}

	}
	
	private String getAliasName(FieldDO cv){
		if(StringUtil.isEmpty(cv.getBusinessName())){
			return cv.getAttrName();
		}else{
			return cv.getBusinessName();
		}
	}
}
