package com.java.jdbc.chap03.sec04;

import java.sql.Connection;
import java.sql.Statement;

import com.java .jdbc.util.DbUtil;

public class Demo {
 
	private static DbUtil dbUtil = new DbUtil();
	
	private static int deleteBook(int id)throws Exception	{
		Connection con = dbUtil.getCon();//��ȡ����
		String sql = "delete from t_book where id ="+id;
		Statement stat = con.createStatement();//��������Ԥ����
		int result = stat.executeUpdate(sql);//ִ�����
		dbUtil.colse(stat, con);
		return result;
	}
	public static void main(String[] args)throws Exception {
		int result = deleteBook(1);
		if(result ==1){
			System.out.println("�h���ɹ�");
		}else{
			System.out.println("�h��ʧ��");
		}
	}
}
