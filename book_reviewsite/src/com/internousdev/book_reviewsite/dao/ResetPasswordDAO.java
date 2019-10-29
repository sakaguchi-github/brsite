package com.internousdev.book_reviewsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.internousdev.book_reviewsite.util.DBConnector;

public class ResetPasswordDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	int res = 0;

	public int resetPassword(String newPassword, int id, String password) {

		String sql = "UPDATE user_info SET password = ? WHERE id = ? AND password = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, newPassword);
			preparedStatement.setInt(2, id);
			preparedStatement.setString(3, password);

			res = preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
	}

}
