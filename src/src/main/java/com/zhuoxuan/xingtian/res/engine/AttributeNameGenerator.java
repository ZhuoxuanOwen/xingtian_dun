package com.zhuoxuan.xingtian.res.engine;

import com.zhuoxuan.common.exception.XTServiceException;

/**
 * <p>    属性名称生成器    </p>
 *  @author 高江涛
 * @创建时间：Jul 11, 2012 9:33:52 AM
 * @产品: JQSupportPlateform
 * @version： V1.0
 */
public interface AttributeNameGenerator {
	
	/**
	 * <p> 根据数据库表的字段类型生成实体属性的名称 </p>
	 * @param field_type
	 * @return String
	 * @throws XTServiceException  
	 */
	public String generateAttributeName(String field_name) throws XTServiceException;

}
