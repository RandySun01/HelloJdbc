package com.java.jdbc.chap08.sec02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;

import com.java .jdbc.util.DbUtil;

public class Demo1 {
	/**
	 *获取 数据库中类数据的名称和类型
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception{
		DbUtil dbUtil = new DbUtil();
		Connection con = dbUtil.getCon();
		String sql = "select * from t_book";
		PreparedStatement pstmet = con.prepareStatement(sql);//预编译
		ResultSetMetaData rsmd = pstmet.getMetaData();//
		int num = rsmd.getColumnCount();//获取元素列的总数
		System.out.println("共有"+num +"列");
		for(int i = 1; i<=num; i++){
			System.out.println(rsmd.getColumnName(i)+","+rsmd.getColumnTypeName(i));
			
		}
		
	}

}
