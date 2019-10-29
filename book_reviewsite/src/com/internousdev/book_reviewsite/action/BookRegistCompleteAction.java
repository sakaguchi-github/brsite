package com.internousdev.book_reviewsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.book_reviewsite.dao.BookRegistDAO;
import com.opensymphony.xwork2.ActionSupport;

public class BookRegistCompleteAction extends ActionSupport implements SessionAware {

	private String title;
	private String author;
	private String co_Author;
	private String publisher;
	public Map<String, Object> session;
	private BookRegistDAO bookRegistDAO = new BookRegistDAO();

	public String execute() throws SQLException {

		String result;
		int intGenreId = Integer.parseInt(session.get("genreId").toString());
		int res = bookRegistDAO.bookRegist(session.get("userId").toString(),
				session.get("title").toString(),
				session.get("author").toString(),
				session.get("co_Author").toString(),
				session.get("publisher").toString(),
				intGenreId);

		if (res > 0) {
			result = SUCCESS;
			session.put("continuePostFlg", "on");
		} else {
			result = ERROR;
			session.put("insertErrorFlg", false);
		}

		return result;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCo_Author() {
		return co_Author;
	}

	public void setCo_Author(String co_Author) {
		this.co_Author = co_Author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	//SessionAware実装によるオーバーライド義務
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
