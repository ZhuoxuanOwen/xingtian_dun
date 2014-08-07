package com.zhuoxuan.xingtian.res.entity;

import java.io.Serializable;

/**
 *<p>
 *  MongodbDO 实体  
 *</p> 
 * @author: 卓轩
 * @创建时间：2014-06-04 16:54:28
 * @产品: 刑天盾开发平台
 * @version:1.0
*/

 public class MongodbDO implements Serializable { 

 	private static final long serialVersionUID = 1L; 


	/**
	 * mongodbId
	*/
	private Integer mongodbId;

	/**
	 * serviceName
	*/
	private String serviceName;

	/**
	 * host
	*/
	private String serverAddress;

	/**
	 * port
	*/
	private Integer serverPort;

	/**
	 * resType
	*/
	private Integer resType;

	/**
	 * defaultDb
	*/
	private String defaultDb;

	/**
	 * uname
	*/
	private String uname;

	/**
	 * userpwd
	*/
	private String userpwd;

	/**
	 * desc
	*/
	private String desc;

	/**
	 * setter for  mongodbId
	*/
	public void setMongodbId(Integer mongodbId){
		this.mongodbId=mongodbId;
	}

	/**
	 * getter for  mongodbId
	*/
	public Integer getMongodbId(){
		return mongodbId;
	}

	/**
	 * setter for  serviceName
	*/
	public void setServiceName(String serviceName){
		this.serviceName=serviceName;
	}

	/**
	 * getter for  serviceName
	*/
	public String getServiceName(){
		return serviceName;
	}
 
	
	public String getServerAddress() {
		return serverAddress;
	}

	public void setServerAddress(String serverAddress) {
		this.serverAddress = serverAddress;
	}

	public Integer getServerPort() {
		return serverPort;
	}

	public void setServerPort(Integer serverPort) {
		this.serverPort = serverPort;
	}

	/**
	 * setter for  resType
	*/
	public void setResType(Integer resType){
		this.resType=resType;
	}

	/**
	 * getter for  resType
	*/
	public Integer getResType(){
		return resType;
	}

	/**
	 * setter for  defaultDb
	*/
	public void setDefaultDb(String defaultDb){
		this.defaultDb=defaultDb;
	}

	/**
	 * getter for  defaultDb
	*/
	public String getDefaultDb(){
		return defaultDb;
	}

	/**
	 * setter for  uname
	*/
	public void setUname(String uname){
		this.uname=uname;
	}

	/**
	 * getter for  uname
	*/
	public String getUname(){
		return uname;
	}

	/**
	 * setter for  userpwd
	*/
	public void setUserpwd(String userpwd){
		this.userpwd=userpwd;
	}

	/**
	 * getter for  userpwd
	*/
	public String getUserpwd(){
		return userpwd;
	}

	/**
	 * setter for  desc
	*/
	public void setDesc(String desc){
		this.desc=desc;
	}

	/**
	 * getter for  desc
	*/
	public String getDesc(){
		return desc;
	}

}