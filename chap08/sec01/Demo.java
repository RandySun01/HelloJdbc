package com.java.jdbc.chap08.sec01;

import java.sql.Connection;
import java.sql.DatabaseMetaData;

import com.java .jdbc.util.DbUtil;

public class Demo {
	
	/**
	 * ��ȡ���ݿ�汾
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception{
		DbUtil dbUtil = new DbUtil();
		Connection con = dbUtil.getCon();//��ȡ���ݿ�����
		DatabaseMetaData dmd = con.getMetaData();//��ȡԪ������
		System.out.println("���ݿ�����:" + dmd.getDatabaseProductName());
		System.out.println("���ݿ�汾"+dmd.getDatabaseMajorVersion()+","+dmd.getDatabaseMajorVersion());
	}

}
