package com.java.jdbc.chap01.sec04;
/**
 * 
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Demo1 {
	//���ݿ��ַ
	private static String dburl="jdbc:mysql://localhost:3306/db_book";
	//�û���
	private static String dbUserName= "root";
	//����
	private static String dbPassword="123456";
	//�������Ƽ�������
	private static String jbdcName = "com.mysql.jdbc.Driver";
	public static void main(String[] args) {
		try {
			Class.forName(jbdcName);
			System.out.println("�������سɹ�");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("��������ʧ��");
		}  
		//���ݼ������ӽӿ�
		Connection con = null;
		try {
			con = DriverManager.getConnection(dburl, dbUserName, dbPassword);
		    System.out.println("���ݿ����ӳɹ�");
		    System.out.println("�������ݿ����");
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
