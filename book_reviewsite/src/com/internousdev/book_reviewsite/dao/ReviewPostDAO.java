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

	private String sql = "INSERT INTO review_info(regiuser_id,book_id,highlight,recommendation,text,spoiler_flg,regist_date) VALUES(?,?,?,?,?,?,?)";

	//レビューをDBに登録するメソッド
	//戻り値：登録成功件数を格納したint型変数res
	public int reviewPost(int id,int bookId,String highlight,int recommendation,String text, boolean sFlg) throws SQLException{

		int res = 0;

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.setInt(2, bookId);
			preparedStatement.setString(3, highlight);
			preparedStatement.setInt(4, recommendation);
			preparedStatement.setString(5, text);
			preparedStatement.setBoolean(6, sFlg);
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