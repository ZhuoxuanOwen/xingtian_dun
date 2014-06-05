package com.zhuoxuan.xingtian.res.util;

public class ClassNameRoleEngine {
	
	public static String roleEngineDefault(String table_name){
		table_name = table_name.toLowerCase();
		int _index = table_name.indexOf("_");
		
		String c_name_l = table_name.substring(_index +1, _index +2);
		String c_name_r = table_name.substring(_index +2, table_name.length());
		
		return c_name_l.toUpperCase() + c_name_r;
	}
	
	public static void main(String[] args) {
		
		String name = roleEngineDefault("jq_user");
		System.out.println(name);
	}

}
