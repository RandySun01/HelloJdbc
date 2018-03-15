package com.java.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtil {
	//	数据库地址
	private static String dbUrl = "jdbc:mysql://localhost:3306/db_bank";
	//	用户名
	private static String dbUerName = "root";
	// 密码
	private static String dbPassword = "123456";
	//驱动名称
	private static String jdbcName = "com.mysql.jdbc.Driver";
	/**
	 * 	获取数据库连接
	 * 
	 * @return
	 * @throws Exception
	 */
	public Connection getCon() throws  Exception {
		 
			Class.forName(jdbcName);
			Connection con = DriverManager.getConnection(dbUrl, dbUerName, dbPassword);
		    return con;
		 
	}
	/**
	 * 关闭连接
	 * @param con
	 * @throws Exception
	 */
	public void colse(Statement stmt,Connection con)throws Exception{
		if(stmt != null){
			stmt.close();
			if(con != null){
				con.close();
			}
		}
		
	}

}
 