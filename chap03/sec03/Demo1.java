package com.java.jdbc.chap03.sec03;
 
import java.sql.Connection;
import java.sql.Statement;

import com.java .jdbc.util.DbUtil;
import com.java .jdbc.model.Book;

public class Demo1 {
	private static DbUtil dbUtil = new DbUtil();
	/**
	 * ����ͼ��
	 * @param book
	 * @return
	 * @throws Exception
	 */
	private static int updatBook(Book book)throws Exception{
		
		Connection con = dbUtil.getCon();//��ȡ���ݿ�����
		String sql = "update t_book set bookName='" + book.getBookName()
		+ "',price= " + book.getPrice() + ",author='" + book.getAuthor()
		+ "',bookTypeId=" + book.getBookTypeId() + " where id="
		+ book.getId();  // ctrl+a ȫѡ  ctrl+shift+F ��ʽ������
		Statement state = con.createStatement(); // ����Ԥ����
		int result = state.executeUpdate(sql); //                                                                                                                                                                    ִ�з�������
		dbUtil.colse(state, con);
		return result;
	}
	public static void main(String[] args) {
		Book book = new Book(3,"javaţţ22",1212,"ţ��2",1);
		int result;
		try {
			result = updatBook(book);
			if(result == 1){
				System.out.println("���³ɹ�");
			}else{
				System.out.println("����ʧ��");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}

}
