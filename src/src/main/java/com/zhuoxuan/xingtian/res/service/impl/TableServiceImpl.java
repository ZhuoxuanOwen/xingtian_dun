package com.zhuoxuan.xingtian.res.service.impl;

import java.util.List;

import javax.annotation.Resource;

import jxl.common.Logger;

import com.zhuoxuan.common.exception.JQDaoException;
import com.zhuoxuan.common.exception.XTServiceException;
import com.zhuoxuan.common.result.ResultBase;
import com.zhuoxuan.common.util.ExceptionUtil;
import com.zhuoxuan.xingtian.res.dao.TableDao;
import com.zhuoxuan.xingtian.res.entity.DatabaseDO;
import com.zhuoxuan.xingtian.res.entity.FieldDO;
import com.zhuoxuan.xingtian.res.entity.TableDO;
import com.zhuoxuan.xingtian.res.service.DatabaseService;
import com.zhuoxuan.xingtian.res.service.TableService;

/**
 * <p>
 * 表资源Service 实现类
 * </p>
 * 
 * @author 高江涛
 * @创建时间：Jul 9, 2012 1:13:10 PM
 * @产品: JQSupportPlateform
 * @version： V1.0
 */
public class TableServiceImpl implements TableService {

	private TableDao tableDao;

	@Resource
	private DatabaseService databaseService;

	private static final Logger logger = Logger.getLogger(TableServiceImpl.class);

	public void setTableDao(TableDao tableDao) {
		this.tableDao = tableDao;
	}

	public boolean insertFieldBatch(List<FieldDO> fields) throws XTServiceException {
		try {
			tableDao.addFieldListBatch(fields);
			return true;
		} catch (JQDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public List<TableDO> queryTableListByDatabaseId(String databaseId) throws XTServiceException {

		// 查询对应的数据库资源
		DatabaseDO databaseDO = databaseService.queryDatabaseById(databaseId);
		if (databaseDO == null) {
			return null;
		}
		List<TableDO> tableList = tableDao.queryAllTableByDatabaseId(databaseId);
		if (tableList != null && tableList.size() != 0) {
			for (TableDO tableDO : tableList) {
				tableDO.setDatabaseDO(databaseDO);
			}
		}
		return tableList;
	}

	public List<TableDO> queryTableByJavaWebPackageId(String packageId) throws XTServiceException {

		// 查询出对应的表
		List<TableDO> tables = tableDao.queryTableByJavaWebPackageId(packageId);

		// 查询表下的列
		TableDO t = null;
		for (int i = 0; i < tables.size(); i++) {
			t = tables.get(i);

			List<FieldDO> fields = tableDao.queryFieldByTableId(t.getTableId());
			t.setFields(fields);

		}
		return tables;
	}

	@Override
	public ResultBase<TableDO> queryTableDOByTableId(String tableId) throws XTServiceException {

		ResultBase<TableDO> result = new ResultBase<TableDO>();

		try {
			// 查询表对象
			TableDO tableDO = tableDao.queryTableDOByTableId(tableId);
			if (tableDO == null) {
				return result.setReturnErrorMsg("无法根据表资源ID查询对应的表对象。");
			}
			// 关联对应的列
			List<FieldDO> fieldList = tableDao.queryFieldByTableId(tableId);
			tableDO.setFields(fieldList);

			return result.setReturnRightValue(tableDO);

		} catch (Exception e) {
			logger.error("根据表ID查询表对象出错，原因: " + ExceptionUtil.getStackTrace(e.fillInStackTrace()));
			return result.setReturnErrorMsg("根据表ID查询表对象出错");
		}
	}

}
