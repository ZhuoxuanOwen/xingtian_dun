package com.zhuoxuan.xingtian.res.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @description：构建任务对象
 * @date 2013-12-23 下午12:09:43
 * @version JQ应用开发支撑平台
 * @author：高江涛
 */
public class BuildTaskDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 代码模板
	 */
	public Map<String, String> codeTemplate = new HashMap<String, String>();
	
	/**
	 * 构建配置
	 */
	public BuildConfigDO buildConfig = new BuildConfigDO();

	public Map<String, String> getCodeTemplate() {
		return codeTemplate;
	}

	public void setCodeTemplate(Map<String, String> codeTemplate) {
		this.codeTemplate = codeTemplate;
	}

	public BuildConfigDO getBuildConfig() {
		return buildConfig;
	}

	public void setBuildConfig(BuildConfigDO buildConfig) {
		this.buildConfig = buildConfig;
	}
	
	
	

}
