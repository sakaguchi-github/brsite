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

public class MyPageAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;
	private BookInfoDAO bookInfoDAO = new BookInfoDAO();
	private List<BookDTO> bookShelfList = new ArrayList<BookDTO>();
	private ReviewListDAO reviewListDAO = new ReviewListDAO();
	private List<ReviewDTO> userReviewList = new ArrayList<ReviewDTO>();

	//マイページに画面遷移、かつ入る前に本棚の情報を取得しておくメソッド
	public String execute() throws SQLException {

		bookShelfList = bookInfoDAO.getBookShelfInfo(Integer.parseInt((session.get("id")).toString()));
		session.put("bookShelfList", bookShelfList);

		userReviewList = reviewListDAO.getUserReviewList(Integer.parseInt((session.get("id")).toString()));
		session.put("userReviewList", userReviewList);

		return SUCCESS;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
