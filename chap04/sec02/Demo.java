package com.java.jdbc.chap04.sec02;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.java .jdbc.util.DbUtil;
import com.java .jdbc.model.Book;

public class Demo {
	private static DbUtil dbUtil = new DbUtil();
	/**
	 * 插入数据库
	 * @param book
	 * @return
	 * @throws Exception
	 */
	private static int addBook(Book book)throws Exception{
		Connection con = dbUtil.getCon();//获取连接
		String sql = "insert into t_book values(null,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);//创建连接
		pstmt.setString(1, book.getBookName());//给第一个空设置值
		pstmt.setFloat(2, book.getPrice());//给第2个空设置值
		pstmt.setString(3, book.getAuthor());//给第3个空设置值
		pstmt.setInt(4, book.getBookTypeId());//给第4个空设置值
		int result = pstmt.executeUpdate();//执行语句返回数据
		dbUtil.colse(pstmt, con);
		
		
		return  result;
	}
	public static void main(String[] args) throws Exception{
		Book book = new Book("Java牛牛2222", 121, "牛哥222", 1);
		int result = addBook(book);
		if(result == 1){
			System.out.println("添加成共");
		}else{
			System.out.println("tianjishibai");
		}
	}
	

}
