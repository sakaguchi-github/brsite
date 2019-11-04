package com.internousdev.book_reviewsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.book_reviewsite.util.DBConnector;
import com.internousdev.book_reviewsite.util.DateUtil;

public class BookRegistDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private DateUtil dateUtil = new DateUtil();

	private String sql = "INSERT INTO book_info(regiuser_id,title,author,co_author,publisher,book_type,book_genre,regist_date) VALUES(?,?,?,?,?,?,?,?)";

	//書籍情報を登録するためのメソッド
	//戻り値：登録成功件数を格納したint型変数
	public int bookRegist(int id,String title,String author,String co_Author,String publisher,String bookType, String bookGenre) throws SQLException{

		int res = 0;

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, title);
			preparedStatement.setString(3, author);
			preparedStatement.setString(4, co_Author);
			preparedStatement.setString(5, publisher);
			preparedStatement.setString(6, bookType);
			preparedStatement.setString(7, bookGenre);
			preparedStatement.setString(8, dateUtil.getDate());

			res = preparedStatement.executeUpdate();

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
		return res;
	}

}