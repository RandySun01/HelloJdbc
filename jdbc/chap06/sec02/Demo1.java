package com.java.jdbc.chap06.sec02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.java .jdbc.util.DbUtil;
import com.java .jdbc.model.Book;
import com.mysql.jdbc.Blob;

 
 

public class Demo1 {

private static DbUtil dbUtil=new DbUtil();
	
	/**
	 * 大数据处理二进制 blog
	 * 添加图书
	 * 插入文本aetAsciiStream()
	 * @param book
	 * @return
	 * @throws Exception
	 */
	private static int addBook(Book book)throws Exception{
		Connection con=dbUtil.getCon(); // 获取连接
		String sql="insert into t_book1 values(null,?,?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, book.getBookName());  // 给第一个坑设置值
		pstmt.setFloat(2, book.getPrice());  // 给第二个坑设置值
		pstmt.setString(3, book.getAuthor()); // 给第三个坑设置值
		pstmt.setInt(4, book.getBookTypeId());  // 给第四个坑设置值
		File context=book.getContext(); // 获取文件
		InputStream inputStream=new FileInputStream(context);
		pstmt.setAsciiStream(5, inputStream,context.length());  // 给第五个坑设置值
		File pic = book.getPic();//获取图片
		InputStream inputStream2=new FileInputStream(pic);
		pstmt.setBinaryStream(6, inputStream2,pic.length());//给第六个空
		
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
		Blob b = (Blob) rs.getBlob("pic");
		FileOutputStream out  = new FileOutputStream(new File("d:/pic2.jpg"));
		out.write(b.getBytes(1,	 (int)b.length()));
		out.close();
		System.out.println("图书编号: "+id+" 图书名称: "
		+bookName+" 图书价格: "+price+" 图书作者:"
		+author+" 图书类别:"+bookTypeId+" context: "+context);
		}
		
		dbUtil.colse(pres, con);
	}
	
	
	public static void main(String[] args) throws Exception{
		/*File context=new File("d:/Hello.txt");
		File pic = new File("d:/peng.jpg");
		Book book=new Book("helloWorld", 100, "阿志", 1,context,pic);
		int result=addBook(book);

		if(result==1){
			System.out.println("添加成功！");
		}else{
			System.out.println("添加失败！");
		}*/
		getBook(9);
	}

}
