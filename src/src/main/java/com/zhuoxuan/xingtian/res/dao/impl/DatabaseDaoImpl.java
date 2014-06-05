package com.zhuoxuan.xingtian.res.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.zhuoxuan.common.exception.JQDaoException;
import com.zhuoxuan.common.page.Page;
import com.zhuoxuan.xingtian.res.dao.DatabaseDao;
import com.zhuoxuan.xingtian.res.entity.DatabaseDO;

/**
 * <p>
 * 数据库 DAO 实现类
 * </p>
 * @author 高江涛 @创建时间：Jul 9, 2012 1:15:07 PM
 * 
 * @产品: XTSupportPlateform @version： V1.0
 */
public class DatabaseDaoImpl extends SqlMapClientDaoSupport implements
		DatabaseDao {

	public void addDatabase(DatabaseDO vo) throws JQDaoException {

		super.getSqlMapClientTemplate().insert("database.addDatabase", vo);

	}

	public void updateDatabase(DatabaseDO vo) throws JQDaoException {

		super.getSqlMapClientTemplate().update("database.updateDatabase", vo);

	}

	@SuppressWarnings("unchecked")
	public List<DatabaseDO> queryDatabase(Page page) throws JQDaoException {

		Long count = (Long) super.getSqlMapClientTemplate().queryForObject(
				"database.queryDatabaseCount", page);

		page.setRowCount(count.intValue());
		page.commonInit();

		List<DatabaseDO> dbs = (List<DatabaseDO>) super.getSqlMapClientTemplate()
				.queryForList("database.queryDatabasePage", page);

		return dbs;
	}

	public DatabaseDO queryDatabaseById(String databaseId) throws JQDaoException {

		DatabaseDO vo = (DatabaseDO) super.getSqlMapClientTemplate()
				.queryForObject("database.queryDatabaseById", databaseId);

		return vo;
	}

	public List<DatabaseDO> queryDatabase() throws JQDaoException {

		@SuppressWarnings("unchecked")
		List<DatabaseDO> dbs = (List<DatabaseDO>) super.getSqlMapClientTemplate()
				.queryForList("database.queryDatabaseList");

		return dbs;
	}

}
