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

	private int id;
	private String userId;
	private String nickName;
	private int status;
	private String registDate;
	private String updateDate;

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	//全てのユーザーの情報を一括で呼び出すためのメソッド
	public List<LoginDTO> getUserListAll() throws SQLException {

		List<LoginDTO> userInfoDTO = new ArrayList<LoginDTO>();

		//ユーザーの詳細情報を呼び出すSQL文
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getRegistDate() {
		return registDate;
	}

	public void setRegistDate(String registDate) {
		this.registDate = registDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

}