package com.java.jdbc.chap07.sec02;

import java.sql.CallableStatement;
import java.sql.Connection;

import com.java .jdbc.util.DbUtil;

public class Demo1 {
	private static DbUtil dbUtil = new DbUtil();
	/**
	 * ���̴洢��ѯ
	 * @param id
	 * @return
	 * @throws Exception
	 */
	private static String getBookNameById(int id)throws Exception{
		Connection con = dbUtil.getCon();//��ȡ�������ݿ�����
		String sql = "{CALL pro_getBookNameById(?,?)}";//
		CallableStatement cstemt =  con.prepareCall(sql);//Ԥ����
		cstemt.setInt(1, id);//Ϊ�����ò���
		cstemt.execute();//ִ�н������
		String bookName = cstemt.getString("bN");//���ز�������
		dbUtil.colse(cstemt, con);//�ر�
		
		return bookName;
	}
	public static void main(String[] args) throws Exception{
		System.out.println("ͼ�������ǣ�"+getBookNameById(1));
	}

}
