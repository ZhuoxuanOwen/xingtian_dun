package com.zhuoxuan.xingtian.res.service;

import java.util.List;

import com.zhuoxuan.common.exception.XTServiceException;
import com.zhuoxuan.common.page.Page;
import com.zhuoxuan.common.result.ResultBase;
import com.zhuoxuan.xingtian.res.entity.DatabaseDO;
import com.zhuoxuan.xingtian.res.entity.TableDO;

/**
 * <p>
 * 数据库 Service 接口
 * </p>
 * 
 * @author 高江涛
 * @创建时间：Jul 9, 2012 1:08:43 PM
 * @产品: JQSupportPlateform
 * @version： V1.0
 */
public interface DatabaseService {
	

	/**
	 * <p>
	 * 添加数据库信息
	 * </p>
	 * 
	 * @param vo
	 * @return boolean
	 * @throws XTServiceException
	 */
	public boolean insertDatabase(DatabaseDO vo) throws XTServiceException;

	/**
	 * <p>
	 * 批量添加表信息
	 * </p>
	 * 
	 * @param tables
	 * @return boolean
	 * @throws XTServiceException
	 */
	public boolean insertTableListBatch(List<TableDO> tables) throws XTServiceException;

	/**
	 * <p>
	 * 修改数据库信息的状态
	 * </p>
	 * 
	 * @param vo
	 * @return boolean
	 * @throws XTServiceException
	 */
	public boolean modifyDatabase(DatabaseDO vo) throws XTServiceException;

	/**
	 * 
	 * <p>
	 * 清理掉依赖数据库的资源
	 * </p>
	 * 
	 * @param databaseId
	 *            数据库ID
	 * @return 结果
	 * @throws XTServiceException
	 *             boolean
	 */
	public boolean cleanUpResouceReferenceDbId(String databaseId) throws XTServiceException;

	/**
	 * <p>
	 * 查询数据库列表
	 * </p>
	 * 
	 * @param page
	 * @return List<Database>
	 * @throws XTServiceException
	 */
	public List<DatabaseDO> queryDatabaseList(Page page) throws XTServiceException;

	/**
	 * <p>
	 * 查询数据库列表
	 * </p>
	 * 
	 * @param page
	 * @return List<Database>
	 * @throws XTServiceException
	 */
	public List<DatabaseDO> queryDatabaseList() throws XTServiceException;

	/**
	 * <p>
	 * 根据数据库ID查询数据信息
	 * </p>
	 * 
	 * @param databaseId
	 * @return Database
	 * @throws XTServiceException
	 */
	public DatabaseDO queryDatabaseById(String databaseId) throws XTServiceException;
	
	
	/**
	 * 初始化数据库资源
	 * @param databaseId 数据库资源ID
	 * @return 初始化数据库资源的结果
	 * @throws XTServiceException
	 */
	public ResultBase<Boolean> initDataBaseResource(String databaseId) throws XTServiceException;

}
