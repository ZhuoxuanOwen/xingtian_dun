package com.zhuoxuan.xingtian.res.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.ObjectUtils;
import org.apache.log4j.Logger;

import com.mongodb.Mongo;
import com.zhuoxuan.common.page.Page;
import com.zhuoxuan.common.result.ResultBase;
import com.zhuoxuan.xingtian.res.dao.MongodbDao;
import com.zhuoxuan.xingtian.res.entity.MongodbDO;
import com.zhuoxuan.xingtian.res.service.MongodbService;

/**
 * <p>
 * Mongodb 数据库访问层实现类
 * </p>
 * 
 * @author: 卓轩
 * @创建时间：2014-06-04 17:00:07
 * @产品: 刑天盾开发平台
 * @version:1.0
 */
public class MongodbServiceImpl implements MongodbService {

	@Resource
	private MongodbDao mongodbDao;

	private static final Logger logger = Logger.getLogger(MongodbServiceImpl.class);

	public boolean insertMongodb(MongodbDO vo) {

		try {
			mongodbDao.addMongodb(vo);
			return true;
		} catch (Exception e) {
			logger.error("MongodbServiceImpl:insertMongodb has error ,the cause is:"
					+ e.getCause());
			return false;
		}
	}

	public boolean modifyMongodb(MongodbDO vo) {

		try {
			mongodbDao.updateMongodb(vo);
			return true;
		} catch (Exception e) {
			logger.error("MongodbServiceImpl:modifyMongodb has error ,the cause is:"
					+ e.getCause());
			return false;
		}
	}

	public boolean removeMongodb(String id) {

		try {
			mongodbDao.deleteMongodb(id);
			return true;
		} catch (Exception e) {
			logger.error("MongodbServiceImpl:removeMongodb has error ,the cause is:"
					+ e.getCause());
			return false;
		}
	}

	public MongodbDO queryMongodbById(String mongodbId) {
		MongodbDO mongodb = null;
		try {
			mongodb = mongodbDao.queryMongodbByMongodbId(mongodbId);
		} catch (Exception e) {
			logger.error("MongodbServiceImpl:queryMongodbById has error ,the cause is:"
					+ e.getCause());
		}
		return mongodb;
	}

	public List<MongodbDO> queryMongodbList(Page page) {

		List<MongodbDO> mongodbList = null;
		try {
			mongodbList = mongodbDao.queryMongodbList(page);
		} catch (Exception e) {
			logger.error(" MongodbServiceImpl:queryMongodbList(Page) has error ,the cause is:"
					+ e.getCause());
		}
		return mongodbList;
	}

	public void setMongodbDao(MongodbDao mongodbDao) {
		this.mongodbDao = mongodbDao;
	}

	@Override
	public ResultBase<String> testMongoConnection(Integer mongodbId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultBase<List<String>> getMongoServerListDB(Integer mongodbId) {	
		ResultBase<List<String>> result = new ResultBase<List<String>>();
		try {
			//查询mongdodb实例信息
			MongodbDO mongodbDO = mongodbDao.queryMongodbByMongodbId(String.valueOf(mongodbId));
			if(mongodbDO == null){
				return result.setReturnErrorMsg("对应的mongodb信息实例不存在");
			}
			//链接mongdodb 实例
		    Mongo mongo = new Mongo(mongodbDO.getServerAddress(), mongodbDO.getServerPort());

		    List<String> mongodbList = mongo.getDatabaseNames();
		    
		    return result.setReturnRightValue(mongodbList);
		} catch (Exception e) {
			
			return result.setReturnErrorMsg("获取数据库列表异常，"+e.getMessage());
		}
		 
	}
}
