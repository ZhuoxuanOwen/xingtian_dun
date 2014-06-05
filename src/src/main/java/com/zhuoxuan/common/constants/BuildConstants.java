package com.zhuoxuan.common.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * </p>
 * 
 * @author 高江涛
 * @创建时间：Aug 2, 2012 8:08:13 PM
 * @产品: JQSupportPlateform
 * @version： V1.0
 */
public class BuildConstants {
	
	
	
	/**
	 * <p>系统模板的标致 </p>
	 */
	public static final String SYS_TEMP_JQDEV = "jqdev";
	public static final String SYS_TEMP_JQEAI = "jqeai";
	

	public static final String TECL_SSI = "ssi";
	
	
	/**
	 * <p>数据库类型 </p>
	 */
	public static final String DT_MYSQL = "mysql_v5";

	/**
	 * <p>
	 * 数据库驱动类
	 * </p>
	 */
	public static final String DRIVER_CALSS_MYSQL = "com.mysql.jdbc.Driver";
	public static final String ORACLE_DRIVER_CALSS = "com.mysql.jdbc.Driver";
	public static final String DB2_DRIVER_CALSS = "com.mysql.jdbc.Driver";
	
	
	
	public static Map<String, String> DT_DRIVER_JAR = new HashMap<String, String>();
	
	static{
		DT_DRIVER_JAR.put(DT_MYSQL, "mysql-connector-java-5.0.8-bin.jar");
		
	}

}
