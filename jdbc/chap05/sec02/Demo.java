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
	 * ������ѯ���
	 * @throws Exception
	 */
	private static void listBook()throws Exception{
		Connection con = dbUtil.getCon();//��ȡ���ݿ�����
		String sql = "select * from t_book";
		PreparedStatement past =  con.prepareStatement(sql);//Ԥ����
	   ResultSet rs=  past.executeQuery(sql);//���ؽ����Resultset
		while(rs.next()){
			int id = rs.getInt(1);//��ȡ��һ���е�ֵ�ı��id
			String bookName = rs.getString(2);//��ȡ�ڶ��е�ֵͼ������boolName
			float price = rs.getFloat(3);//��ȡ�����е�ֵͼ��۸� price
			String author = rs.getString(4);//��ȡ�����е�ֵͼ������ author
			int bookTypeId = rs.getInt(5);//��ȡ�����е�ֵͼ����� id��
			System.out.println("ͼ����: "+id+" ͼ������: "+bookName+" ͼ��۸�: "+price+" ͼ������:"+author+" ͼ�����:"+bookTypeId);
		    System.out.println("==========================================================================="); 
		}
	}
	/**
	 * ������ѯ���
	 * @throws Exception
	 */
	private static void listBook2()throws Exception{
		Connection con = dbUtil.getCon();//��ȡ���ݿ�����
		String sql = "select * from t_book";
		PreparedStatement past =  con.prepareStatement(sql);//Ԥ����
	   ResultSet rs=  past.executeQuery(sql);//���ؽ����Resultset
		while(rs.next()){
			int id = rs.getInt("id");//��ȡ��һ���е�ֵ�ı��id
			String bookName = rs.getString("bookName");//��ȡ�ڶ��е�ֵͼ������boolName
			float price = rs.getFloat("price");//��ȡ�����е�ֵͼ��۸� price
			String author = rs.getString("author");//��ȡ�����е�ֵͼ������ author
			int bookTypeId = rs.getInt("bookTypeId");//��ȡ�����е�ֵͼ����� id��
			System.out.println("ͼ����: "+id+" ͼ������: "+bookName+" ͼ��۸�: "+price+" ͼ������:"+author+" ͼ�����:"+bookTypeId);
		    System.out.println("==========================================================================="); 
		}
	}
	
	private static List<Book> listBook3()throws Exception{
		List<Book> bookList = new ArrayList<Book>(); 
		Connection con = dbUtil.getCon();//��ȡ���ݿ�����
		String sql = "select * from t_book";
		PreparedStatement past =  con.prepareStatement(sql);//Ԥ����
	   ResultSet rs=  past.executeQuery(sql);//���ؽ����Resultset
		while(rs.next()){
			int id = rs.getInt("id");//��ȡ��һ���е�ֵ�ı��id
			String bookName = rs.getString("bookName");//��ȡ�ڶ��е�ֵͼ������boolName
			float price = rs.getFloat("price");//��ȡ�����е�ֵͼ��۸� price
			String author = rs.getString("author");//��ȡ�����е�ֵͼ������ author
			int bookTypeId = rs.getInt("bookTypeId");//��ȡ�����е�ֵͼ����� id��
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
