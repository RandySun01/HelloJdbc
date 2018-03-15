package com.java.jdbc.chap08.sec01;

import java.sql.Connection;
import java.sql.DatabaseMetaData;

import com.java .jdbc.util.DbUtil;

public class Demo {
	
	/**
	 * 获取数据库版本
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception{
		DbUtil dbUtil = new DbUtil();
		Connection con = dbUtil.getCon();//获取数据库连接
		DatabaseMetaData dmd = con.getMetaData();//获取元素数据
		System.out.println("数据库名称:" + dmd.getDatabaseProductName());
		System.out.println("数据库版本"+dmd.getDatabaseMajorVersion()+","+dmd.getDatabaseMajorVersion());
	}

}
