package com.zhuoxuan.xingtian.res.service;

import java.util.List;

import com.zhuoxuan.common.page.Page;
import com.zhuoxuan.common.result.ResultBase;
import com.zhuoxuan.xingtian.res.entity.MongodbDO;

/**
 *<p>
 *  Mongodb 数据库访问层接口  
 *</p> 
 * @author: 卓轩
 * @创建时间：2014-06-04 17:00:07
 * @产品: 刑天盾开发平台
 * @version:1.0
*/  
public interface MongodbService {
	
	/**
	 * 查询mongdodb 信息数据分页查询
	 * @param page
	 * @return
	 */
	public List<MongodbDO> queryMongodbList(Page page);
	
	/**
	 * 测试mongdo server的链接是否正常
	 * @param mongodbId mongodb Id
	 * @return 测试结果,以及错误消息
	 */
	public ResultBase<String> testMongoConnection(Integer mongodbId);

	/**
	 * 获取mongodb server 下所有的db实例
	 * @param mongodbId
	 * @return
	 */
	public ResultBase<List<String>> getMongoServerListDB(Integer mongodbId);
	

}
