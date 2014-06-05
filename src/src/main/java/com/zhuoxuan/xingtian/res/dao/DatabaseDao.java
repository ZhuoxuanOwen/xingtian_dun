package com.zhuoxuan.xingtian.res.dao;

import java.util.List;

import com.zhuoxuan.common.exception.JQDaoException;
import com.zhuoxuan.common.page.Page;
import com.zhuoxuan.xingtian.res.entity.DatabaseDO;

/**
 * <p>
 * 数据库 DAO 接口
 * </p>
 * 
 * @author 高江涛
 * @创建时间：Jul 9, 2012 1:15:07 PM
 * @产品: JQSupportPlateform
 * @version： V1.0
 */
public interface DatabaseDao {

	/**
	 * <p>
	 * 添加数据库信息
	 * </p>
	 * 
	 * @param vo
	 * @throws JQDaoException
	 */
	public void addDatabase(DatabaseDO vo) throws JQDaoException;
	
	
	
		/**
		 * <p> 修改数据库信息 </p>
		 * @param vo void
		 * @throws JQDaoException  
		 */
	public void updateDatabase(DatabaseDO vo)  throws JQDaoException ;
	
	
		/**
		 * <p> 根据ID查询数据库信息 </p>
		 * @param databaseId
		 * @return Database
		 * @throws JQDaoException  
		 */
	public DatabaseDO queryDatabaseById(String databaseId) throws JQDaoException;

	/**
	 * <p>
	 * 查询数据库信息列表
	 * </p>
	 * @param page
	 * @return
	 * @throws JQDaoException  List<Database>
	 */
	public List<DatabaseDO> queryDatabase(Page page) throws JQDaoException;
	
	/**
	 * <p>
	 * 查询数据库信息列表
	 * </p>
	 * @return
	 * @throws JQDaoException  List<Database>
	 */
	public List<DatabaseDO> queryDatabase() throws JQDaoException;

}
