package com.jlp.freemaker.mvc.utils.common;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.jlp.freemaker.mvc.dbutil.DBUtils;
import com.jlp.freemaker.mvc.entity.Column;
import com.jlp.freemaker.mvc.entity.Table;
import com.jlp.freemaker.mvc.common.constant.MysqlTableConstant;

/**
 * 
 * @author 啃过雪糕的兔子
 * @to 主要是用于封装元数据的工具类
 * @date 2018年7月1日 上午12:39:20
 * @see:<p>www.aixuegao.cn</p>
 * @since 1.0.1
 */
public class DbMetaDataUtils {
 
	/**
	 * 获取表信息(包括字段、注释等)
	 * @param tableName
	 * @return
	 */
	public static Table getTable(String tableName) {
		Table table = new Table();
		table.setTable(tableName);
		table.setColumnList(getColumns(tableName));
		return table;
	}
	
	/**
	 * 根据表名获取所有的字段信息
	 * @param tableName 表名称
	 * @return 字段的集合
	 */
	public static List<Column> getColumns(String tableName){
		List<Column> columnList = new ArrayList<>();
		String PK = "";
		Connection connection = DBUtils.getConnection();
        DatabaseMetaData databaseMetaData;
		try {
			databaseMetaData = connection.getMetaData();
			ResultSet pkRSet = databaseMetaData.getPrimaryKeys(null, null, tableName); 
	        ResultSet resultSet = databaseMetaData.getColumns(null,"%", tableName,"%");
	        //获取主键
	        while (pkRSet.next()) {
	        	PK = (String) pkRSet.getObject(4); 
			}
	        while(resultSet.next()){
	        	Column column = new Column();
	            //id字段略过
	            if(resultSet.getString(MysqlTableConstant.COLUMN_NAME).equalsIgnoreCase(PK)) {
	            	column.setIsPrimaryKey(true);
	            }else {
	            	column.setIsPrimaryKey(false);
	            }
	            //获取数据库原始字段名称
	            column.setOriginalName(resultSet.getString(MysqlTableConstant.COLUMN_NAME));
	            //获取字段名称
	            column.setName(StrUtils.replaceUnderLine(resultSet.getString(MysqlTableConstant.COLUMN_NAME)));
	            //转换字段名称，如 sys_name 变成 SysName
	            column.setNameUp(StrUtils.toUpperCase(resultSet.getString(MysqlTableConstant.COLUMN_NAME)));
	            //字段在数据库的注释
	            column.setComment(resultSet.getString(MysqlTableConstant.REMARKS));
	            //获取字段类型
	            column.setType(JdbcTypeConvert.mysqlType2JavaType(resultSet.getString(MysqlTableConstant.TYPE_NAME)));
	            columnList.add(column);
	        }
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("获取表信息失败！");
		}
        return columnList;
	}
}
