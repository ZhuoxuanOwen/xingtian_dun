package com.zhuoxuan.xingtian.res.engine.impl;


import com.zhuoxuan.common.exception.XTServiceException;
import com.zhuoxuan.xingtian.res.engine.AttributeTypeGenerator;

/**
 * <p>   默认属性类型生成器    </p>
 *  @author 高江涛
 * @创建时间：Jul 11, 2012 9:35:52 AM
 * @产品: JQSupportPlateform
 * @version： V1.0
 */
public class MakeAttributeTypeDefaultGenerator implements AttributeTypeGenerator {

	public String generateAttributeType(String field_type)  throws XTServiceException {
		
		field_type = field_type.toLowerCase();
		if (field_type.indexOf("int") > -1) {
			return "Integer";
		}else if ("float".equals(field_type) ) {
			return "Double";
		}else if ("varchar".equals(field_type) || "varchar2".equals(field_type) || "char".equals(field_type)) {
			return "String";
		}else if ("datetime".equals(field_type)) {
			return "Date";
		}
		return "String";
	}

}
