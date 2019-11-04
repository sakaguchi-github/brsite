package com.internousdev.book_reviewsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.book_reviewsite.dto.BookDTO;
import com.internousdev.book_reviewsite.util.DBConnector;

public class BookInfoDAO {

	private int bookId;
	private int id;
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	//指定のIDの本単体の情報を呼び出すメソッド
	//戻り値：本の詳細情報を保持したリスト型のDTOインスタンス
	public ArrayList<BookDTO> getBookInfo(int bookId) throws SQLException {

		ArrayList<BookDTO> bookInfoDTO = new ArrayList<BookDTO>();

		String sql = "SELECT bi.book_id, bi.title, bi.author, bi.co_author, bi.publisher, bt.type_name, bg.genre_name, ii.image_file_path, ii.image_file_name, bi.regist_date, bi.update_date, ui.nickname "
				+ "FROM book_info bi "
				+ "LEFT JOIN user_info ui ON bi.regiuser_id = ui.id "
				+ "LEFT JOIN b_type bt ON bi.book_type = bt.type_name "
				+ "LEFT JOIN b_genre bg ON bi.book_genre = bg.genre_name "
				+ "LEFT JOIN image_info ii ON bi.book_type = ii.book_type "
				+ "WHERE book_id = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, bookId);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				BookDTO dto = new BookDTO();
				dto.setBookId(resultSet.getInt("book_id"));
				dto.setTitle(resultSet.getString("title"));
				dto.setAuthor(resultSet.getString("author"));
				dto.setCo_Author(resultSet.getString("co_author"));
				dto.setPublisher(resultSet.getString("publisher"));
				dto.setTypeName(resultSet.getString("type_name"));
				dto.setGenreName(resultSet.getString("genre_name"));
				dto.setImageFilePath(resultSet.getString("image_file_path"));
				dto.setImageFileName(resultSet.getString("image_file_name"));
				dto.setRegistDate(resultSet.getString("regist_date"));
				dto.setUpdateDate(resultSet.getString("update_date"));
				dto.setNickName(resultSet.getString("nickname"));
				bookInfoDTO.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

		return bookInfoDTO;
	}

	//本の登録からそのままレビュー投稿画面へ移行した時に、登録した本の情報を呼び出すためのメソッド
	//戻り値：本の詳細情報を保持したリスト型のDTOインスタンス
	public ArrayList<BookDTO> getRecentRegistBookInfo(int id) throws SQLException {

		ArrayList<BookDTO> bookInfoDTO = new ArrayList<BookDTO>();

		//該当ユーザーの登録日時が一番新しい本の詳細情報のみを呼び出すSQL文
		String sql = "SELECT bi.book_id, bi.title, bi.author, bi.co_author, bi.publisher, bt.type_name, bg.genre_name, ii.image_file_path, ii.image_file_name, bi.regist_date, bi.update_date, ui.nickname "
				+ "FROM book_info bi "
				+ "LEFT JOIN user_info ui ON bi.regiuser_id = ui.id "
				+ "LEFT JOIN b_type bt ON bi.book_type = bt.type_name "
				+ "LEFT JOIN b_genre bg ON bi.book_genre = bg.genre_name "
				+ "LEFT JOIN image_info ii ON bi.book_type = ii.book_type "
				+ "WHERE regiuser_id = ? ORDER BY regist_date DESC LIMIT 1";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				BookDTO dto = new BookDTO();
				dto.setBookId(resultSet.getInt("book_id"));
				dto.setTitle(resultSet.getString("title"));
				dto.setAuthor(resultSet.getString("author"));
				dto.setCo_Author(resultSet.getString("co_author"));
				dto.setPublisher(resultSet.getString("publisher"));
				dto.setTypeName(resultSet.getString("type_name"));
				dto.setGenreName(resultSet.getString("genre_name"));
				dto.setImageFilePath(resultSet.getString("image_file_path"));
				dto.setImageFileName(resultSet.getString("image_file_name"));
				dto.setRegistDate(resultSet.getString("regist_date"));
				dto.setUpdateDate(resultSet.getString("update_date"));
				dto.setNickName(resultSet.getString("nickname"));
				bookInfoDTO.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

		return bookInfoDTO;
	}

	//該当のユーザーが登録した全ての本の情報を呼び出すためのメソッド
	//戻り値：本の詳細情報を保持したリスト型のDTOインスタンス
	public ArrayList<BookDTO> getBookShelfInfo(int id) throws SQLException {

		ArrayList<BookDTO> bookShelfInfoDTO = new ArrayList<BookDTO>();

		String sql = "SELECT bi.book_id, bi.title, bi.author, bi.co_author, bi.publisher, bt.type_name, bg.genre_name, ii.image_file_path, ii.image_file_name, bi.regist_date, bi.update_date, ui.nickname "
				+ "FROM book_info bi "
				+ "LEFT JOIN user_info ui ON bi.regiuser_id = ui.id "
				+ "LEFT JOIN b_type bt ON bi.book_type = bt.type_name "
				+ "LEFT JOIN b_genre bg ON bi.book_genre = bg.genre_name "
				+ "LEFT JOIN image_info ii ON bi.book_type = ii.book_type "
				+ "WHERE regiuser_id = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				BookDTO dto = new BookDTO();
				dto.setBookId(resultSet.getInt("book_id"));
				dto.setTitle(resultSet.getString("title"));
				dto.setAuthor(resultSet.getString("author"));
				dto.setCo_Author(resultSet.getString("co_author"));
				dto.setPublisher(resultSet.getString("publisher"));
				dto.setTypeName(resultSet.getString("type_name"));
				dto.setGenreName(resultSet.getString("genre_name"));
				dto.setImageFilePath(resultSet.getString("image_file_path"));
				dto.setImageFileName(resultSet.getString("image_file_name"));
				dto.setRegistDate(resultSet.getString("regist_date"));
				dto.setUpdateDate(resultSet.getString("update_date"));
				dto.setNickName(resultSet.getString("nickname"));
				bookShelfInfoDTO.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

		return bookShelfInfoDTO;
	}

	//全ての本の情報を一括で呼び出すためのメソッド
	//戻り値：本の詳細情報を保持したリスト型のDTOインスタンス
	public ArrayList<BookDTO> getBookListInfo() throws SQLException {

		ArrayList<BookDTO> bookListInfoDTO = new ArrayList<BookDTO>();

		//一度に全ての本の詳細情報を呼び出すのは難しいため、降順に30件まで呼び出すSQL文
		String sql = "SELECT bi.book_id, bi.regiuser_id,bi.title, bi.author, bi.co_author, bi.publisher, bt.type_name, bg.genre_name, ii.image_file_path, ii.image_file_name, bi.regist_date, bi.update_date, ui.nickname "
				+ "FROM book_info bi "
				+ "LEFT JOIN user_info ui ON bi.regiuser_id = ui.id "
				+ "LEFT JOIN b_type bt ON bi.book_type = bt.type_name "
				+ "LEFT JOIN b_genre bg ON bi.book_genre = bg.genre_name "
				+ "LEFT JOIN image_info ii ON bi.book_type = ii.book_type "
				+ "ORDER BY regist_date DESC LIMIT 30";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				BookDTO dto = new BookDTO();
				dto.setBookId(resultSet.getInt("book_id"));
				dto.setRegiUserId(resultSet.getInt("regiuser_id"));
				dto.setTitle(resultSet.getString("title"));
				dto.setAuthor(resultSet.getString("author"));
				dto.setCo_Author(resultSet.getString("co_author"));
				dto.setPublisher(resultSet.getString("publisher"));
				dto.setTypeName(resultSet.getString("type_name"));
				dto.setGenreName(resultSet.getString("genre_name"));
				dto.setImageFilePath(resultSet.getString("image_file_path"));
				dto.setImageFileName(resultSet.getString("image_file_name"));
				dto.setRegistDate(resultSet.getString("regist_date"));
				dto.setUpdateDate(resultSet.getString("update_date"));
				dto.setNickName(resultSet.getString("nickname"));
				bookListInfoDTO.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

		return bookListInfoDTO;
	}

	//本検索用のメソッド、書籍種別選択がない場合
	//戻り値：本の詳細情報を保持したリスト型のDTOインスタンス
	public List<BookDTO> getBookListWithKeyword(String[] keywordsList) {

		List<BookDTO> bookListDTO = new ArrayList<BookDTO>();
		String sql = "SELECT bi.book_id, bi.title, bi.author, bi.co_author, bi.publisher, bt.type_name, bg.genre_name, ii.image_file_path, ii.image_file_name, bi.regist_date, bi.update_date, ui.nickname "
				+ "FROM book_info bi "
				+ "LEFT JOIN user_info ui ON bi.regiuser_id = ui.id "
				+ "LEFT JOIN b_type bt ON bi.book_type = bt.type_name "
				+ "LEFT JOIN b_genre bg ON bi.book_genre = bg.genre_name "
				+ "LEFT JOIN image_info ii ON bi.book_type = ii.book_type";
		boolean bFlg = true;

		if (!keywordsList[0].equals("")) {
			for (String keyword : keywordsList) {
				if (bFlg) {
					sql += " WHERE (bi.title LIKE '%" + keyword + "%')";
					sql += " OR (bi.author LIKE '%" + keyword + "%')";
					sql += " OR (bi.co_author LIKE '%" + keyword + "%')";
					sql += " OR (bi.publisher LIKE '%" + keyword + "%')";
					bFlg = false;
				} else {
					sql += " OR (bi.title LIKE '%" + keyword + "%')";
					sql += " OR (bi.author LIKE '%" + keyword + "%')";
					sql += " OR (bi.co_author LIKE '%" + keyword + "%')";
					sql += " OR (bi.publisher LIKE '%" + keyword + "%')";
				}
			}
		}
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				BookDTO dto = new BookDTO();
				dto.setBookId(resultSet.getInt("book_id"));
				dto.setTitle(resultSet.getString("title"));
				dto.setAuthor(resultSet.getString("author"));
				dto.setCo_Author(resultSet.getString("co_author"));
				dto.setPublisher(resultSet.getString("publisher"));
				dto.setTypeName(resultSet.getString("type_name"));
				dto.setGenreName(resultSet.getString("genre_name"));
				dto.setImageFilePath(resultSet.getString("image_file_path"));
				dto.setImageFileName(resultSet.getString("image_file_name"));
				dto.setRegistDate(resultSet.getString("regist_date"));
				dto.setUpdateDate(resultSet.getString("update_date"));
				dto.setNickName(resultSet.getString("nickname"));
				bookListDTO.add(dto);
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
		return bookListDTO;
	}

	//本検索用のメソッド、書籍種別選択をした場合
	//戻り値：本の詳細情報を保持したリスト型のDTOインスタンス
	public List<BookDTO> getBookListWithTypeAndKeyword(String typeName, String[] keywordsList) {

		List<BookDTO> bookListDTO = new ArrayList<BookDTO>();
		String sql = "SELECT bi.book_id, bi.title, bi.author, bi.co_author, bi.publisher, bt.type_name, bg.genre_name, ii.image_file_path, ii.image_file_name, bi.regist_date, bi.update_date, ui.nickname "
				+ "FROM book_info bi "
				+ "LEFT JOIN user_info ui ON bi.regiuser_id = ui.id "
				+ "LEFT JOIN b_type bt ON bi.book_type = bt.type_name "
				+ "LEFT JOIN b_genre bg ON bi.book_genre = bg.genre_name "
				+ "LEFT JOIN image_info ii ON bi.book_type = ii.book_type "
				+ "WHERE bi.book_type = '" + typeName + "'";
		boolean bFlg = true;

		if (!keywordsList[0].equals("")) {
			for (String keyword : keywordsList) {
				if (bFlg) {
					sql += " AND ((bi.title LIKE '%" + keyword + "%')";
					sql += " OR (bi.author LIKE '%" + keyword + "%')";
					sql += " OR (bi.co_author LIKE '%" + keyword + "%')";
					sql += " OR (bi.publisher LIKE '%" + keyword + "%')";
					bFlg = false;
				} else {
					sql += " OR (bi.title LIKE '%" + keyword + "%')";
					sql += " OR (bi.author LIKE '%" + keyword + "%')";
					sql += " OR (bi.co_author LIKE '%" + keyword + "%')";
					sql += " OR (bi.publisher LIKE '%" + keyword + "%')";
				}
			}
			sql += ")";
		}

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				BookDTO dto = new BookDTO();
				dto.setBookId(resultSet.getInt("book_id"));
				dto.setTitle(resultSet.getString("title"));
				dto.setAuthor(resultSet.getString("author"));
				dto.setCo_Author(resultSet.getString("co_author"));
				dto.setPublisher(resultSet.getString("publisher"));
				dto.setTypeName(resultSet.getString("type_name"));
				dto.setGenreName(resultSet.getString("genre_name"));
				dto.setImageFilePath(resultSet.getString("image_file_path"));
				dto.setImageFileName(resultSet.getString("image_file_name"));
				dto.setRegistDate(resultSet.getString("regist_date"));
				dto.setUpdateDate(resultSet.getString("update_date"));
				dto.setNickName(resultSet.getString("nickname"));
				bookListDTO.add(dto);
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
		return bookListDTO;
	}

	//本検索用のメソッド、ジャンル選択をした場合
	//戻り値：本の詳細情報を保持したリスト型のDTOインスタンス
	public List<BookDTO> getBookListWithGenreAndKeyword(String genreName, String[] keywordsList) {

		List<BookDTO> bookListDTO = new ArrayList<BookDTO>();
		String sql = "SELECT bi.book_id, bi.title, bi.author, bi.co_author, bi.publisher, bt.type_name, bg.genre_name, ii.image_file_path, ii.image_file_name, bi.regist_date, bi.update_date, ui.nickname "
				+ "FROM book_info bi "
				+ "LEFT JOIN user_info ui ON bi.regiuser_id = ui.id "
				+ "LEFT JOIN b_type bt ON bi.book_type = bt.type_name "
				+ "LEFT JOIN b_genre bg ON bi.book_genre = bg.genre_name "
				+ "LEFT JOIN image_info ii ON bi.book_type = ii.book_type "
				+ "WHERE bi.book_genre = '" + genreName + "'";
		boolean bFlg = true;

		if (!keywordsList[0].equals("")) {
			for (String keyword : keywordsList) {
				if (bFlg) {
					sql += " AND ((bi.title LIKE '%" + keyword + "%')";
					sql += " OR (bi.author LIKE '%" + keyword + "%')";
					sql += " OR (bi.co_author LIKE '%" + keyword + "%')";
					sql += " OR (bi.publisher LIKE '%" + keyword + "%')";
					bFlg = false;
				} else {
					sql += " OR (bi.title LIKE '%" + keyword + "%')";
					sql += " OR (bi.author LIKE '%" + keyword + "%')";
					sql += " OR (bi.co_author LIKE '%" + keyword + "%')";
					sql += " OR (bi.publisher LIKE '%" + keyword + "%')";
				}
			}
			sql += ")";
		}

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				BookDTO dto = new BookDTO();
				dto.setBookId(resultSet.getInt("book_id"));
				dto.setTitle(resultSet.getString("title"));
				dto.setAuthor(resultSet.getString("author"));
				dto.setCo_Author(resultSet.getString("co_author"));
				dto.setPublisher(resultSet.getString("publisher"));
				dto.setTypeName(resultSet.getString("type_name"));
				dto.setGenreName(resultSet.getString("genre_name"));
				dto.setImageFilePath(resultSet.getString("image_file_path"));
				dto.setImageFileName(resultSet.getString("image_file_name"));
				dto.setRegistDate(resultSet.getString("regist_date"));
				dto.setUpdateDate(resultSet.getString("update_date"));
				dto.setNickName(resultSet.getString("nickname"));
				bookListDTO.add(dto);
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
		return bookListDTO;
	}

	//本検索用のメソッド、書籍種別選択とジャンル選択を両方した場合
	//戻り値：本の詳細情報を保持したリスト型のDTOインスタンス
	public List<BookDTO> getBookListWithTypeAndGenreAndKeyword(String typeName, String genreName, String[] keywordsList) {

		List<BookDTO> bookListDTO = new ArrayList<BookDTO>();
		String sql = "SELECT bi.book_id, bi.title, bi.author, bi.co_author, bi.publisher, bt.type_name, bg.genre_name, ii.image_file_path, ii.image_file_name, bi.regist_date, bi.update_date, ui.nickname "
				+ "FROM book_info bi "
				+ "LEFT JOIN user_info ui ON bi.regiuser_id = ui.id "
				+ "LEFT JOIN b_type bt ON bi.book_type = bt.type_name "
				+ "LEFT JOIN b_genre bg ON bi.book_genre = bg.genre_name "
				+ "LEFT JOIN image_info ii ON bi.book_type = ii.book_type "
				+ "WHERE bi.book_type = '" + typeName + "'"
				+ " AND bi.book_genre = '" + genreName + "'";
		boolean bFlg = true;

		if (!keywordsList[0].equals("")) {
			for (String keyword : keywordsList) {
				if (bFlg) {
					sql += " AND ((bi.title LIKE '%" + keyword + "%')";
					sql += " OR (bi.author LIKE '%" + keyword + "%')";
					sql += " OR (bi.co_author LIKE '%" + keyword + "%')";
					sql += " OR (bi.publisher LIKE '%" + keyword + "%')";
					bFlg = false;
				} else {
					sql += " OR (bi.title LIKE '%" + keyword + "%')";
					sql += " OR (bi.author LIKE '%" + keyword + "%')";
					sql += " OR (bi.co_author LIKE '%" + keyword + "%')";
					sql += " OR (bi.publisher LIKE '%" + keyword + "%')";
				}
			}
			sql += ")";
		}

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				BookDTO dto = new BookDTO();
				dto.setBookId(resultSet.getInt("book_id"));
				dto.setTitle(resultSet.getString("title"));
				dto.setAuthor(resultSet.getString("author"));
				dto.setCo_Author(resultSet.getString("co_author"));
				dto.setPublisher(resultSet.getString("publisher"));
				dto.setTypeName(resultSet.getString("type_name"));
				dto.setGenreName(resultSet.getString("genre_name"));
				dto.setImageFilePath(resultSet.getString("image_file_path"));
				dto.setImageFileName(resultSet.getString("image_file_name"));
				dto.setRegistDate(resultSet.getString("regist_date"));
				dto.setUpdateDate(resultSet.getString("update_date"));
				dto.setNickName(resultSet.getString("nickname"));
				bookListDTO.add(dto);
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
		return bookListDTO;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

}