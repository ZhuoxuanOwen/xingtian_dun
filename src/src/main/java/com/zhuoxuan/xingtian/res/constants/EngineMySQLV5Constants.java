package com.zhuoxuan.xingtian.res.constants;

/**
 * @description： 数据库引擎MySQLV5对应的常量
 * @date 2013-12-13 下午01:44:39
 * @version XT应用开发支撑平台
 * @author：高江涛
 */
public interface EngineMySQLV5Constants {

	/**
	 * 数据库级别信息
	 */
	public interface DBMySQLV5{
		
		/**
		 * 数据库别名+表名称
		 */
		public static String SchemaName = "information_schema.SCHEMATA";
		
		/**
		 * 列 数据库名称
		 */
		public static String Column_dbName = "SCHEMA_NAME";
		
		/**
		 * 列数据库字符集
		 */
		public static String Column_Charset = "DEFAULT_CHARACTER_SET_NAME";
		
	}
	
	/**
	 * 表级别的信息
	 */
	public interface TableMySQLV5{
		
		/**
		 * 数据库别名+表名称
		 */
		public static String SchemaName = "information_schema.TABLES";
		
		/**
		 * 表名称 
		 */
		public static String Column_TableName = "TABLE_NAME";
		
		/**
		 * 表引擎
		 */
		public static String Column_TableEngine = "ENGINE";
		
		/**
		 * 表行数
		 */
		public static String Column_RowSize = "TABLE_ROWS";
		
		/**
		 * 数据大小
		 */
		public static String Column_DataSize = "DATA_LENGTH";
		
		/**
		 * 表创建时间
		 */
		public static String Column_CreateDate = "CREATE_TIME";
		
		/**
		 * 表备注
		 */
		public static String Column_TableComment = "TABLE_COMMENT";
		
	}
	
	/**
	 * MySQL列对应的元数据信息常量
	 */
	public interface ColumnMySQLV5{
		
		/**
		 * 查询列的表名称
		 */
		public static String SchemaName = "information_schema.COLUMNS";
		
		/**
		 * 列名称
		 */
		public static String ColumnName = "COLUMN_NAME";
		
		/**
		 * 列对应的数据类型
		 */
		public static String DataType = "DATA_TYPE";
		
		/**
		 * 列类型
		 */
		public static String ColumnType = "COLUMN_TYPE";
		
		/**
		 * 列描述信息
		 */
		public static String ColumnRemark = "COLUMN_COMMENT";
		
		/**
		 * 长度-数字
		 */
		public static String NumberFieldSize = "NUMERIC_PRECISION";
		
		/**
		 * 长度-其它
		 */
		public static String OtherFieldSize = "CHARACTER_MAXIMUM_LENGTH";
		
		
		/**
		 * 是否自增
		 */
		public static String IsIncrement = "EXTRA";
		
		/**
		 * 是否允许为空
		 */
		public static String IsNullable = "IS_NULLABLE";
		
	}
}
