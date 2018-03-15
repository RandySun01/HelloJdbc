package com.java.jdbc.chap07.sec02;

import java.sql.CallableStatement;
import java.sql.Connection;

import com.java .jdbc.util.DbUtil;

public class Demo1 {
	private static DbUtil dbUtil = new DbUtil();
	/**
	 * 过程存储查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	private static String getBookNameById(int id)throws Exception{
		Connection con = dbUtil.getCon();//获取连接数据库连接
		String sql = "{CALL pro_getBookNameById(?,?)}";//
		CallableStatement cstemt =  con.prepareCall(sql);//预编译
		cstemt.setInt(1, id);//为空设置参数
		cstemt.execute();//执行结果返回
		String bookName = cstemt.getString("bN");//返回查新数据
		dbUtil.colse(cstemt, con);//关闭
		
		return bookName;
	}
	public static void main(String[] args) throws Exception{
		System.out.println("图书名称是："+getBookNameById(1));
	}

}
