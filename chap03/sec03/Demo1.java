package com.java.jdbc.chap03.sec03;
 
import java.sql.Connection;
import java.sql.Statement;

import com.java .jdbc.util.DbUtil;
import com.java .jdbc.model.Book;

public class Demo1 {
	private static DbUtil dbUtil = new DbUtil();
	/**
	 * 更新图书
	 * @param book
	 * @return
	 * @throws Exception
	 */
	private static int updatBook(Book book)throws Exception{
		
		Connection con = dbUtil.getCon();//获取数据库连接
		String sql = "update t_book set bookName='" + book.getBookName()
		+ "',price= " + book.getPrice() + ",author='" + book.getAuthor()
		+ "',bookTypeId=" + book.getBookTypeId() + " where id="
		+ book.getId();  // ctrl+a 全选  ctrl+shift+F 格式化代码
		Statement state = con.createStatement(); // 创建预编译
		int result = state.executeUpdate(sql); //                                                                                                                                                                    执行返回数据
		dbUtil.colse(state, con);
		return result;
	}
	public static void main(String[] args) {
		Book book = new Book(3,"java牛牛22",1212,"牛哥2",1);
		int result;
		try {
			result = updatBook(book);
			if(result == 1){
				System.out.println("更新成功");
			}else{
				System.out.println("更新失败");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}

}
