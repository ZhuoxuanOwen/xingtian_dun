package com.zhuoxuan.xingtian.res.util;

import com.zhuoxuan.xingtian.res.engine.AttributeNameGenerator;
import com.zhuoxuan.xingtian.res.engine.AttributeTypeGenerator;
import com.zhuoxuan.xingtian.res.engine.ConnectionEngine;
import com.zhuoxuan.xingtian.res.engine.DatabaseEngine;
import com.zhuoxuan.xingtian.res.engine.GenerateClassNameEngine;
import com.zhuoxuan.xingtian.res.engine.impl.MakeAttributeNameDefaultGenerator;
import com.zhuoxuan.xingtian.res.engine.impl.MakeAttributeTypeDefaultGenerator;
import com.zhuoxuan.xingtian.res.engine.impl.MakeClassNameEngineDefault;
import com.zhuoxuan.xingtian.res.engine.impl.MySQLV5ConnEngineImpl;
import com.zhuoxuan.xingtian.res.engine.impl.MySQLV5DBEngineImpl;
import com.zhuoxuan.xingtian.res.entity.DatabaseDO;

 
public class ResEngineFactory {
	
	private static final String  MYSQL_V5 = "mysql_v5";
	
	private static DatabaseEngine db_engine;
	
	private static ConnectionEngine connectoin_engine;
	
	public static DatabaseEngine createDatabaseEngine (DatabaseDO db){
		String dbType = db.getDbType();
		if (MYSQL_V5.equals(dbType)) {
			 db_engine = new MySQLV5DBEngineImpl(db);
		}
		
		return db_engine;
	}

	
	
	public static ConnectionEngine createConnectionEngine (DatabaseDO db){
		String dbType = db.getDbType();
		if (MYSQL_V5.equals(dbType)) {
			connectoin_engine = new MySQLV5ConnEngineImpl(db);
		}
		return connectoin_engine;
	}
	
	
	public static GenerateClassNameEngine createGenClassNameEngine(){
		
		return new MakeClassNameEngineDefault();
	}
	
	
	public static AttributeNameGenerator createAttributeNameGenerator(){
		
		return new MakeAttributeNameDefaultGenerator();
		
	}
	
	public static AttributeTypeGenerator createAttributeTypeGenerator(){
		
		return new MakeAttributeTypeDefaultGenerator();
		
	}
}
