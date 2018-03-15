package com.java.jdbc.chap04.sec03;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.java .jdbc.util.DbUtil;
import com.java .jdbc.model.Book;

public class Demo {
	
	private static DbUtil dbUtil = new DbUtil();
	/**
	 * 更新图书
	 * @param book
	 * @return
	 * @throws Exception
	 */
	private static int updateBook(Book book)throws Exception{
		Connection con = dbUtil.getCon();
		String sql="update t_book set bookName=?,price=?,author=?,bookTypeId=? where id=?";
		PreparedStatement prst = con.prepareStatement(sql);//执行语句连接预编译
		prst.setString(1, book.getBookName());
		prst.setFloat(2, book.getPrice());
		prst.setString(3,book.getAuthor());
		prst.setInt(4, book.getBookTypeId());
		prst.setInt(5, book.getId());
		int result = prst.executeUpdate();//执行语句
		dbUtil.colse(prst, con);
		return result;
	}

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		Book  book = new Book(4,"Java牛牛2222", 121, "牛哥222", 1);
	    int result = updateBook(book);
	    if(result == 1){
	    	System.out.println("更新成功");
	    }else{
	    	System.out.println("更新失敗");
	    }
	}

}
