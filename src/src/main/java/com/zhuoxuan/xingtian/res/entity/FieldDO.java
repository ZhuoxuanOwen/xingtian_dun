package com.zhuoxuan.xingtian.res.entity;

import java.io.Serializable;

/**
 * <p>    字段 DTO    </p>
 *  @author 高江涛
 * @创建时间：Jul 10, 2012 1:32:09 PM
 * @产品: JQSupportPlateform
 * @version： V1.0
 */
public class FieldDO implements Serializable {

	/**
	 * <p> </p>
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String fieldId;
	private String databaseId;
	private String tableId;
	private String fieldName;
	private String businessName;
	private String fieldType;
	private String fieldTypeDisplay;  //fieldType + fieldSize 组合 从 Columns宽表中获取
	private String isNotNull; //1 自增 2非自增
	private String isAutoIncrement; //1 自增 2非自增
	
	private String attrName;
	private String attrType;
	private String fieldSize;
	private String fieldRemark;
	
	private TableDO tableDO; //数据库列所属表
	
	
	
	public String getIsNotNull() {
		return isNotNull;
	}
	public void setIsNotNull(String isNotNull) {
		this.isNotNull = isNotNull;
	}
	public String getIsAutoIncrement() {
		return isAutoIncrement;
	}
	public void setIsAutoIncrement(String isAutoIncrement) {
		this.isAutoIncrement = isAutoIncrement;
	}
	public String getFieldId() {
		return fieldId;
	}
	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	}
	public String getDatabaseId() {
		return databaseId;
	}
	public void setDatabaseId(String databaseId) {
		this.databaseId = databaseId;
	}
	public String getTableId() {
		return tableId;
	}
	public void setTableId(String tableId) {
		this.tableId = tableId;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getAttrName() {
		return attrName;
	}
	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}
	public String getFieldType() {
		return fieldType;
	}
	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}
	public String getAttrType() {
		return attrType;
	}
	public void setAttrType(String attrType) {
		this.attrType = attrType;
	}
	public String getFieldSize() {
		return fieldSize;
	}
	public void setFieldSize(String fieldSize) {
		this.fieldSize = fieldSize;
	}
	public String getFieldRemark() {
		return fieldRemark;
	}
	public void setFieldRemark(String fieldRemark) {
		this.fieldRemark = fieldRemark;
	}
	public TableDO getTableDO() {
		return tableDO;
	}
	public void setTableDO(TableDO tableDO) {
		this.tableDO = tableDO;
	}
	public String getFieldTypeDisplay() {
		return fieldTypeDisplay;
	}
	public void setFieldTypeDisplay(String fieldTypeDisplay) {
		this.fieldTypeDisplay = fieldTypeDisplay;
	}
	
	
	
	
	

}
