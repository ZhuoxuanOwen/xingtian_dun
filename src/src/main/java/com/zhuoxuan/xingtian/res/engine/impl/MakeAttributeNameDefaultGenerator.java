package com.zhuoxuan.xingtian.res.engine.impl;


import com.zhuoxuan.common.exception.XTServiceException;
import com.zhuoxuan.xingtian.res.engine.AttributeNameGenerator;
/**
 * <p>    属性名称默认生成器  驼峰式命名  </p>
 *  @author 高江涛
 * @创建时间：Jul 11, 2012 9:33:52 AM
 * @产品: JQSupportPlateform
 * @version： V1.0
 */
public class MakeAttributeNameDefaultGenerator implements AttributeNameGenerator {

	public String generateAttributeName(String field_name) throws XTServiceException {
		
		field_name = field_name.toLowerCase();
		int _index = field_name.indexOf("_");
		if (_index < 0) {
			return field_name;
		}
		
		String c_name_l = field_name.substring(0, _index );
		String c_name_m = field_name.substring(_index +1 , _index + 2);
		String c_name_r = field_name.substring(_index +2, field_name.length());
		
		String c_name = c_name_l  + c_name_m.toUpperCase()+ c_name_r;
		if (c_name.indexOf("_") > 0) {
			_index = c_name.indexOf("_");
			c_name_l = c_name.substring(0, _index );
			c_name_m = c_name.substring(_index +1, _index +2);
			c_name_r = c_name.substring(_index +2, c_name.length());
			
			c_name = c_name_l + c_name_m.toUpperCase() + c_name_r;
			
			if (c_name.indexOf("_") > 0) {
				_index = c_name.indexOf("_");
				c_name_l = c_name.substring(0, _index );
				c_name_m = c_name.substring(_index +1, _index +2);
				c_name_r = c_name.substring(_index +2, c_name.length());
				
				c_name = c_name_l + c_name_m.toUpperCase() + c_name_r;
				return c_name;
				
			}
			return c_name;
			
		}else {
			return c_name;
		}
	}

	
}
