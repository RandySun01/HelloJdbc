package com.java.jdbc.chap09.sec04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

import com.java .jdbc.util.DbUtil;

public class Demo {
	private static DbUtil dbUtil= new DbUtil();
	/**
	 * z转出
	 * @param con
	 * @param accountName
	 * @param account
	 * @throws Exception
	 */
	private static void outCount(Connection con, String accountName, int account)throws Exception{
	String sql = "update t_account set accountBalance = accountBalance-? where accountName=?";
	PreparedStatement psmt = con.prepareStatement(sql);	//	预编译
	psmt.setInt(1, account);
	psmt.setString(2, accountName);
	psmt.executeUpdate();
	}
	/**
	 * 转入
	 * @param con
	 * @param accountName
	 * @param account
	 * @throws Exception
	 */
	private static void inCount(Connection con, String accountName, int account)throws Exception{
		String sql = "update t_account set accountBalance = accountBalance+? where accountName=?";
		PreparedStatement psmt = con.prepareStatement(sql);	//	预编译
		psmt.setInt(1, account);
		psmt.setString(2, accountName);
		psmt.executeUpdate();
		}
	public static void main(String[] args) {
		Connection con = null;
		Savepoint sp = null;
		 try {
			con = dbUtil.getCon();
			con.setAutoCommit(false);	//	取消自动提交
			System.out.println("张三开始向李四转账");
			int account = 500;
			outCount(con ,"张三",account);
			sp = con.setSavepoint();	//	设置一个保存点
			inCount(con,"李四",account);
			System.out.println("转账成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			try {
				con.rollback(sp);		//	回滚到sp保存点
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
				con.commit();		//	提交事务
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		 
	}

}
