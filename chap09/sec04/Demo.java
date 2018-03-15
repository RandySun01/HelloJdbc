package com.java.jdbc.chap09.sec04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

import com.java .jdbc.util.DbUtil;

public class Demo {
	private static DbUtil dbUtil= new DbUtil();
	/**
	 * zת��
	 * @param con
	 * @param accountName
	 * @param account
	 * @throws Exception
	 */
	private static void outCount(Connection con, String accountName, int account)throws Exception{
	String sql = "update t_account set accountBalance = accountBalance-? where accountName=?";
	PreparedStatement psmt = con.prepareStatement(sql);	//	Ԥ����
	psmt.setInt(1, account);
	psmt.setString(2, accountName);
	psmt.executeUpdate();
	}
	/**
	 * ת��
	 * @param con
	 * @param accountName
	 * @param account
	 * @throws Exception
	 */
	private static void inCount(Connection con, String accountName, int account)throws Exception{
		String sql = "update t_account set accountBalance = accountBalance+? where accountName=?";
		PreparedStatement psmt = con.prepareStatement(sql);	//	Ԥ����
		psmt.setInt(1, account);
		psmt.setString(2, accountName);
		psmt.executeUpdate();
		}
	public static void main(String[] args) {
		Connection con = null;
		Savepoint sp = null;
		 try {
			con = dbUtil.getCon();
			con.setAutoCommit(false);	//	ȡ���Զ��ύ
			System.out.println("������ʼ������ת��");
			int account = 500;
			outCount(con ,"����",account);
			sp = con.setSavepoint();	//	����һ�������
			inCount(con,"����",account);
			System.out.println("ת�˳ɹ�");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			try {
				con.rollback(sp);		//	�ع���sp�����
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
				con.commit();		//	�ύ����
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		 
	}

}
