package com.internousdev.book_reviewsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.book_reviewsite.dto.LoginDTO;
import com.internousdev.book_reviewsite.util.DBConnector;

public class UserInfoDAO {

	private String userId;
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	//全てのユーザーの情報を呼び出すためのメソッド
	//戻り値：ユーザー情報が格納されたリスト型のDTOインスタンス
	public List<LoginDTO> getUserListAll() throws SQLException {

		List<LoginDTO> userInfoDTO = new ArrayList<LoginDTO>();

		//ユーザーの詳細情報を降順で100件呼び出すSQL文
		String sql = "SELECT * FROM user_info ORDER BY regist_date DESC LIMIT 100";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				LoginDTO dto = new LoginDTO();
				dto.setId(resultSet.getInt("id"));
				dto.setUserId(resultSet.getString("user_id"));
				dto.setNickName(resultSet.getString("nickname"));
				dto.setStatus(resultSet.getInt("status"));
				dto.setRegistDate(resultSet.getString("regist_date"));
				dto.setUpdateDate(resultSet.getString("update_date"));
				userInfoDTO.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

		return userInfoDTO;
	}

	//入力されたユーザーIDと同じ物がすでに存在しているか確認するメソッド
	//戻り値：判定結果を格納したboolean型変数rs
	public boolean checkUserId(String userId) {

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		boolean rs = true;

		String sql = "SELECT COUNT(*) AS count FROM user_info WHERE user_id = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				if (resultSet.getInt("count") > 0) {
					rs = false;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return rs;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}