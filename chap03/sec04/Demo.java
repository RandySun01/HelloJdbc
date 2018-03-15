package com.java.jdbc.chap03.sec04;

import java.sql.Connection;
import java.sql.Statement;

import com.java .jdbc.util.DbUtil;

public class Demo {
 
	private static DbUtil dbUtil = new DbUtil();
	
	private static int deleteBook(int id)throws Exception	{
		Connection con = dbUtil.getCon();//获取连接
		String sql = "delete from t_book where id ="+id;
		Statement stat = con.createStatement();//创建连接预编译
		int result = stat.executeUpdate(sql);//执行语句
		dbUtil.colse(stat, con);
		return result;
	}
	public static void main(String[] args)throws Exception {
		int result = deleteBook(1);
		if(result ==1){
			System.out.println("刪除成功");
		}else{
			System.out.println("刪除失敗");
		}
	}
}
