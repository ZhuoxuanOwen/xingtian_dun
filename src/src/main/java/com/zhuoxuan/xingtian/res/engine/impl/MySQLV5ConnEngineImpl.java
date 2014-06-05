package com.zhuoxuan.xingtian.res.engine.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.zhuoxuan.common.exception.XTServiceException;
import com.zhuoxuan.common.util.ExceptionUtil;
import com.zhuoxuan.xingtian.res.engine.ConnectionEngine;
import com.zhuoxuan.xingtian.res.entity.DatabaseDO;

public class MySQLV5ConnEngineImpl extends ConnectionEngine {
	
	private DatabaseDO db;
	
	private Logger logger = Logger.getLogger(MySQLV5ConnEngineImpl.class);

	public Connection createConnection() throws Exception {
		 
			String url = "jdbc:mysql://"+db.getServerAddress()+":"+db.getServerPort()+"/"+db.getDbName();
			Class.forName(MYSQL_DRIVER);
			DriverManager.setLoginTimeout(10000);
			Connection connection = DriverManager.getConnection(url, db.getUserName(), db.getUserPassword());
			return connection;
		 
	}

	public MySQLV5ConnEngineImpl(DatabaseDO db) {
		super();
		this.db = db;
	}

	
	 
}
