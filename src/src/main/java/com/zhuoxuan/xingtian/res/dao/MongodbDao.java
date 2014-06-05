package com.zhuoxuan.xingtian.res.dao;
 
import java.util.List;

import com.zhuoxuan.common.page.Page;
import com.zhuoxuan.xingtian.res.entity.MongodbDO;
 

/**
 *<p>
 *  Mongodb 数据库访问层接口  
 *</p> 
 * @author: 卓轩
 * @创建时间：2014-06-04 16:55:35
 * @产品: 刑天盾开发平台
 * @version:1.0
*/ 
public interface MongodbDao { 


	/** 
	 * 添加Mongodb
	 * @param MongodbDO vo  Mongodb 实体对象
	 * @throws Exception 抛出异常 
	 */
	public void addMongodb(MongodbDO vo)  throws Exception;


	/** 
	 * 修改Mongodb
	 * @param MongodbDO vo  Mongodb 实体对象
	 * @throws Exception 抛出异常 
	 */
	public void updateMongodb(MongodbDO vo)  throws Exception;


	/** 
	 * 删除Mongodb
	 * @param MongodbId  MongodbDO主键ID
	 * @throws Exception 抛出异常 
	 */
	public void deleteMongodb(String MongodbDOId)  throws Exception;


	/** 
	 * 按照ID查询Mongodb对象
	 * @param MongodbId  MongodbDO主键ID
	 * @throws Exception 抛出异常 
	 */
	public MongodbDO queryMongodbByMongodbId(String id)  throws Exception;


	/** 
	 * 按照分页对象查询Mongodb
	 * @param Page page 分页实体对象
	 * @throws Exception 抛出异常 
	 */
	public List<MongodbDO>  queryMongodbList(Page page)  throws Exception;



 }