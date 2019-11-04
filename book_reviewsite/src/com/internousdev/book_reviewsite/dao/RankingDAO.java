package com.internousdev.book_reviewsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.book_reviewsite.dto.ReviewDTO;
import com.internousdev.book_reviewsite.util.DBConnector;

public class RankingDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	//レビュー検索画面用のレビュー一覧を表示するためのメソッド
	//戻り値：レビューの情報を格納したリスト型のDTOインスタンス
	public ArrayList<ReviewDTO> getBookRankingTop5() throws SQLException {

		ArrayList<ReviewDTO> rankingDTO = new ArrayList<ReviewDTO>();

		//レビュー数TOP5の書籍ランキング表示用のデータを準備する
		//レビュー情報テーブルでbook_id数でソートし、上位5つの書籍情報を呼び出すSQL文、TOP5まで表示するため5件まで
		String sql = "SELECT ri.book_id, bi.title, bi.author, bt.type_name, ii.image_file_path, ii.image_file_name,count(*) AS count "
				+ "FROM review_info ri "
				+ "LEFT JOIN book_info bi ON ri.book_id = bi.book_id "
				+ "LEFT JOIN b_type bt ON bi.book_type = bt.type_id "
				+ "LEFT JOIN image_info ii ON bi.book_type = ii.book_type "
				+ "GROUP BY ri.book_id, bi.title, bi.author, bt.type_name, ii.image_file_path, ii.image_file_name "
				+ "ORDER BY count DESC LIMIT 5";

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
				rankingDTO.add(dto);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

		return rankingDTO;
	}

}