package com.zhuoxuan.xingtian.res.service;

import java.util.List;

import com.zhuoxuan.common.exception.XTServiceException;
import com.zhuoxuan.common.result.ResultBase;
import com.zhuoxuan.xingtian.res.entity.FieldDO;

/**
 * @description：数据表对应的列信息业务处理接口
 * @date 2013-12-13 下午06:08:11
 * @version JQ应用开发支撑平台
 * @author：高江涛
 */
public interface FieldService {
	
	
	/**
	 * 查询数据表下对应的列信息
	 * @param tableId
	 * @return
	 * @throws XTServiceException
	 */
	public ResultBase<List<FieldDO>> queryFieldListByTableId(String tableId) throws XTServiceException;

}
