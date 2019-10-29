package com.internousdev.book_reviewsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.book_reviewsite.util.DBConnector;
import com.internousdev.book_reviewsite.util.DateUtil;

public class ReviewPostDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private DateUtil dateUtil = new DateUtil();

	private String sql = "INSERT INTO review_info(regiuser_id,book_id,highlight,recommendation,tag,text,regist_date) VALUES(?,?,?,?,?,?,?)";

	public int reviewPost(String userId,int bookId,String highlight,int recommendation,String tag,String text) throws SQLException{

		int res = 0;

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			preparedStatement.setInt(2, bookId);
			preparedStatement.setString(3, highlight);
			preparedStatement.setInt(4, recommendation);
			preparedStatement.setString(5, tag);
			preparedStatement.setString(6, text);
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