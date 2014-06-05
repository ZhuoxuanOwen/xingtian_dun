package com.zhuoxuan.xingtian.res.engine.impl;

import com.zhuoxuan.xingtian.res.engine.GenerateClassNameEngine;

public class MakeClassNameEngineDefault implements GenerateClassNameEngine {

	//去掉下滑下 类名首字母大写
	public String genClassName(String table_name) {
		table_name = table_name.toLowerCase();
		int _index = table_name.indexOf("_");
		
		String c_name_l = table_name.substring(_index +1, _index +2);
		String c_name_m = "";
		String c_name_r = table_name.substring(_index +2, table_name.length());
		
		String c_name = c_name_l.toUpperCase() + c_name_r;
		if (c_name.indexOf("_") > 0) {
			_index = c_name.indexOf("_");
			c_name_l = c_name.substring(0, _index );
			c_name_m = c_name.substring(_index +1, _index +2);
			c_name_r = c_name.substring(_index +2, c_name.length());
			
			c_name = c_name_l + c_name_m.toUpperCase() + c_name_r;
			
			if (c_name.indexOf("_") > 0) {
				_index = c_name.indexOf("_");
				c_name_l = c_name.substring(0, _index );
				c_name_m = c_name.substring(_index +1, _index +2);
				c_name_r = c_name.substring(_index +2, c_name.length());
				
				c_name = c_name_l + c_name_m.toUpperCase() + c_name_r;
				return c_name;
				
			}
			return c_name;
			
		}else {
			return c_name;
		}
	}

}
