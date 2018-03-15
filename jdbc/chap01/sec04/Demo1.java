package com.java.jdbc.chap01.sec04;
/**
 * 
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Demo1 {
	//数据库地址
	private static String dburl="jdbc:mysql://localhost:3306/db_book";
	//用户名
	private static String dbUserName= "root";
	//密码
	private static String dbPassword="123456";
	//驱动名称加载驱动
	private static String jbdcName = "com.mysql.jdbc.Driver";
	public static void main(String[] args) {
		try {
			Class.forName(jbdcName);
			System.out.println("驱动加载成功");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("驱动加载失败");
		}  
		//数据集库连接接口
		Connection con = null;
		try {
			con = DriverManager.getConnection(dburl, dbUserName, dbPassword);
		    System.out.println("数据库连接成功");
		    System.out.println("进行数据库操作");
		   // System.out.println(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				int t = 1;
				for(int i=1;i<=4;i++){
					t = t*i;
				}
				System.out.println(t);
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
