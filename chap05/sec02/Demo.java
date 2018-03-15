package com.java.jdbc.chap05.sec02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.java .jdbc.util.DbUtil;
import com.java .jdbc.model.Book;

public class Demo {
	
	private static DbUtil dbUtil = new DbUtil();
	/**
	 * 遍历查询结果
	 * @throws Exception
	 */
	private static void listBook()throws Exception{
		Connection con = dbUtil.getCon();//获取数据库连接
		String sql = "select * from t_book";
		PreparedStatement past =  con.prepareStatement(sql);//预编译
	   ResultSet rs=  past.executeQuery(sql);//返回结果集Resultset
		while(rs.next()){
			int id = rs.getInt(1);//获取第一个列的值的编号id
			String bookName = rs.getString(2);//获取第二列的值图书名称boolName
			float price = rs.getFloat(3);//获取第三列的值图书价格 price
			String author = rs.getString(4);//获取第四列的值图书作者 author
			int bookTypeId = rs.getInt(5);//获取第五列的值图书类别 id；
			System.out.println("图书编号: "+id+" 图书名称: "+bookName+" 图书价格: "+price+" 图书作者:"+author+" 图书类别:"+bookTypeId);
		    System.out.println("==========================================================================="); 
		}
	}
	/**
	 * 遍历查询结果
	 * @throws Exception
	 */
	private static void listBook2()throws Exception{
		Connection con = dbUtil.getCon();//获取数据库连接
		String sql = "select * from t_book";
		PreparedStatement past =  con.prepareStatement(sql);//预编译
	   ResultSet rs=  past.executeQuery(sql);//返回结果集Resultset
		while(rs.next()){
			int id = rs.getInt("id");//获取第一个列的值的编号id
			String bookName = rs.getString("bookName");//获取第二列的值图书名称boolName
			float price = rs.getFloat("price");//获取第三列的值图书价格 price
			String author = rs.getString("author");//获取第四列的值图书作者 author
			int bookTypeId = rs.getInt("bookTypeId");//获取第五列的值图书类别 id；
			System.out.println("图书编号: "+id+" 图书名称: "+bookName+" 图书价格: "+price+" 图书作者:"+author+" 图书类别:"+bookTypeId);
		    System.out.println("==========================================================================="); 
		}
	}
	
	private static List<Book> listBook3()throws Exception{
		List<Book> bookList = new ArrayList<Book>(); 
		Connection con = dbUtil.getCon();//获取数据库连接
		String sql = "select * from t_book";
		PreparedStatement past =  con.prepareStatement(sql);//预编译
	   ResultSet rs=  past.executeQuery(sql);//返回结果集Resultset
		while(rs.next()){
			int id = rs.getInt("id");//获取第一个列的值的编号id
			String bookName = rs.getString("bookName");//获取第二列的值图书名称boolName
			float price = rs.getFloat("price");//获取第三列的值图书价格 price
			String author = rs.getString("author");//获取第四列的值图书作者 author
			int bookTypeId = rs.getInt("bookTypeId");//获取第五列的值图书类别 id；
			Book book = new Book(id, bookName, price, author, bookTypeId);
			bookList.add(book);
		}
			return bookList;
	}
	
	
	
	
	public static void main(String[] args) throws Exception{
		Demo demo = new Demo();
		//listBook();
		//ListBook2();
	    List<Book> bookList = 	listBook3();
	    for (Book book : bookList) {
			System.out.println(book);
		}
		
	}

}
