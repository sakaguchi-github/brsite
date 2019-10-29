package com.internousdev.book_reviewsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.book_reviewsite.dto.BookDTO;
import com.internousdev.book_reviewsite.util.DBConnector;

public class BookInfoDAO {

	private int bookId;
	private String userId;
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	//本の情報を単体で呼び出すためのメソッド
	public ArrayList<BookDTO> getBookInfo(int bookId) throws SQLException {

		ArrayList<BookDTO> bookInfoDTO = new ArrayList<BookDTO>();

		//本の詳細情報を呼び出すSQL文
		String sql = "SELECT * FROM book_info WHERE book_id = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, bookId);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				BookDTO dto = new BookDTO();
				dto.setBookId(resultSet.getInt("book_id"));
				dto.setRegiUserId(resultSet.getString("regiuser_id"));
				dto.setTitle(resultSet.getString("title"));
				dto.setAuthor(resultSet.getString("author"));
				dto.setCo_Author(resultSet.getString("co_author"));
				dto.setPublisher(resultSet.getString("publisher"));
				dto.setGenreId(resultSet.getInt("genre_id"));
				dto.setRegistDate(resultSet.getString("regist_date"));
				dto.setUpdateDate(resultSet.getString("update_date"));
				bookInfoDTO.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

		return bookInfoDTO;
	}

	//本の登録からそのままレビュー画面へ移行した時に、登録した本の情報を呼び出すためのメソッド
	public ArrayList<BookDTO> getRecentRegistBookInfo(String userId) throws SQLException {

		ArrayList<BookDTO> bookInfoDTO = new ArrayList<BookDTO>();

		//登録日時が一番新しい本の詳細情報を呼び出すSQL文
		String sql = "SELECT * FROM book_info WHERE regiuser_id = ? ORDER BY regist_date DESC LIMIT 1";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				BookDTO dto = new BookDTO();
				dto.setBookId(resultSet.getInt("book_id"));
				dto.setRegiUserId(resultSet.getString("regiuser_id"));
				dto.setTitle(resultSet.getString("title"));
				dto.setAuthor(resultSet.getString("author"));
				dto.setCo_Author(resultSet.getString("co_author"));
				dto.setPublisher(resultSet.getString("publisher"));
				dto.setGenreId(resultSet.getInt("genre_id"));
				dto.setRegistDate(resultSet.getString("regist_date"));
				dto.setUpdateDate(resultSet.getString("update_date"));
				bookInfoDTO.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

		return bookInfoDTO;
	}

	//本棚用に登録した全ての本の情報を呼び出すためのメソッド
	public ArrayList<BookDTO> getBookShelfInfo(String userId) throws SQLException {

		ArrayList<BookDTO> bookShelfInfoDTO = new ArrayList<BookDTO>();

		//本の詳細情報を呼び出すSQL文
		String sql = "SELECT * FROM book_info WHERE regiuser_id = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				BookDTO dto = new BookDTO();
				dto.setBookId(resultSet.getInt("book_id"));
				dto.setRegiUserId(resultSet.getString("regiuser_id"));
				dto.setTitle(resultSet.getString("title"));
				dto.setAuthor(resultSet.getString("author"));
				dto.setCo_Author(resultSet.getString("co_author"));
				dto.setPublisher(resultSet.getString("publisher"));
				dto.setGenreId(resultSet.getInt("genre_id"));
				dto.setRegistDate(resultSet.getString("regist_date"));
				dto.setUpdateDate(resultSet.getString("update_date"));
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
	public ArrayList<BookDTO> getBookListInfo() throws SQLException {

		ArrayList<BookDTO> bookListInfoDTO = new ArrayList<BookDTO>();

		//本の詳細情報を呼び出すSQL文
		String sql = "SELECT * FROM book_info ORDER BY regist_date DESC LIMIT 30";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				BookDTO dto = new BookDTO();
				dto.setBookId(resultSet.getInt("book_id"));
				dto.setRegiUserId(resultSet.getString("regiuser_id"));
				dto.setTitle(resultSet.getString("title"));
				dto.setAuthor(resultSet.getString("author"));
				dto.setCo_Author(resultSet.getString("co_author"));
				dto.setPublisher(resultSet.getString("publisher"));
				dto.setGenreId(resultSet.getInt("genre_id"));
				dto.setRegistDate(resultSet.getString("regist_date"));
				dto.setUpdateDate(resultSet.getString("update_date"));
				bookListInfoDTO.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

		return bookListInfoDTO;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

}