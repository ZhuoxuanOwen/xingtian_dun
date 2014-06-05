package com.zhuoxuan.xingtian.res.dao.impl;
 

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.zhuoxuan.common.page.Page;
import com.zhuoxuan.xingtian.res.dao.MongodbDao;
import com.zhuoxuan.xingtian.res.entity.MongodbDO;

/**
 *<p>
 *  MongodbDO 数据库访问层实现类  
 *</p> 
 * @author: 卓轩
 * @创建时间：2014-06-04 16:57:55
 * @产品: 刑天盾开发平台
 * @version:1.0
*/ 
public class MongodbDaoImpl extends SqlMapClientDaoSupport implements MongodbDao { 


	public void addMongodb(MongodbDO vo)  throws Exception {
		super.getSqlMapClientTemplate().insert("mongodbmanage.addMongodb", vo);
	}

	public void updateMongodb(MongodbDO vo)  throws Exception {
		super.getSqlMapClientTemplate().update("mongodbmanage.updateMongodb", vo);
	}

	public void deleteMongodb(String mongodbId)  throws Exception {
		super.getSqlMapClientTemplate().delete("mongodbmanage.deleteMongodb",mongodbId);
	}

	public MongodbDO queryMongodbByMongodbId (String mongodbId)  throws Exception {

		MongodbDO vo = (MongodbDO)super.getSqlMapClientTemplate()
			.queryForObject("mongodbmanage.queryMongodbById" , mongodbId);
		return vo;
	}

	@SuppressWarnings("unchecked")
	public List<MongodbDO> queryMongodbList(Page page)  throws Exception {
		Integer count = (Integer)getSqlMapClientTemplate()
			.queryForObject("mongodbmanage.queryMongodbRowCount", page);
		page.setRowCount(count).commonInit();
		List<MongodbDO> MongodbList = getSqlMapClientTemplate()
			.queryForList("mongodbmanage.queryMongodbPage", page);
		return  MongodbList;
	}

 }