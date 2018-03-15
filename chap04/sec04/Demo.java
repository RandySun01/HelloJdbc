package com.java.jdbc.chap04.sec04;

import com.java .jdbc.util.DbUtil;
import com.java .jdbc.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
public class Demo {
	private static DbUtil dbUtil = new DbUtil();
	/**
	 *  删除图书
	 * @param id
	 * @return
	 * @throws Exception
	 */
	private static int deleteBook(int id)throws Exception{
		Connection con = dbUtil.getCon();//建立数据库连接
		String sql = "delete from t_book where id=?";
		PreparedStatement pre = con.prepareStatement(sql);//预编译
		pre.setInt(1, id);
		int result = pre.executeUpdate();//执行
		dbUtil.colse(pre, con);//关闭连接
		return result;
	}
	public static void main(String[] args)throws Exception {
		int result =deleteBook(2);
		if(result == 1){
			System.out.println("刪除成功");
		}else{
			System.out.println("刪除失敗");
		}
	}

}
