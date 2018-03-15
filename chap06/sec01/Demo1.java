package com.java.jdbc.chap06.sec01;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.java .jdbc.util.DbUtil;
import com.java .jdbc.model.Book;

 
 

public class Demo1 {

private static DbUtil dbUtil=new DbUtil();
	
	/**
	 * �����ݴ����ı�clob
	 * ���ͼ��
	 * �����ı�aetAsciiStream()
	 * @param book
	 * @return
	 * @throws Exception
	 */
	private static int addBook(Book book)throws Exception{
		Connection con=dbUtil.getCon(); // ��ȡ����
		String sql="insert into t_book1 values(null,?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, book.getBookName());  // ����һ��������ֵ
		pstmt.setFloat(2, book.getPrice());  // ���ڶ���������ֵ
		pstmt.setString(3, book.getAuthor()); // ��������������ֵ
		pstmt.setInt(4, book.getBookTypeId());  // �����ĸ�������ֵ
		File context=book.getContext(); // ��ȡ�ļ�
		InputStream inputStream=new FileInputStream(context);
		pstmt.setAsciiStream(5, inputStream,context.length());  // �������������ֵ
		int result=pstmt.executeUpdate();
		dbUtil.colse(pstmt, con);
		return result;
	}
	
	public static void getBook(int id)throws Exception{
		Connection con = dbUtil.getCon();
		String sql = "select * from t_book1 where id=?";
		PreparedStatement pres = con.prepareStatement(sql);
		pres.setInt(1, id);
		ResultSet rs = pres.executeQuery();
		if(rs.next()){
		String bookName = rs.getString("bookName");
		float price = rs.getFloat("price");
		String author = rs.getString("author");
		int bookTypeId = rs.getInt("bookTypeId");
		Clob c = rs.getClob("context");
		String context = c.getSubString(1, (int)c.length());
		System.out.println("ͼ����: "+id+" ͼ������: "
		+bookName+" ͼ��۸�: "+price+" ͼ������:"
		+author+" ͼ�����:"+bookTypeId+" context: "+context);
		}
		
		dbUtil.colse(pres, con);
	}
	
	
	public static void main(String[] args) throws Exception{
		/*File context=new File("d:/Hello.txt");
		Book book=new Book("helloWorld", 100, "��־", 1,context);
		int result=addBook(book);

		if(result==1){
			System.out.println("��ӳɹ���");
		}else{
			System.out.println("���ʧ�ܣ�");
		} */
		getBook(6);
	}

}
