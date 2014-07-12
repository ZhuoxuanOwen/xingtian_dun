package com.zhuoxuan.xingtian.res.engine.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.zhuoxuan.common.exception.XTServiceException;
import com.zhuoxuan.common.result.ResultBase;
import com.zhuoxuan.common.util.ExceptionUtil;
import com.zhuoxuan.xingtian.res.constants.EngineMySQLV5Constants.ColumnMySQLV5;
import com.zhuoxuan.xingtian.res.constants.EngineMySQLV5Constants.DBMySQLV5;
import com.zhuoxuan.xingtian.res.constants.EngineMySQLV5Constants.TableMySQLV5;
import com.zhuoxuan.xingtian.res.engine.AttributeNameGenerator;
import com.zhuoxuan.xingtian.res.engine.AttributeTypeGenerator;
import com.zhuoxuan.xingtian.res.engine.ConnectionEngine;
import com.zhuoxuan.xingtian.res.engine.DatabaseEngine;
import com.zhuoxuan.xingtian.res.engine.GenerateClassNameEngine;
import com.zhuoxuan.xingtian.res.entity.DatabaseDO;
import com.zhuoxuan.xingtian.res.entity.FieldDO;
import com.zhuoxuan.xingtian.res.entity.TableDO;
import com.zhuoxuan.xingtian.res.util.ResEngineFactory;

/**
 * @description：MySQL V5 版本对应的数据库引擎实现类
 * @date 2013-12-13 下午01:37:15
 * @version JQ应用开发支撑平台
 * @author：高江涛
 */
public class MySQLV5DBEngineImpl extends DatabaseEngine {

	private DatabaseDO db;
	private ConnectionEngine connEngine;
	private GenerateClassNameEngine genCNameEngine;
	private AttributeNameGenerator attrNameGentor;
	private AttributeTypeGenerator attrTypeGentor;

	private static final Logger logger = Logger.getLogger(MySQLV5DBEngineImpl.class);

	public List<TableDO> listDatabaseTable() throws XTServiceException {

		List<TableDO> tables = new ArrayList<TableDO>();
		
		try {	
			
			connection = connEngine.createConnection();
			String sql = "select * from " + TableMySQLV5.SchemaName + " b where b.TABLE_SCHEMA ='" + db.getDbName() + "'";
			
			pstmt = connection.prepareStatement(sql);
			res = pstmt.executeQuery();
			TableDO t = null;
			while (res.next()) {
				t = new TableDO();
				t.setDatabaseId(db.getDatabaseId());

				t.setTableName(res.getString(TableMySQLV5.Column_TableName));
				t.setTableEngine(res.getString(TableMySQLV5.Column_TableEngine));
				t.setTableDataSize(String.valueOf(res.getDouble(TableMySQLV5.Column_DataSize)));
				t.setTableRowSize(res.getLong(TableMySQLV5.Column_RowSize));
				t.setTableDesc(res.getString(TableMySQLV5.Column_TableComment));
				t.setTableCreateDate(res.getString(TableMySQLV5.Column_CreateDate));

				t.setClassName(genCNameEngine.genClassName(t.getTableName()));
				tables.add(t);
			}
		}catch (Exception e) {
			logger.error("MySQL DB Engine:显示数据库表出现异常，原因是：" + ExceptionUtil.getStackTrace(e.fillInStackTrace()));
		}finally {
			super.relaseResource();
		}

		return tables;
	}

	public MySQLV5DBEngineImpl(DatabaseDO db) {
		this.db = db;
		connEngine = ResEngineFactory.createConnectionEngine(db);
		genCNameEngine = ResEngineFactory.createGenClassNameEngine();
		attrNameGentor = ResEngineFactory.createAttributeNameGenerator();
		attrTypeGentor = ResEngineFactory.createAttributeTypeGenerator();
	}

	@Override
	public List<FieldDO> listFieldByTName(String t_id, String t_name) throws XTServiceException {
		List<FieldDO> fields = new ArrayList<FieldDO>();
		try {
			String sql = "select * from " + ColumnMySQLV5.SchemaName + " where TABLE_SCHEMA = '" + db.getDbName() + "' and TABLE_NAME = '"+t_name+"'";
			connection = connEngine.createConnection();
			pstmt = connection.prepareStatement(sql);
			res = pstmt.executeQuery();
			while (res.next()) {
				FieldDO vo = new FieldDO();
				vo.setDatabaseId(db.getDatabaseId());
				vo.setTableId(t_id);
				vo.setFieldName(res.getString(ColumnMySQLV5.ColumnName)); //列名称
				String dataType = res.getString(ColumnMySQLV5.DataType);
				vo.setFieldType(dataType);//数据类型
				vo.setFieldTypeDisplay(res.getString(ColumnMySQLV5.ColumnType)); //列类型
				//数据长度
				if (dataType.indexOf("int") > -1) {
					vo.setFieldSize(res.getString(ColumnMySQLV5.NumberFieldSize));
				}else {
					vo.setFieldSize(res.getString(ColumnMySQLV5.OtherFieldSize));
				}
				//是否自增
				vo.setIsAutoIncrement("auto_increment".equals(res.getString(ColumnMySQLV5.IsIncrement) ) ? "1" : "2");
				//是否允许为空
				vo.setIsNotNull("YES".equals(res.getString(ColumnMySQLV5.IsNullable) ) ? "1" : "2");
				
				vo.setFieldRemark(res.getString(ColumnMySQLV5.ColumnRemark)); //列描述信息
				
				// 利用属性名称生成器 生成属性名称
				vo.setAttrName(attrNameGentor.generateAttributeName(vo.getFieldName()));
				// 利用属性类型生成器 生成属性类型
				vo.setAttrType(attrTypeGentor.generateAttributeType(vo.getFieldType()));
				fields.add(vo);
			}
			
		} catch (Exception e) {
			logger.equals("MySQL DB Engine:显示数据库中列出现异常，原因：" + ExceptionUtil.getStackTrace(e.fillInStackTrace()));
		}  finally {
			super.relaseResource();
		}

		return fields;
	}

	@Override
	public ResultBase<DatabaseDO> matchDataBaseInfomation(DatabaseDO db) throws Exception {
		ResultBase<DatabaseDO> result = new ResultBase<DatabaseDO>();
		try {
			String sql = "select * from " + DBMySQLV5.SchemaName + " where " + DBMySQLV5.Column_dbName + " = '" + db.getDbName() + "'";
			connection = connEngine.createConnection();
			pstmt = connection.prepareStatement(sql);
			res = pstmt.executeQuery();
			if (res.next()) {
				db.setDbCharset(res.getString(DBMySQLV5.Column_Charset));
			}
			return result.setReturnRightValue(db);
		} catch (Exception e) {
			logger.error("获取DB信息出现异常:" + ExceptionUtil.getStackTrace(e.fillInStackTrace()));
			return result.setReturnErrorMsg("Match获取数据库元数据信息出现异常"+e.getMessage());
		} finally {
			super.relaseResource();
		}
	}

}
