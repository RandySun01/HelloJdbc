package com.java.jdbc.chap04.sec03;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.java .jdbc.util.DbUtil;
import com.java .jdbc.model.Book;

public class Demo {
	
	private static DbUtil dbUtil = new DbUtil();
	/**
	 * ����ͼ��
	 * @param book
	 * @return
	 * @throws Exception
	 */
	private static int updateBook(Book book)throws Exception{
		Connection con = dbUtil.getCon();
		String sql="update t_book set bookName=?,price=?,author=?,bookTypeId=? where id=?";
		PreparedStatement prst = con.prepareStatement(sql);//ִ���������Ԥ����
		prst.setString(1, book.getBookName());
		prst.setFloat(2, book.getPrice());
		prst.setString(3,book.getAuthor());
		prst.setInt(4, book.getBookTypeId());
		prst.setInt(5, book.getId());
		int result = prst.executeUpdate();//ִ�����
		dbUtil.colse(prst, con);
		return result;
	}

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		Book  book = new Book(4,"Javaţţ2222", 121, "ţ��222", 1);
	    int result = updateBook(book);
	    if(result == 1){
	    	System.out.println("���³ɹ�");
	    }else{
	    	System.out.println("����ʧ��");
	    }
	}

}
