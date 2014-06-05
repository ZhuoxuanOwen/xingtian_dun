package com.zhuoxuan.xingtian.res.entity;

import java.io.Serializable;

public class CodeTempleteDO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String ctId;
	private String ctName;
	private String ctCode;
	private String ctContent;
	private String ctType;
	private String ctTel;
	public void setCtId(String ctId) {
		this.ctId = ctId;
	}

	public String getCtId() {
		return ctId;
	}

	public void setCtName(String ctName) {
		this.ctName = ctName;
	}

	public String getCtName() {
		return ctName;
	}

	public void setCtCode(String ctCode) {
		this.ctCode = ctCode;
	}

	public String getCtCode() {
		return ctCode;
	}

	public void setCtContent(String ctContent) {
		this.ctContent = ctContent;
	}

	public String getCtContent() {
		return ctContent;
	}

	public void setCtType(String ctType) {
		this.ctType = ctType;
	}

	public String getCtType() {
		return ctType;
	}

	public void setCtTel(String ctTel) {
		this.ctTel = ctTel;
	}

	public String getCtTel() {
		return ctTel;
	}

}