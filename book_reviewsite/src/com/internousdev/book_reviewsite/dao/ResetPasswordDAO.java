package com.internousdev.book_reviewsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.internousdev.book_reviewsite.util.DBConnector;
import com.internousdev.book_reviewsite.util.DateUtil;

public class ResetPasswordDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private DateUtil dateUtil = new DateUtil();
	int res = 0;

	//IDとパスワードが合致する登録情報のパスワードを新しいものに更新するメソッド
	//戻り値：更新成功件数が格納されたint型変数res
	public int resetPassword(String newPassword, int id, String password) {

		String sql = "UPDATE user_info SET password = ?, update_date = ? WHERE id = ? AND password = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, newPassword);
			preparedStatement.setString(2, dateUtil.getDate());
			preparedStatement.setInt(3, id);
			preparedStatement.setString(4, password);
			res = preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
	}

}
