package com.zhuoxuan.xingtian.res.dao;

import java.util.List;

import com.zhuoxuan.common.exception.JQDaoException;
import com.zhuoxuan.xingtian.res.entity.FieldDO;
import com.zhuoxuan.xingtian.res.entity.TableDO;

/**
 * <p>
 * 表 DAO 接口
 * </p>
 * 
 * @author 高江涛
 * @创建时间：Jul 9, 2012 1:15:28 PM
 * @产品: 刑天盾
 * @version： V1.0
 */
public interface TableDao {

	/**
	 * <p>
	 * 批量添加表数据信息
	 * </p>
	 * 
	 * @param tables
	 * @throws JQDaoException
	 */
	public void addTableListBatch(List<TableDO> tables) throws JQDaoException;

	/**
	 * <p>
	 * 删除数据库信息的中表
	 * </p>
	 * 
	 * @param databaseId
	 * @throws JQDaoException
	 */
	public void deleteDbTableList(String databaseId) throws JQDaoException;


	/**
	 * <p>
	 * 查询数据库信息下的表
	 * </p>
	 * 
	 * @param databaseId
	 * @return
	 * @throws JQDaoException
	 *             List<Table>
	 */
	public List<TableDO> queryTableListByDatabaseId(String databaseId) throws JQDaoException;
	

	/**
	 * <p>
	 * 删除数据库信息的中字段
	 * </p>
	 * 
	 * @param databaseId
	 * @throws JQDaoException
	 */
	public void deleteDbFieldList(String databaseId) throws JQDaoException;

	
	/**
	 * <p>
	 * 批量添加表的列数据信息
	 * </p>
	 * 
	 * @param fields
	 * @throws JQDaoException
	 */
	public void addFieldListBatch(List<FieldDO> fields) throws JQDaoException;
	
	
	/**
	 * 根据表的ID查询表
	 * @param tableId
	 * @return
	 * @throws JQDaoException
	 */
	public TableDO queryTableDOByTableId(String tableId) throws JQDaoException;

	/**
	 * <p>
	 * 查询表下字段的信息
	 * </p>
	 * 
	 * @param tableId
	 * @return List<Field>
	 * @throws JQDaoException
	 */
	public List<FieldDO> queryFieldByTableId(String tableId) throws JQDaoException;
	
	

}
