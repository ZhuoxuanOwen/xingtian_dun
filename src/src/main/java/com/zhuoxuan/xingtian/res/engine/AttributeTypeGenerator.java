package com.zhuoxuan.xingtian.res.engine;

import com.zhuoxuan.common.exception.XTServiceException;

/**
 * <p>    属性类型生成器    </p>
 *  @author 高江涛
 * @创建时间：Jul 11, 2012 9:35:52 AM
 * @产品: JQSupportPlateform
 * @version： V1.0
 */
public interface AttributeTypeGenerator {
	
		/**
		 * <p> 根据数据库的类型生成实体属性的类型 </p>
		 * @param field_type
		 * @return String
		 * @throws XTServiceException  
		 */
	public String generateAttributeType(String field_type) throws XTServiceException;

}
