package com.zhuoxuan.xingtian.res.entity;

import java.io.Serializable;

/**
 * @description：任务构建配置DO
 * @date 2013-12-23 下午12:11:24
 * @version JQ应用开发支撑平台
 * @author：高江涛
 */
public class BuildConfigDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Java对象的后缀DO、VO、DTO 之类的
	 */
	private String javaDoSuffix;
	
	/**
	 * Java对象包路径
	 */
	private String packagePath;
	
	/**
	 * 作者
	 */
	private String author;
	
	/**
	 * 版本
	 */
	private String version;
	
	/**
	 * 产品
	 */
	private String product;
	

	public BuildConfigDO() {
		super();
		this.author = "卓轩";
		this.packagePath = "com.star.****.entity";
		this.javaDoSuffix = "DO";
		this.version = "1.0";
		this.product = "刑天盾开发平台";
	}

	public String getJavaDoSuffix() {
		return javaDoSuffix;
	}

	public void setJavaDoSuffix(String javaDoSuffix) {
		this.javaDoSuffix = javaDoSuffix;
	}

	public String getPackagePath() {
		return packagePath;
	}

	public void setPackagePath(String packagePath) {
		this.packagePath = packagePath;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}
	
	
	
	
	

}
