package com.java.jdbc.chap04.sec02;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.java .jdbc.util.DbUtil;
import com.java .jdbc.model.Book;

public class Demo {
	private static DbUtil dbUtil = new DbUtil();
	/**
	 * �������ݿ�
	 * @param book
	 * @return
	 * @throws Exception
	 */
	private static int addBook(Book book)throws Exception{
		Connection con = dbUtil.getCon();//��ȡ����
		String sql = "insert into t_book values(null,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);//��������
		pstmt.setString(1, book.getBookName());//����һ��������ֵ
		pstmt.setFloat(2, book.getPrice());//����2��������ֵ
		pstmt.setString(3, book.getAuthor());//����3��������ֵ
		pstmt.setInt(4, book.getBookTypeId());//����4��������ֵ
		int result = pstmt.executeUpdate();//ִ����䷵������
		dbUtil.colse(pstmt, con);
		
		
		return  result;
	}
	public static void main(String[] args) throws Exception{
		Book book = new Book("Javaţţ2222", 121, "ţ��222", 1);
		int result = addBook(book);
		if(result == 1){
			System.out.println("��ӳɹ�");
		}else{
			System.out.println("tianjishibai");
		}
	}
	

}
