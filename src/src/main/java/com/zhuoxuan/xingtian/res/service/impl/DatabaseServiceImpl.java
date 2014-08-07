package com.zhuoxuan.xingtian.res.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.zhuoxuan.common.exception.JQDaoException;
import com.zhuoxuan.common.exception.XTServiceException;
import com.zhuoxuan.common.page.Page;
import com.zhuoxuan.common.result.ResultBase;
import com.zhuoxuan.common.util.ExceptionUtil;
import com.zhuoxuan.xingtian.res.dao.DatabaseDao;
import com.zhuoxuan.xingtian.res.dao.TableDao;
import com.zhuoxuan.xingtian.res.entity.DatabaseDO;
import com.zhuoxuan.xingtian.res.entity.TableDO;
import com.zhuoxuan.xingtian.res.service.DatabaseDelegateService;
import com.zhuoxuan.xingtian.res.service.DatabaseService;

/**
 * <p>
 * 数据库 Service 实现类
 * </p>
 * 
 * @author 高江涛
 * @创建时间：Jul 9, 2012 1:08:43 PM
 * @产品: JQSupportPlateform
 * @version： V1.0
 */

@Service("databaseService")
public class DatabaseServiceImpl implements DatabaseService {

	@Resource
	private DatabaseDao dbDao;
	@Resource
	private TableDao tableDao;
	
	@Resource
	private DatabaseDelegateService databaseDelegateService;

	private  final Logger logger = LoggerFactory.getLogger(this.getClass());

	public boolean insertDatabase(DatabaseDO vo) throws XTServiceException {
		try {
			dbDao.addDatabase(vo);
			//LogContext.configLogContent("保存数据资源信息成功，业务名称是：" + vo.getBusinessName());
			return true;
		} catch (JQDaoException e) {
			logger.error("DatabaseServiceImpl:insertDatabase has error ,the cause is : " + e.getCause());
			return false;
		}

	}

	public boolean insertTableListBatch(List<TableDO> tables) throws XTServiceException {
		try {
			// 类名规则设置
			tableDao.addTableListBatch(tables);
			return true;
		} catch (JQDaoException e) {
			logger.error("DatabaseServiceImpl:insertTableListBatch has error ,the cause is : " + e.getCause());
			return false;
		}

	}

	public boolean modifyDatabase(DatabaseDO vo) throws XTServiceException {
		try {
			dbDao.updateDatabase(vo);
			return true;
		} catch (JQDaoException e) {
			logger.error("DatabaseServiceImpl:modifyDBStatus has error ,the cause is : " + e.getCause());
			return false;
		}

	}

	public DatabaseDO queryDatabaseById(String databaseId) throws XTServiceException {
		return dbDao.queryDatabaseById(databaseId);
	}

	public List<DatabaseDO> queryDatabaseList(Page page) throws XTServiceException {
		List<DatabaseDO> dbs = new ArrayList<DatabaseDO>();
		try {
			dbs = dbDao.queryDatabase(page);
		} catch (JQDaoException e) {
			logger.error("DatabaseServiceImpl:queryDatabaseList has error ,the cause is : " + e.getCause());
		}
		return dbs;
	}

	public List<DatabaseDO> queryDatabaseList() throws XTServiceException {
		List<DatabaseDO> dbs = dbDao.queryDatabase();
		return dbs;
	}

	public void setDbDao(DatabaseDao dbDao) {
		this.dbDao = dbDao;
	}

	public void setTableDao(TableDao tableDao) {
		this.tableDao = tableDao;
	}

	public boolean cleanUpResouceReferenceDbId(String databaseId) throws XTServiceException {
		try {
			// 删除引用数据库的列
			tableDao.deleteDbFieldList(databaseId);
			 
			// 删除表和数据库资源的关系
			tableDao.deleteDbTableList(databaseId);

			return true;
		} catch (JQDaoException e) {
			logger.error("处理数据库清除资源业务失败，原因：" + ExceptionUtil.getStackTrace(e.fillInStackTrace()));
			return false;
		}
	}

	@Override
	public ResultBase<Boolean> initDataBaseResource(String databaseId) throws XTServiceException {
		return databaseDelegateService.initDatabase(databaseId);
	}

}
