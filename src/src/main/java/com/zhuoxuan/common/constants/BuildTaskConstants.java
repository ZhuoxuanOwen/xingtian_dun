package com.zhuoxuan.common.constants;

public interface BuildTaskConstants {
	
	
	interface CodeTempKey{
		
		/**
		 * <p> Spring 配置文件在代码模板表中的标致</p>
		 */
		public static final String SPRING_HEAD_KEY = "spring_bean_head";
		public static final String SPRING_END_KEY = "spring_bean_end";
		
		/**
		 * <p> Ibatis配置文件在代码模板表中的标致 </p>
		 */
		public static final String SQLMAP_CONFIG_HEAD_KEY = "ibatis_sqlmapconfig_head";
		public static final String SQLMAP_CONFIG_END_KEY = "ibatis_sqlmapconfig_end";
		public static final String IBATIS_MAPPING_HEAD = "ibatis_mapping_head";
		public static final String IBATIS_MAPPING_END = "ibatis_mapping_end";
		
		public static final String STRUTS2_CONFIG_HAED = "struts2_config_head"; //配置文件首部
		public static final String STRUTS2_CONFIG_END = "struts2_config_end"; //配置文件尾部
		public static final String STRUTS2_AUTH_PACKAGE = "struts2_auth_default_package"; //用户自定义的通用包
		public static final String STRUTS2_AUTH_PACKAGE_JSON = "struts2_auth_default_package_json";
		
	}
	
	
	interface JQDev{
		
		/**
		 * <p> JQ dev sqlMapConfig 在代码模板表中的纪录标致  </p>
		 */
		public static final String JQDEV_SQLMAP_CONFIG_KEY = "jqdev_ibatis_config"; 
		
		
		/**
		 * <p>JQ用户登录在Struts2配置文件中的配置</p>
		 */
		public static final String STRUTS2_ULOGIN_PACKAGE_CONFIG = "jqdev_ulogin_package";
	}

}
