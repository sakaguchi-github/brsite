package com.internousdev.book_reviewsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.book_reviewsite.dto.LoginDTO;
import com.internousdev.book_reviewsite.util.DBConnector;

public class LoginDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private LoginDTO loginDTO = new LoginDTO();

	//入力情報と合致するユーザー情報を取得するメソッド
	//引数：IDとパスワード
	//戻り値：ユーザー情報を保持したDTOインスタンス
	public LoginDTO getLoginUserInfo(String userId, String password) {

		String sql = "SELECT * FROM user_info where user_id = ? AND password = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				loginDTO.setId(resultSet.getInt("id"));
				loginDTO.setUserId(resultSet.getString("user_id"));
				loginDTO.setPassword(resultSet.getString("password"));
				loginDTO.setNickName(resultSet.getString("nickname"));
				loginDTO.setStatus(resultSet.getInt("status"));
				loginDTO.setRegistDate(resultSet.getString("regist_date"));
				loginDTO.setUpdateDate(resultSet.getString("update_date"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return loginDTO;
	}

	//現在のパスワードをチェックするメソッド
	//戻り値：現在のパスワードを元にユーザーIDを取得できれば1を返す
	public int nowPassCheck(int id, String password) {

		int pcr = 0;
		String sql = "SELECT user_id FROM user_info where id = ? AND password = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				if (!(resultSet.getString("user_id").equals(""))) {
					pcr = 1;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pcr;
	}

}
