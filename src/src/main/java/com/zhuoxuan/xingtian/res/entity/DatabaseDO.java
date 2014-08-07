package com.zhuoxuan.xingtian.res.entity;

import java.io.Serializable;

/**
 * <p>
 * 数据库 DTO
 * </p>
 * 
 * @author 高江涛
 * @创建时间：Jul 9, 2012 1:12:07 PM
 * @产品: 刑天盾
 * @version： V1.0
 */
public class DatabaseDO implements Serializable {

	/**
	 * <p>
	 * </p>
	 */
	private static final long serialVersionUID = 1L;

	private String databaseId;
	private String businessName;
	private String dbType;
	private String dbName;
	private String userName;
	private String userPassword;
	private String serverAddress;
	private String serverPort;
	
	private String dbStatus; //执行的状态 0: 新建的db  1:执行初始化中; 2:执行成功结束  4:执行出现错误
	private String errorMsg; //执行过程中的错误信息
	
	private String dbRemark;

	private String dbCharset; // 数据库资源字符集
	private Integer tableCount; // 包含的表总数

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

	public String getDbType() {
		return dbType;
	}

	public void setDbType(String dbType) {
		this.dbType = dbType;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getServerAddress() {
		return serverAddress;
	}

	public void setServerAddress(String serverAddress) {
		this.serverAddress = serverAddress;
	}

	public String getServerPort() {
		return serverPort;
	}

	public void setServerPort(String serverPort) {
		this.serverPort = serverPort;
	}

	public String getDbStatus() {
		return dbStatus;
	}

	public void setDbStatus(String dbStatus) {
		this.dbStatus = dbStatus;
	}

	public String getDbRemark() {
		return dbRemark;
	}

	public void setDbRemark(String dbRemark) {
		this.dbRemark = dbRemark;
	}

	public Integer getTableCount() {
		return tableCount;
	}

	public void setTableCount(Integer tableCount) {
		this.tableCount = tableCount;
	}

	public String getDbCharset() {
		return dbCharset;
	}

	public void setDbCharset(String dbCharset) {
		this.dbCharset = dbCharset;
	}
	

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}


	public enum Status {
		/**
		 * <p>
		 * dd
		 * </p>
		 */
		CREATE, START_INIT, INITING, INITED, BACKUP, RESTORE
	}

}
