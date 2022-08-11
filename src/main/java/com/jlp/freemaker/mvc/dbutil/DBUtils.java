package com.jlp.freemaker.mvc.dbutil;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Properties;


/**
 * 
 * @author 啃过雪糕的兔子
 * @to TODO
 * @date 2018年6月30日 下午10:52:34
 * @see:<p>www.aixuegao.cn</p>
 * @since 1.0.1
 */
public class DBUtils {
	/**
	 * 数据库连接
	 */
	private static Connection con;
	/**
	 * 
	 */
	private static PreparedStatement pstmt;
	/**
	 * 返回的结果集
	 */
	private static ResultSet rs;
	/**
	 * 连接的url
	 */
	private static String connectionName = "jdbc:mysql://127.0.0.1:3306/panda_auth?useUnicode=true&amp;characterEncoding=utf-8";
	/**
	 * 数据库账户
	 */
	private static String conUser = "root";
	/**
	 * 数据库密码
	 */
	private static String conPwd = "1234";
	/**
	 * Mysql驱动类
	 */
	private static String classForName = "com.mysql.jdbc.Driver";

	/**
	 * 获取连接的方法
	 * @return Connection
	 */
	public static Connection getConnection() {
		try {
			if (con == null) {
				Class.forName(classForName);
				Properties info = new Properties();
				info.put("user", conUser);
				info.put("password", conPwd);
				con = DriverManager.getConnection(connectionName, info);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	/**
	 * 获取rs
	 * 
	 * @param sql
	 * @return
	 */
	public static ResultSet getResultSet(String sql) {
		con = getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// closeCon();
		}
		return rs;
	}

	public static ArrayList<Hashtable<String, Object>> executeQuery(String sql) {
		ArrayList<Hashtable<String, Object>> result = null;
		con = getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (null == rs)
				return result;
			result = new ArrayList<Hashtable<String, Object>>();
			while (rs.next()) {
				Hashtable<String, Object> row = new Hashtable<String, Object>();
				ResultSetMetaData rsmd = rs.getMetaData();
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					if (null == rs.getObject(i))
						continue;
					row.put(rsmd.getColumnName(i).toLowerCase(), rs.getObject(i));
				}
				result.add(row);
			}
		} catch (Exception e) {
		} finally {
			closeAll();
		}
		return result;
	}

	/**
	 * 将运行的sql数据结果转换为String
	 * 
	 * @param sql
	 * @return
	 */
	public static String executeQueryToStr(String sql) {
		String result = "";
		con = getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (null == rs)
				return "运行该脚本没有产生数据....";
			while (rs.next()) {
				ResultSetMetaData rsmd = rs.getMetaData();
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					if (null == rs.getObject(i))
						continue;
					result += rsmd.getColumnName(i).toLowerCase() + ":" + rs.getObject(i) + "@";
				}
			}
		} catch (Exception e) {

		} finally {
			closeAll();
		}
		return result;
	}

	/**
	 * 基础的修改
	 * 
	 * @param sql
	 * @return
	 */
	public static int executeUpdate(String sql) {
		int result = 0;
		con = getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
		} finally {
			closeAll();
		}
		return result;
	}

	/**
	 * 反射全部的数据名称
	 * 
	 * @return
	 */
	public Field[] getField(String className) {
		Field[] fields = null;
		try {
			Object o = Class.forName(className).newInstance();
			fields = o.getClass().getDeclaredFields();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return fields;
	}

	/**
	 * 关闭数据连接
	 */
	public static void closeCon() {
		try {
			if (null != con) {
				con.close();
				con = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void closeAll() {
		try {
			if (null != rs) {
				rs.close();
				rs = null;
			}
			if (null != pstmt) {
				pstmt.close();
				pstmt = null;
			}
			if (null != con) {
				con.close();
				con = null;
			}
		} catch (Exception e) {
		}

	}

	public static void main(String[] args) throws SQLException {
		DBUtils db = new DBUtils();
		String sql = "select * from tbl_article";
		ResultSet rs = DBUtils.getResultSet(sql);
		while (rs.next()) {
			ResultSetMetaData rsmd = rs.getMetaData();
			
			System.out.println(rsmd.getColumnCount());
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				String col_name = rsmd.getColumnName(i).toLowerCase();
				System.out.println(col_name);
			}
		}

	}
}
