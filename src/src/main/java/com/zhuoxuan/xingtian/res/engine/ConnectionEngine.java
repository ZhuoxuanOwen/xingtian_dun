package com.zhuoxuan.xingtian.res.engine;

import java.sql.Connection;

public abstract class ConnectionEngine {
	
	protected final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
	
	public abstract Connection createConnection() throws Exception;

}
