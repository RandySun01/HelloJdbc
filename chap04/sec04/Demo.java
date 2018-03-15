package com.java.jdbc.chap04.sec04;

import com.java .jdbc.util.DbUtil;
import com.java .jdbc.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
public class Demo {
	private static DbUtil dbUtil = new DbUtil();
	/**
	 *  ɾ��ͼ��
	 * @param id
	 * @return
	 * @throws Exception
	 */
	private static int deleteBook(int id)throws Exception{
		Connection con = dbUtil.getCon();//�������ݿ�����
		String sql = "delete from t_book where id=?";
		PreparedStatement pre = con.prepareStatement(sql);//Ԥ����
		pre.setInt(1, id);
		int result = pre.executeUpdate();//ִ��
		dbUtil.colse(pre, con);//�ر�����
		return result;
	}
	public static void main(String[] args)throws Exception {
		int result =deleteBook(2);
		if(result == 1){
			System.out.println("�h���ɹ�");
		}else{
			System.out.println("�h��ʧ��");
		}
	}

}
