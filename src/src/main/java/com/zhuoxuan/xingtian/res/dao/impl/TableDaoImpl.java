package com.zhuoxuan.xingtian.res.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.zhuoxuan.common.exception.JQDaoException;
import com.zhuoxuan.xingtian.res.dao.TableDao;
import com.zhuoxuan.xingtian.res.entity.FieldDO;
import com.zhuoxuan.xingtian.res.entity.TableDO;

/**
 * <p>
 * 表 DAO 实现类
 * </p>
 * 
 * @author 高江涛
 * @创建时间：Jul 9, 2012 1:15:28 PM
 * @产品: XTSupportPlateform
 * @version： V1.0
 */
public class TableDaoImpl extends SqlMapClientDaoSupport implements TableDao {

	@SuppressWarnings("unchecked")
	public List<TableDO> queryAllTableByDatabaseId(String databaseId) throws JQDaoException {

		List<TableDO> tables = (List<TableDO>) super.getSqlMapClientTemplate().queryForList("table.queryAllTableByDbId", databaseId);

		return tables;
	}

	public void addTableListBatch(List<TableDO> tables) throws JQDaoException {

		try {
			super.getSqlMapClient().startBatch();
			for (int i = 0; i < tables.size(); i++) {
				TableDO t = tables.get(i);
				super.getSqlMapClientTemplate().insert("table.addTable", t);
			}
			super.getSqlMapClient().executeBatch();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void addFieldListBatch(List<FieldDO> fields) throws JQDaoException {
		try {
			super.getSqlMapClient().startBatch();
			for (int i = 0; i < fields.size(); i++) {
				FieldDO f = fields.get(i);
				super.getSqlMapClientTemplate().insert("field.addField", f);
			}
			super.getSqlMapClient().executeBatch();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void deleteDbFieldList(String databaseId) throws JQDaoException {

		super.getSqlMapClientTemplate().delete("field.deleteDbFieldList", databaseId);
	}

	public void deleteDbTableList(String databaseId) throws JQDaoException {

		super.getSqlMapClientTemplate().delete("table.deleteDbTableList", databaseId);

	}

	@SuppressWarnings("unchecked")
	public List<TableDO> queryTableByJavaWebPackageId(String packageId) throws JQDaoException {

		List<TableDO> tables = (List<TableDO>) super.getSqlMapClientTemplate().queryForList("table.queryTablesByJavaWebPackageId", packageId);

		return tables;
	}

	@SuppressWarnings("unchecked")
	public List<FieldDO> queryFieldByTableId(String tableId) throws JQDaoException {

		List<FieldDO> fields = (List<FieldDO>) super.getSqlMapClientTemplate().queryForList("field.queryFieldByTableId", tableId);

		return fields;
	}

	public void deleteModuleTableByDatabaseId(String databaseId) throws JQDaoException {
		super.getSqlMapClientTemplate().delete("table.deleteModuleTable", databaseId);
	}

	@Override
	public TableDO queryTableDOByTableId(String tableId) throws JQDaoException {
		TableDO tableDO = (TableDO)super.getSqlMapClientTemplate().queryForObject("table.queryTableByTableId", tableId);
		return tableDO;
	}

}
