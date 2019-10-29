package com.internousdev.book_reviewsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.book_reviewsite.dto.ReviewDTO;
import com.internousdev.book_reviewsite.util.DBConnector;

public class ReviewListDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	//レビュー検索画面用のレビュー一覧を表示するためのメソッド
	public ArrayList<ReviewDTO> getReviewAll() throws SQLException {

		ArrayList<ReviewDTO> reviewListDTO = new ArrayList<ReviewDTO>();

		//全てのレビュー情報リストを呼び出すSQL文
		String sql = "SELECT ri.book_id, bi.title, bi.author, ri.review_id, ri.regiuser_id, ri.highlight, ri.text, ri.recommendation, ri.ar_color, ri.tag, ri.regist_date, ri.update_date "
				+ "FROM review_info ri LEFT JOIN book_info bi "
				+ "ON ri.book_id = bi.book_id "
				+ "ORDER BY ri.regist_date DESC LIMIT 30";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				ReviewDTO dto = new ReviewDTO();
				dto.setBookId(resultSet.getInt("book_id"));
				dto.setTitle(resultSet.getString("title"));
				dto.setAuthor(resultSet.getString("author"));
				dto.setReviewId(resultSet.getInt("review_id"));
				dto.setRegiUserId(resultSet.getString("regiuser_id"));
				dto.setHighlight(resultSet.getString("highlight"));
				dto.setText(resultSet.getString("text"));
				dto.setRecommendation(resultSet.getInt("recommendation"));
				dto.setArColor(resultSet.getString("ar_color"));
				dto.setTag(resultSet.getString("tag"));
				dto.setRegistDate(resultSet.getString("regist_date"));
				dto.setUpdateDate(resultSet.getString("update_date"));
				reviewListDTO.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

		return reviewListDTO;
	}

	//トップ画面のレビューリストを呼び出すためのメソッド
	public ArrayList<ReviewDTO> getReviewList_ForTop() throws SQLException {

		ArrayList<ReviewDTO> reviewDTO = new ArrayList<ReviewDTO>();

		//トップ画面用のレビュー情報リストを呼び出すSQL文
		//		String sql = "SELECT * FROM review_info ORDER BY regist_date DESC LIMIT 5";
		String sql = "SELECT ri.book_id, bi.title, bi.author, ri.review_id, ri.regiuser_id, ri.highlight, ri.text, ri.recommendation, ri.ar_color, ri.tag, ri.regist_date, ri.update_date "
				+ "FROM review_info ri LEFT JOIN book_info bi "
				+ "ON ri.book_id = bi.book_id "
				+ "ORDER BY ri.regist_date DESC LIMIT 5";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				ReviewDTO dto = new ReviewDTO();
				dto.setBookId(resultSet.getInt("book_id"));
				dto.setTitle(resultSet.getString("title"));
				dto.setAuthor(resultSet.getString("author"));
				dto.setReviewId(resultSet.getInt("review_id"));
				dto.setRegiUserId(resultSet.getString("regiuser_id"));
				dto.setHighlight(resultSet.getString("highlight"));
				dto.setText(resultSet.getString("text"));
				dto.setRecommendation(resultSet.getInt("recommendation"));
				dto.setArColor(resultSet.getString("ar_color"));
				dto.setTag(resultSet.getString("tag"));
				dto.setRegistDate(resultSet.getString("regist_date"));
				dto.setUpdateDate(resultSet.getString("update_date"));
				reviewDTO.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

		return reviewDTO;
	}

	//レビューの詳細情報を呼び出すためのメソッド
	public ArrayList<ReviewDTO> getReviewDetail(int reviewId) throws SQLException {

		ArrayList<ReviewDTO> reviewDTO = new ArrayList<ReviewDTO>();

		//詳細画面用のレビュー情報リストを呼び出すSQL文
		String sql = "SELECT ri.book_id, bi.title, bi.author, ri.review_id, ri.regiuser_id, ri.highlight, ri.text, ri.recommendation, ri.ar_color, ri.tag, ri.regist_date, ri.update_date "
				+ "FROM review_info ri LEFT JOIN book_info bi "
				+ "ON ri.book_id = bi.book_id "
				+ "WHERE review_id = ? "
				+ "ORDER BY ri.regist_date DESC LIMIT 5";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, reviewId);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				ReviewDTO dto = new ReviewDTO();
				dto.setBookId(resultSet.getInt("book_id"));
				dto.setTitle(resultSet.getString("title"));
				dto.setAuthor(resultSet.getString("author"));
				dto.setReviewId(resultSet.getInt("review_id"));
				dto.setRegiUserId(resultSet.getString("regiuser_id"));
				dto.setHighlight(resultSet.getString("highlight"));
				dto.setText(resultSet.getString("text"));
				dto.setRecommendation(resultSet.getInt("recommendation"));
				dto.setArColor(resultSet.getString("ar_color"));
				dto.setTag(resultSet.getString("tag"));
				dto.setRegistDate(resultSet.getString("regist_date"));
				dto.setUpdateDate(resultSet.getString("update_date"));
				reviewDTO.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

		return reviewDTO;
	}

}