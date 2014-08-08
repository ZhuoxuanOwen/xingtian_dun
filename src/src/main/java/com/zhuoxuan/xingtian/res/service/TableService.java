package com.zhuoxuan.xingtian.res.service;

import java.util.List;

import com.zhuoxuan.common.exception.XTServiceException;
import com.zhuoxuan.common.result.ResultBase;
import com.zhuoxuan.xingtian.res.entity.FieldDO;
import com.zhuoxuan.xingtian.res.entity.TableDO;

/**
 * <p>
 * 表 Service 接口
 * </p>
 * 
 * @author 高江涛
 * @创建时间：Jul 9, 2012 1:13:10 PM
 * @产品: JQSupportPlateform
 * @version： V1.0
 */
public interface TableService {
	


	/**
	 * <p>
	 * 批量添加表的字段
	 * </p>
	 * 
	 * @param fields
	 * @return boolean
	 * @throws XTServiceException
	 */
	public boolean insertFieldBatch(List<FieldDO> fields)  throws XTServiceException;
	
	
	/**
	 * 根据表资源ID查询表资源实体
	 * @param tableId 表资源ID
	 * @return
	 * @throws XTServiceException
	 */
	public ResultBase<TableDO> queryTableDOByTableId(String tableId) throws XTServiceException;
	

	/**
	 * <p> 查询数据库信息下的所有表 </p>
	 * @param databaseId
	 * @return List<Table>
	 * @throws XTServiceException  
	 */
	public List<TableDO> queryTableListByDatabaseId(String databaseId) throws XTServiceException;
	

}
