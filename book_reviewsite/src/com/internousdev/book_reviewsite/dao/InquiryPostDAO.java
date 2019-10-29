package com.internousdev.book_reviewsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.book_reviewsite.util.DBConnector;
import com.internousdev.book_reviewsite.util.DateUtil;

public class InquiryPostDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private DateUtil dateUtil = new DateUtil();

	private String sql = "INSERT INTO inquiry_info(regiuser_id,itype,ititle,itext,regist_date) VALUES(?,?,?,?,?)";

	public int inquiryPost(String userId,String iType,String iTitle,String iText) throws SQLException{

		int res = 0;

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, iType);
			preparedStatement.setString(3, iTitle);
			preparedStatement.setString(4, iText);
			preparedStatement.setString(5, dateUtil.getDate());

			res = preparedStatement.executeUpdate();

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
		return res;
	}

}