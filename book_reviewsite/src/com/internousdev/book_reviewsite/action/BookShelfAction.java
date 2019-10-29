package com.internousdev.book_reviewsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.book_reviewsite.dao.BookInfoDAO;
import com.internousdev.book_reviewsite.dto.BookDTO;
import com.internousdev.book_reviewsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BookShelfAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;
	private BookInfoDAO bookInfoDAO = new BookInfoDAO();
	private List<BookDTO> bookShelfList = new ArrayList<BookDTO>();
	private String message;

	public String execute() throws SQLException {

		//ログイン判定・書籍登録判定
		if (((LoginDTO) session.get("loginUser")).isLoginFlg()) {

			bookShelfList = bookInfoDAO.getBookShelfInfo((session.get("userId")).toString());
			session.put("bookShelfList", bookShelfList);

			if (bookShelfList.isEmpty()) {
				setMessage("まだ本が登録されていません");
			}

		} else {

			setMessage("ログインしてください");

		}

		String result = SUCCESS;
		return result;
	}

	public List<BookDTO> getBookShelfList() {
		return bookShelfList;
	}

	public void setBookShelfList(List<BookDTO> bookShelfList) {
		this.bookShelfList = bookShelfList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	//SessionAware実装によるオーバーライド義務
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
