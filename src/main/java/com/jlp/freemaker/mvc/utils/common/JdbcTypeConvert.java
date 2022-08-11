package com.jlp.freemaker.mvc.utils.common;

/**
 * jdbcType 类型转换工具类
 * 
 * @author hxy
 * @since 1.0.0
 */
public class JdbcTypeConvert {
	/**
	 * mysql的字段类型转换成jdbc的类型
	 * 
	 * @param mysqlType
	 * @return
	 */
	public static String mysqlType2JdbcType(String mysqlType) {
		String jdbcType = "";
		switch (mysqlType.toUpperCase()) {
		case "BIGINT":
			jdbcType = "BIGINT";
			break;
		case "TINYINT":
			jdbcType = "TINYINT";
			break;
		case "SMALLINT":
			jdbcType = "SMALLINT";
			break;
		case "MEDIUMINT":
			jdbcType = "INTEGER";
			break;
		case "INTEGER":
			jdbcType = "INTEGER";
			break;
		case "INT":
			jdbcType = "INTEGER";
			break;
		case "FLOAT":
			jdbcType = "REAL";
			break;
		case "DOUBLE":
			jdbcType = "DOUBLE";
			break;
		case "DECIMAL":
			jdbcType = "DECIMAL";
			break;
		case "CHAR":
			jdbcType = "CHAR";
			break;
		case "VARCHAR":
			jdbcType = "VARCHAR";
			break;
		case "TINYBLOB":
			jdbcType = "BINARY";
			break;
		case "TINYTEXT":
			jdbcType = "VARCHAR";
			break;
		case "BLOB":
			jdbcType = "BINARY";
			break;
		case "TEXT":
			jdbcType = "LONGVARCHAR";
			break;
		case "MEDIUMTEXT":
			jdbcType = "LONGVARCHAR";
			break;
		case "LONGTEXT":
			jdbcType = "LONGVARCHAR";
			break;
		case "LONGBLOB":
			jdbcType = "LONGVARBINARY";
			break;
		case "DATE":
			jdbcType = "DATE";
			break;
		case "YEAR":
			jdbcType = "DATE";
			break;
		case "TIME":
			jdbcType = "TIME";
			break;
		case "DATETIME":
			jdbcType = "TIMESTAMP";
			break;
		case "TIMESTAMP":
			jdbcType = "TIMESTAMP";
			break;
		default:
			jdbcType = null;
			break;
		}
		return jdbcType;
	}

	/**
	 * mysql字段的类型转换成java的类型
	 * 
	 * @param mysqlType
	 * @return
	 */
	public static String mysqlType2JavaType(String mysqlType) {
		String javaType = "";
		switch (mysqlType.toUpperCase()) {
		case "TEXT":
			javaType = "String";
			break;
		case "BIT":
			javaType = "Boolean";
			break;
		case "SMALLINT":
			javaType = "Integer";
			break;
		case "MEDIUMINT ":
			javaType = "Integer";
			break;
		case "INTEGER":
			javaType = "Integer";
			break;
		case "INT":
			javaType = "Integer";
			break;
		case "BIGINT UNSIGNED":
			javaType = "Long";
			break;
		case "FLOAT":
			javaType = "Float";
			break;
		case "DOUBLE":
			javaType = "Double";
			break;
		case "DECIMAL":
			javaType = "BigDecimal";
			break;
		case "TIMESTAMP":
			javaType = "Timestamp";
			break;
		case "TIME":
			javaType = "Time";
			break;
		case "DATE":
			javaType = "Date";
			break;
		case "CHAR":
			javaType = "String";
			break;
		case "VARCHAR":
			javaType = "String";
			break;
		case "DATETIME":
			javaType = "Timestamp";
			break;
		default:
			javaType = null;
			break;
			}
			return javaType;
		}
}
