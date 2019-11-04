package com.internousdev.book_reviewsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.book_reviewsite.dao.BookInfoDAO;
import com.internousdev.book_reviewsite.dao.ReviewListDAO;
import com.internousdev.book_reviewsite.dao.UserInfoDAO;
import com.internousdev.book_reviewsite.dto.BookDTO;
import com.internousdev.book_reviewsite.dto.LoginDTO;
import com.internousdev.book_reviewsite.dto.ReviewDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;
	private UserInfoDAO userInfoDAO = new UserInfoDAO();
	private List<LoginDTO> userListAll = new ArrayList<LoginDTO>();
	private BookInfoDAO bookInfoDAO = new BookInfoDAO();
	private List<BookDTO> bookListAll = new ArrayList<BookDTO>();
	private ReviewListDAO reviewListDAO = new ReviewListDAO();
	private List<ReviewDTO> reviewListAll = new ArrayList<ReviewDTO>();

	//管理者用ページで表示する各種リスト情報を取得するメソッド
	public String execute() throws SQLException {

		userListAll = userInfoDAO.getUserListAll();
		session.put("userListAll", userListAll);

		bookListAll = bookInfoDAO.getBookListInfo();
		session.put("bookListAll", bookListAll);

		reviewListAll = reviewListDAO.getReviewAll();
		session.put("reviewListAll", reviewListAll);

		String result = SUCCESS;
		return result;
	}

	public List<LoginDTO> getUserListAll() {
		return userListAll;
	}

	public void setUserListAll(List<LoginDTO> userListAll) {
		this.userListAll = userListAll;
	}

	public List<BookDTO> getBookListAll() {
		return bookListAll;
	}

	public void setBookListAll(List<BookDTO> bookListAll) {
		this.bookListAll = bookListAll;
	}

	public List<ReviewDTO> getReviewListAll() {
		return reviewListAll;
	}

	public void setReviewListAll(List<ReviewDTO> reviewListAll) {
		this.reviewListAll = reviewListAll;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	//SessionAware実装によるオーバーライド義務
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}