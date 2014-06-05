package com.zhuoxuan.xingtian.res.engine.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.zhuoxuan.common.result.ResultBase;
import com.zhuoxuan.common.util.DateUtil;
import com.zhuoxuan.common.util.ExceptionUtil;
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
public class Gen_JavaServiceImplGenerator extends CodeTemplateGeneratorEngine {

	private static final Logger logger = Logger.getLogger(Gen_JavaServiceImplGenerator.class);

	@Override
	public ResultBase<StringBuilder> generatorTemplateCode(BuildTaskDO buildTask , TableDO tableDO) {

		ResultBase<StringBuilder> result = new ResultBase<StringBuilder>();
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("package com.starsoft.jq.entity;\n\n");
			sb.append("import java.io.Serializable;\n\n");
			sb.append("/**\n * 描述：" + tableDO.getTableDesc() + "  \n * @author 高江涛  \n * Date " + DateUtil.getDateTime(new Date()) + " \n */ \n\n");
			sb.append("public class " + tableDO.getClassName() + " implements Serializable { \n\n ");
			sb.append("\tprivate static final long serialVersionUID = 1L; \n\n");
			String attr = null;
			List<FieldDO> fields = tableDO.getFields();
			// 属性
			for (int i = 0; i < fields.size(); i++) {
				FieldDO cv = fields.get(i);
				attr = cv.getAttrName();
				if (attr == null) {
					sb.append("\tprivate String " + cv.getFieldName().toLowerCase() + ";\n");
				} else {
					sb.append("\tprivate String " + attr + ";\n");
				}
			}
			// setter 、 getter 方法
			for (int i = 0; i < fields.size(); i++) {
				FieldDO cv = fields.get(i);
				attr = cv.getAttrName();
				if (attr == null) {
					sb.append("\n\tpublic void set" + this.getFieldName(cv.getAttrName().toLowerCase()) + "(String " + cv.getAttrName().toLowerCase() + "){\n\t\tthis." + cv.getAttrName().toLowerCase()
							+ "=" + cv.getAttrName().toLowerCase() + ";\n\t}\n");
					sb.append("\n\tpublic String get" + getFieldName(cv.getAttrName().toLowerCase()) + "(){\n\t\treturn " + cv.getAttrName().toLowerCase() + ";\n\t}\n");
				} else {
					sb.append("\n\tpublic void set" + this.getFieldName(attr) + "(String " + attr + "){\n\t\tthis." + attr + "=" + attr + ";\n\t}\n");
					sb.append("\n\tpublic String get" + getFieldName(attr) + "(){\n\t\treturn " + attr + ";\n\t}\n");
				}
			}
			sb.append("\n}");
			return result.setReturnRightValue(sb);
		} catch (Exception e) {
			logger.error("根据表资源对象渲染JavaDO出现异常,原因:" + ExceptionUtil.getStackTrace(e.fillInStackTrace()));
			return result.setReturnErrorMsg("根据表资源对象渲染JavaDO出现异常。");
		}

	}
}
