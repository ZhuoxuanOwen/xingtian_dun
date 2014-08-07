package com.zhuoxuan.xingtian.res.engine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zhuoxuan.common.exception.XTServiceException;
import com.zhuoxuan.common.result.ResultBase;
import com.zhuoxuan.common.util.ExceptionUtil;
import com.zhuoxuan.xingtian.res.entity.DatabaseDO;
import com.zhuoxuan.xingtian.res.entity.FieldDO;
import com.zhuoxuan.xingtian.res.entity.TableDO;

/**
 * @description：
 * @date 2013-12-12 下午07:51:05
 * @version starsoft.devbase 1.0.0
 * @author：高江涛
 */
public abstract class DatabaseEngine {
	
	protected Connection connection = null;
	protected PreparedStatement pstmt;
	protected ResultSet res;
	protected ResultSetMetaData resmdata;
	
	private  final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	protected void relaseResource() {
		try {
			if (res != null ) {
				res.close();
				res = null;
			}
			if (pstmt != null ) {
				pstmt.close();
				pstmt = null;
			}
			if (connection != null && (!connection.isClosed()) ) {
				connection.close();
				connection = null;
			}
		} catch (SQLException e) {
			logger.error("DatabaseEngine:释放数据库资源失败，原因:" + ExceptionUtil.getStackTrace(e.fillInStackTrace()));
		}
		
	}
	
	
		/**
		 * <p>  </p>
		 * @return
		 * @throws XTServiceException  List<Table>
		 */
	public abstract List<TableDO> listDatabaseTable () throws XTServiceException;
	
	
		/**
		 * <p>  </p>
		 * @param t_name
		 * @return  List<Field>
		 * @throws XTServiceException 
		 */
	public abstract List<FieldDO> listFieldByTName (String t_id , String t_name) throws XTServiceException;
	
	
	/**
	 * 补全其余的数据库信息、类似于字符集之类的信息等
	 * @param db 数据资源对象
	 * @return
	 * @throws XTServiceException
	 */
	public abstract ResultBase<DatabaseDO> matchDataBaseInfomation(DatabaseDO db) throws Exception;

}
