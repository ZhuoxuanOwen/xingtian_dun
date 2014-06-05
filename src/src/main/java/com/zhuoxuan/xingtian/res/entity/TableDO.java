package com.zhuoxuan.xingtian.res.entity;

import java.io.Serializable;
import java.util.List;

/**
 * <p>    表 DTO    </p>
 *  @author 高江涛
 * @创建时间：Jul 9, 2012 1:12:41 PM
 * @产品: JQSupportPlateform
 * @version： V1.0
 */
public class TableDO implements Serializable{

	/**
	 * <p> </p>
	 */
	private static final long serialVersionUID = 1L;

	
	private String tableId;
	private String databaseId;
	private String businessName;
	private String tableName;
	private String className;
	private String tableDesc;
	
	
	
	/**
	 * <p> 表中的字段 </p>
	 */
	private List<FieldDO> fields;
	
	private DatabaseDO databaseDO; //表所对应的数据库资源
	
	private String tableEngine; //数据存储引擎
	private Long tableRowSize; //表记录总行数
	private String tableDataSize; //表数据占用空间
	private String tableCreateDate; //表创建时间
	
	
	public List<FieldDO> getFields() {
		return fields;
	}
	public void setFields(List<FieldDO> fields) {
		this.fields = fields;
	}
	public String getTableId() {
		return tableId;
	}
	public void setTableId(String tableId) {
		this.tableId = tableId;
	}
	public String getDatabaseId() {
		return databaseId;
	}
	public void setDatabaseId(String databaseId) {
		this.databaseId = databaseId;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getTableDesc() {
		return tableDesc;
	}
	public void setTableDesc(String tableDesc) {
		this.tableDesc = tableDesc;
	}
	public DatabaseDO getDatabaseDO() {
		return databaseDO;
	}
	public void setDatabaseDO(DatabaseDO databaseDO) {
		this.databaseDO = databaseDO;
	}
	public String getTableEngine() {
		return tableEngine;
	}
	public void setTableEngine(String tableEngine) {
		this.tableEngine = tableEngine;
	}
	public Long getTableRowSize() {
		return tableRowSize;
	}
	public void setTableRowSize(Long tableRowSize) {
		this.tableRowSize = tableRowSize;
	}

	
	
	
	public String getTableDataSize() {
		return tableDataSize;
	}
	public void setTableDataSize(String tableDataSize) {
		this.tableDataSize = tableDataSize;
	}
	public String getTableCreateDate() {
		return tableCreateDate;
	}
	public void setTableCreateDate(String tableCreateDate) {
		this.tableCreateDate = tableCreateDate;
	}

	
	
	
	
}
