package com.internousdev.book_reviewsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.book_reviewsite.dto.ReviewDTO;
import com.internousdev.book_reviewsite.util.DBConnector;

public class ReviewListDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	//レビュー検索画面用のレビュー一覧を表示するためのメソッド
	//戻り値：レビューの情報を格納したリスト型のDTOインスタンス
	public ArrayList<ReviewDTO> getReviewAll() throws SQLException {

		ArrayList<ReviewDTO> reviewListDTO = new ArrayList<ReviewDTO>();

		//レビュー情報リストを呼び出すSQL文、まとめて全表示は出来ないため降順で30件まで
		//合わせて該当書籍の基本情報も表示するために一緒に格納
		String sql = "SELECT ri.book_id, bi.title, bi.author, bt.type_name, ii.image_file_path, ii.image_file_name, ri.review_id, ri.regiuser_id, ui.nickname, ri.highlight, ri.text, ri.recommendation, ri.spoiler_flg, ri.regist_date, ri.update_date "
				+ "FROM review_info ri "
				+ "LEFT JOIN book_info bi ON ri.book_id = bi.book_id "
				+ "LEFT JOIN user_info ui ON ri.regiuser_id = ui.id "
				+ "LEFT JOIN b_type bt ON bi.book_type = bt.type_name "
				+ "LEFT JOIN image_info ii ON bi.book_type = ii.book_type "
				+ "ORDER BY ri.regist_date DESC LIMIT 30";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				ReviewDTO dto = new ReviewDTO();
				dto.setBookId(resultSet.getInt("book_id"));
				dto.setTitle(resultSet.getString("title"));
				dto.setAuthor(resultSet.getString("author"));
				dto.setTypeName(resultSet.getString("type_name"));
				dto.setImageFilePath(resultSet.getString("image_file_path"));
				dto.setImageFileName(resultSet.getString("image_file_name"));
				dto.setReviewId(resultSet.getInt("review_id"));
				dto.setRegiUserId(resultSet.getInt("regiuser_id"));
				dto.setNickName(resultSet.getString("nickname"));
				dto.setHighlight(resultSet.getString("highlight"));
				dto.setText(resultSet.getString("text"));
				dto.setRecommendation(resultSet.getInt("recommendation"));
				dto.setsFlg(resultSet.getBoolean("spoiler_flg"));
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

	//トップ画面のレビューリストを呼び出すためのメソッド、まとめて全表示は出来ないため降順で30件まで
	//戻り値：レビューの情報を格納したリスト型のDTOインスタンス
	public ArrayList<ReviewDTO> getReviewList_ForTop() throws SQLException {

		ArrayList<ReviewDTO> reviewDTO = new ArrayList<ReviewDTO>();

		//トップ画面用のレビュー情報リストを呼び出すSQL文
		String sql = "SELECT ri.book_id, bi.title, bi.author, bt.type_name, ii.image_file_path, ii.image_file_name, ri.review_id, ri.regiuser_id, ui.nickname, ri.highlight, ri.text, ri.recommendation, ri.spoiler_flg, ri.regist_date, ri.update_date "
				+ "FROM review_info ri "
				+ "LEFT JOIN book_info bi ON ri.book_id = bi.book_id "
				+ "LEFT JOIN user_info ui ON ri.regiuser_id = ui.id "
				+ "LEFT JOIN b_type bt ON bi.book_type = bt.type_name "
				+ "LEFT JOIN image_info ii ON bi.book_type = ii.book_type "
				+ "ORDER BY ri.regist_date DESC LIMIT 30";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				ReviewDTO dto = new ReviewDTO();
				dto.setBookId(resultSet.getInt("book_id"));
				dto.setTitle(resultSet.getString("title"));
				dto.setAuthor(resultSet.getString("author"));
				dto.setTypeName(resultSet.getString("type_name"));
				dto.setImageFilePath(resultSet.getString("image_file_path"));
				dto.setImageFileName(resultSet.getString("image_file_name"));
				dto.setReviewId(resultSet.getInt("review_id"));
				dto.setRegiUserId(resultSet.getInt("regiuser_id"));
				dto.setNickName(resultSet.getString("nickname"));
				dto.setHighlight(resultSet.getString("highlight"));
				dto.setText(resultSet.getString("text"));
				dto.setRecommendation(resultSet.getInt("recommendation"));
				dto.setsFlg(resultSet.getBoolean("spoiler_flg"));
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
	//戻り値：レビューの情報を格納したリスト型のDTOインスタンス
	public ArrayList<ReviewDTO> getReviewDetail(int reviewId) throws SQLException {

		ArrayList<ReviewDTO> reviewDTO = new ArrayList<ReviewDTO>();

		//詳細画面用のレビュー情報詳細を呼び出すSQL文
		String sql = "SELECT ri.book_id, bi.title, bi.author, bt.type_name, ii.image_file_path, ii.image_file_name, ri.review_id, ri.regiuser_id, ui.nickname, ri.highlight, ri.text, ri.recommendation, ri.spoiler_flg, ri.regist_date, ri.update_date "
				+ "FROM review_info ri "
				+ "LEFT JOIN book_info bi ON ri.book_id = bi.book_id "
				+ "LEFT JOIN user_info ui ON ri.regiuser_id = ui.id "
				+ "LEFT JOIN b_type bt ON bi.book_type = bt.type_name "
				+ "LEFT JOIN image_info ii ON bi.book_type = ii.book_type "
				+ "WHERE review_id = ? "
				+ "ORDER BY ri.regist_date DESC LIMIT 100";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, reviewId);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				ReviewDTO dto = new ReviewDTO();
				dto.setBookId(resultSet.getInt("book_id"));
				dto.setTitle(resultSet.getString("title"));
				dto.setAuthor(resultSet.getString("author"));
				dto.setTypeName(resultSet.getString("type_name"));
				dto.setImageFilePath(resultSet.getString("image_file_path"));
				dto.setImageFileName(resultSet.getString("image_file_name"));
				dto.setReviewId(resultSet.getInt("review_id"));
				dto.setRegiUserId(resultSet.getInt("regiuser_id"));
				dto.setNickName(resultSet.getString("nickname"));
				dto.setHighlight(resultSet.getString("highlight"));
				dto.setText(resultSet.getString("text"));
				dto.setRecommendation(resultSet.getInt("recommendation"));
				dto.setsFlg(resultSet.getBoolean("spoiler_flg"));
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

	//特定の本のレビュー詳細情報を呼び出すためのメソッド
	//戻り値：レビューの情報を格納したリスト型のDTOインスタンス
	public ArrayList<ReviewDTO> getBookReviewList(int bookId) throws SQLException {

		ArrayList<ReviewDTO> bookReviewDTO = new ArrayList<ReviewDTO>();

		//詳細画面用のレビュー情報詳細を呼び出すSQL文
		String sql = "SELECT ri.book_id, ri.review_id, ri.regiuser_id, ui.nickname, ri.highlight, ri.text, ri.recommendation, ri.spoiler_flg, ri.regist_date "
				+ "FROM review_info ri "
				+ "LEFT JOIN user_info ui ON ri.regiuser_id = ui.id "
				+ "WHERE book_id = ? ";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, bookId);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				ReviewDTO dto = new ReviewDTO();
				dto.setBookId(resultSet.getInt("book_id"));
				dto.setReviewId(resultSet.getInt("review_id"));
				dto.setRegiUserId(resultSet.getInt("regiuser_id"));
				dto.setNickName(resultSet.getString("nickname"));
				dto.setHighlight(resultSet.getString("highlight"));
				dto.setText(resultSet.getString("text"));
				dto.setRecommendation(resultSet.getInt("recommendation"));
				dto.setsFlg(resultSet.getBoolean("spoiler_flg"));
				dto.setRegistDate(resultSet.getString("regist_date"));
				bookReviewDTO.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

		return bookReviewDTO;
	}

	//レビューの投稿からそのまま詳細画面へ移行した時に、投稿したレビュー情報を呼び出すためのメソッド
	//戻り値：レビューの詳細情報を保持したリスト型のDTOインスタンス
	public ArrayList<ReviewDTO> getRecentPostReviewInfo(int id) throws SQLException {

		ArrayList<ReviewDTO> recentReviewDTO = new ArrayList<ReviewDTO>();

		//投稿が一番新しいレビュー情報のみを呼び出すSQL文
		String sql = "SELECT ri.book_id, bi.title, bi.author, bt.type_name, ii.image_file_path, ii.image_file_name, ri.review_id, ri.regiuser_id, ui.nickname, ri.highlight, ri.text, ri.recommendation, ri.spoiler_flg, ri.regist_date, ri.update_date "
				+ "FROM review_info ri "
				+ "LEFT JOIN book_info bi ON ri.book_id = bi.book_id "
				+ "LEFT JOIN user_info ui ON ri.regiuser_id = ui.id "
				+ "LEFT JOIN b_type bt ON bi.book_type = bt.type_name "
				+ "LEFT JOIN image_info ii ON bi.book_type = ii.book_type "
				+ "WHERE ri.regiuser_id = ? "
				+ "ORDER BY ri.regist_date DESC LIMIT 1";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				ReviewDTO dto = new ReviewDTO();
				dto.setBookId(resultSet.getInt("book_id"));
				dto.setTitle(resultSet.getString("title"));
				dto.setAuthor(resultSet.getString("author"));
				dto.setTypeName(resultSet.getString("type_name"));
				dto.setImageFilePath(resultSet.getString("image_file_path"));
				dto.setImageFileName(resultSet.getString("image_file_name"));
				dto.setReviewId(resultSet.getInt("review_id"));
				dto.setRegiUserId(resultSet.getInt("regiuser_id"));
				dto.setNickName(resultSet.getString("nickname"));
				dto.setHighlight(resultSet.getString("highlight"));
				dto.setText(resultSet.getString("text"));
				dto.setRecommendation(resultSet.getInt("recommendation"));
				dto.setsFlg(resultSet.getBoolean("spoiler_flg"));
				dto.setRegistDate(resultSet.getString("regist_date"));
				dto.setUpdateDate(resultSet.getString("update_date"));
				recentReviewDTO.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

		return recentReviewDTO;
	}

	//マイページに表示する、特定のユーザーのレビュー投稿履歴情報を呼び出すためのメソッド
	//戻り値：レビューの詳細情報を保持したリスト型のDTOインスタンス
	public ArrayList<ReviewDTO> getUserReviewList(int id) throws SQLException {

		ArrayList<ReviewDTO> ReviewListDTO = new ArrayList<ReviewDTO>();

		//該当するユーザー管理IDに合致するレビュー情報のみを呼び出すSQL文
		String sql = "SELECT ri.book_id, bi.title, bi.author, bt.type_name, ii.image_file_path, ii.image_file_name, ri.review_id, ri.regiuser_id, ui.nickname, ri.highlight, ri.text, ri.recommendation, ri.spoiler_flg, ri.regist_date, ri.update_date "
				+ "FROM review_info ri "
				+ "LEFT JOIN book_info bi ON ri.book_id = bi.book_id "
				+ "LEFT JOIN user_info ui ON ri.regiuser_id = ui.id "
				+ "LEFT JOIN b_type bt ON bi.book_type = bt.type_name "
				+ "LEFT JOIN image_info ii ON bi.book_type = ii.book_type "
				+ "WHERE ri.regiuser_id = ? "
				+ "ORDER BY ri.regist_date DESC LIMIT 100";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				ReviewDTO dto = new ReviewDTO();
				dto.setBookId(resultSet.getInt("book_id"));
				dto.setTitle(resultSet.getString("title"));
				dto.setAuthor(resultSet.getString("author"));
				dto.setTypeName(resultSet.getString("type_name"));
				dto.setImageFilePath(resultSet.getString("image_file_path"));
				dto.setImageFileName(resultSet.getString("image_file_name"));
				dto.setReviewId(resultSet.getInt("review_id"));
				dto.setRegiUserId(resultSet.getInt("regiuser_id"));
				dto.setNickName(resultSet.getString("nickname"));
				dto.setHighlight(resultSet.getString("highlight"));
				dto.setText(resultSet.getString("text"));
				dto.setRecommendation(resultSet.getInt("recommendation"));
				dto.setsFlg(resultSet.getBoolean("spoiler_flg"));
				dto.setRegistDate(resultSet.getString("regist_date"));
				dto.setUpdateDate(resultSet.getString("update_date"));
				ReviewListDTO.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

		return ReviewListDTO;
	}

	//レビュー検索用のメソッド、オススメ度選択がない場合
	//戻り値：本の詳細情報を保持したリスト型のDTOインスタンス
	public List<ReviewDTO> getReviewListWithKeyword(String[] keywordsList) {

		List<ReviewDTO> reviewListDTO = new ArrayList<ReviewDTO>();
		String sql = "SELECT ri.book_id, ri.review_id, ri.regiuser_id, ui.nickname, ri.highlight, ri.text, ri.recommendation, ri.spoiler_flg, ri.regist_date, ri.update_date "
				+ "FROM review_info ri "
				+ "LEFT JOIN user_info ui ON ri.regiuser_id = ui.id ";
		boolean bFlg = true;

		if (!keywordsList[0].equals("")) {
			for (String keyword : keywordsList) {
				if (bFlg) {
					sql += " WHERE (ri.highlight LIKE '%" + keyword + "%')";
					sql += " OR (ri.text LIKE '%" + keyword + "%')";
					bFlg = false;
				} else {
					sql += " OR (ri.highlight LIKE '%" + keyword + "%')";
					sql += " OR (ri.text LIKE '%" + keyword + "%')";
				}
			}
		}
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ReviewDTO dto = new ReviewDTO();
				dto.setBookId(resultSet.getInt("book_id"));
				dto.setReviewId(resultSet.getInt("review_id"));
				dto.setRegiUserId(resultSet.getInt("regiuser_id"));
				dto.setNickName(resultSet.getString("nickname"));
				dto.setHighlight(resultSet.getString("highlight"));
				dto.setText(resultSet.getString("text"));
				dto.setRecommendation(resultSet.getInt("recommendation"));
				dto.setsFlg(resultSet.getBoolean("spoiler_flg"));
				dto.setRegistDate(resultSet.getString("regist_date"));
				dto.setUpdateDate(resultSet.getString("update_date"));
				reviewListDTO.add(dto);
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
		return reviewListDTO;
	}

	//レビュー検索用のメソッド、オススメ度選択をした場合
	//戻り値：本の詳細情報を保持したリスト型のDTOインスタンス
	public List<ReviewDTO> getReviewListWithRecommendationAndKeyword(String recommendation, String[] keywordsList) {

		List<ReviewDTO> reviewListDTO = new ArrayList<ReviewDTO>();
		int intReco = Integer.parseInt(recommendation);
		String sql = "SELECT ri.book_id, ri.review_id, ri.regiuser_id, ui.nickname, ri.highlight, ri.text, ri.recommendation, ri.spoiler_flg, ri.regist_date, ri.update_date "
				+ "FROM review_info ri "
				+ "LEFT JOIN user_info ui ON ri.regiuser_id = ui.id "
				+ "WHERE ri.recommendation = " + intReco;
		boolean bFlg = true;

		if (!keywordsList[0].equals("")) {
			for (String keyword : keywordsList) {
				if (bFlg) {
					sql += " AND ((ri.highlight LIKE '%" + keyword + "%')";
					sql += " OR (ri.text LIKE '%" + keyword + "%')";
					bFlg = false;
				} else {
					sql += " OR (ri.highlight LIKE '%" + keyword + "%')";
					sql += " OR (ri.text LIKE '%" + keyword + "%')";
				}
			}
			sql += ")";
		}

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ReviewDTO dto = new ReviewDTO();
				dto.setBookId(resultSet.getInt("book_id"));
				dto.setReviewId(resultSet.getInt("review_id"));
				dto.setRegiUserId(resultSet.getInt("regiuser_id"));
				dto.setNickName(resultSet.getString("nickname"));
				dto.setHighlight(resultSet.getString("highlight"));
				dto.setText(resultSet.getString("text"));
				dto.setRecommendation(resultSet.getInt("recommendation"));
				dto.setsFlg(resultSet.getBoolean("spoiler_flg"));
				dto.setRegistDate(resultSet.getString("regist_date"));
				dto.setUpdateDate(resultSet.getString("update_date"));
				reviewListDTO.add(dto);
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
		return reviewListDTO;
	}

}