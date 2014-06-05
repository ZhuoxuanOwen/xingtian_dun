package com.zhuoxuan.common.result;

import java.io.Serializable;
import java.util.List;

/**
 * @description： JSON Result
 * @date 2013-12-15 下午05:44:36
 * @version JQ应用开发支撑平台
 * @author：高江涛
 */
public class JsonResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7871397125203331711L;
	
	private boolean success = true;
	private String errorMsg = "";
	private List<?> data;
	private String content = "";


	
	
	public boolean isSuccess() {
		return success;
	}
	public JsonResult setSuccess(boolean success) {
		this.success = success;
		return this;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public JsonResult setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
		return this;
	}
	public List<?> getData() {
		return data;
	}
	public JsonResult setData(List<?> data) {
		this.data = data;
		return this;
	}
	public String getContent() {
		return content;
	}
	public JsonResult setContent(String content) {
		this.content = content;
		return this;
	}
	
	

}
