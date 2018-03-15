package com.java.jdbc.chap03.sec02;

import java.sql.Connection;
import java.sql.Statement;

import com.java .jdbc.util.DbUtil;
import com.java .jdbc.model.Book;

public class Demo2 {
	private static DbUtil dbUtil = new DbUtil();
	
	/**
	 * ���ͼ��2
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
	 * ���ͼ��
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
	    Statement stat = con.createStatement();//����Statement
	    int res = stat.executeUpdate(sql);
		dbUtil.colse(stat, con);//�ر�statment ������
		return res;
	}
	public static void main(String[] args) throws Exception {
		
		Book book = new Book("javaţţ2",1212,"ţ��2",2);
		int result = addBook2(book);
		if(result ==1){
			System.out.println("��ӳɹ�");
		}else{
			System.out.println("���ʧ��");
		}
		
		
		
		
		
//		int result = addBook("javaţţ",123,"ţ��",1);
//		if(result == 1){
//			System.out.println("��ӳɹ�");
//		}else{
//			System.out.println("���ʧ�ܣ�");
//		}
		
	}

}
 