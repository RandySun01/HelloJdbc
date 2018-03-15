package com.java.jdbc.chap03.sec02;

import java.sql.Connection;
import java.sql.Statement;

import com.java .jdbc.util.DbUtil;
import com.java .jdbc.model.Book;

public class Demo2 {
	private static DbUtil dbUtil = new DbUtil();
	
	/**
	 * 添加图书2
	 * @param book
	 * @return
	 * @throws Exception
	 */
	private static int addBook2(Book book)throws Exception{
		Connection con = dbUtil.getCon();
		String sql = "insert into t_book values(null,'"+book.getBookName()+"',"+book.getPrice()+",'"+book.getAuthor()+"',"+book.getBookTypeId()+")";
		Statement stat = con.createStatement();
		System.out.println(sql);
		int result =stat.executeUpdate(sql);
		dbUtil.colse(stat, con);
		return result;
		
	}
	/** 
	 * 添加图书
	 * @param bookName
	 * @param price
	 * @param author
	 * @param bookTypeId
	 * @return
	 * @throws Exception
	 */
	public static int addBook(String bookName,float price,String author,int bookTypeId	)throws Exception{
	    Connection con = dbUtil.getCon();
		String sql = "insert into t_book values(null,'"+bookName+"',"+price+",'"+author+"',"+bookTypeId+")";
		System.out.println(sql);
	    Statement stat = con.createStatement();//创建Statement
	    int res = stat.executeUpdate(sql);
		dbUtil.colse(stat, con);//关闭statment 和连接
		return res;
	}
	public static void main(String[] args) throws Exception {
		
		Book book = new Book("java牛牛2",1212,"牛哥2",2);
		int result = addBook2(book);
		if(result ==1){
			System.out.println("添加成功");
		}else{
			System.out.println("添加失败");
		}
		
		
		
		
		
//		int result = addBook("java牛牛",123,"牛哥",1);
//		if(result == 1){
//			System.out.println("添加成功");
//		}else{
//			System.out.println("添加失败！");
//		}
		
	}

}
 