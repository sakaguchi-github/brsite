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

	private String sql = "INSERT INTO book_info(regiuser_id,title,author,co_author,publisher,genre_id,regist_date) VALUES(?,?,?,?,?,?,?)";

	public int bookRegist(String userId,String title,String author,String co_Author,String publisher,int genreId) throws SQLException{

		int res = 0;

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, title);
			preparedStatement.setString(3, author);
			preparedStatement.setString(4, co_Author);
			preparedStatement.setString(5, publisher);
			preparedStatement.setInt(6, genreId);
			preparedStatement.setString(7, dateUtil.getDate());

			res = preparedStatement.executeUpdate();

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
		return res;
	}

}