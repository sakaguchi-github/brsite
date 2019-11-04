package com.internousdev.book_reviewsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.book_reviewsite.dao.BookInfoDAO;
import com.internousdev.book_reviewsite.dao.ReviewListDAO;
import com.internousdev.book_reviewsite.dto.BookDTO;
import com.internousdev.book_reviewsite.dto.ReviewDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BookDetailAction extends ActionSupport implements SessionAware {

	private int bookId;
	public Map<String, Object> session;
	private BookInfoDAO bookInfoDAO = new BookInfoDAO();
	private List<BookDTO> bookDetail = new ArrayList<BookDTO>();
	private ReviewListDAO reviewListDAO = new ReviewListDAO();
	private List<ReviewDTO> bookReviewList = new ArrayList<ReviewDTO>();

	public String execute() throws SQLException {

		bookDetail = bookInfoDAO.getBookInfo(bookId);
		session.put("bookDetail", bookDetail);
		bookReviewList = reviewListDAO.getBookReviewList(bookId);
		session.put("bookReviewList", bookReviewList);
		session.put("continuePostFlg", "off");

		String result = SUCCESS;
		return result;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
