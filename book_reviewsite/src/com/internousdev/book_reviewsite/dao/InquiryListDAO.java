package com.internousdev.book_reviewsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.book_reviewsite.dto.InquiryDTO;
import com.internousdev.book_reviewsite.util.DBConnector;

public class InquiryListDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	//全ての問い合わせ情報を一括で呼び出すためのメソッド
	public List<InquiryDTO> getInquiryListAll() throws SQLException {

		List<InquiryDTO> InquiryInfoDTO = new ArrayList<InquiryDTO>();

		//問い合わせ詳細情報を呼び出すSQL文
		String sql = "SELECT * FROM inquiry_info ORDER BY regist_date DESC LIMIT 100";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				InquiryDTO dto = new InquiryDTO();
				dto.setInquiryId(resultSet.getInt("inquiry_id"));
				dto.setRegiUserId(resultSet.getString("regiuser_id"));
				dto.setiType(resultSet.getString("itype"));
				dto.setiTitle(resultSet.getString("ititle"));
				dto.setiText(resultSet.getString("itext"));
				dto.setRegistDate(resultSet.getString("regist_date"));
				dto.setReplyDate(resultSet.getString("reply_date"));
				dto.setfFlg(resultSet.getBoolean("f_flg"));
				InquiryInfoDTO.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

		return InquiryInfoDTO;
	}

}