package com.zhuoxuan.xingtian.res.service;

import com.zhuoxuan.common.exception.XTServiceException;
import com.zhuoxuan.common.result.ResultBase;

/**
 * @description：
 * @date 2013-12-13 上午10:54:19
 * @version starsoft.devbase 1.0.0
 * @author：高江涛
 */
public interface DatabaseDelegateService {
	
	
	/**
	 * 初始化数据库资源
	 * @param databaseId  数据库资源ID
	 * @return
	 * @throws XTServiceException
	 */
	public ResultBase<Boolean> initDatabase(String databaseId) throws XTServiceException;

	
	
}
