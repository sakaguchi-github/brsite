package com.internousdev.book_reviewsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.book_reviewsite.util.DBConnector;
import com.internousdev.book_reviewsite.util.DateUtil;

public class UserCreateCompleteDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private DateUtil dateUtil = new DateUtil();

	private String sql = "INSERT INTO user_info(user_id,password,nickname,regist_date) VALUES(?,?,?,?)";

	public void createUser(String userId,String password,String nickName) throws SQLException{

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, nickName);
			preparedStatement.setString(4, dateUtil.getDate());
			preparedStatement.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
	}

}