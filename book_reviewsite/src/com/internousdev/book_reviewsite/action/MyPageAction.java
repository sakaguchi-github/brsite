package com.internousdev.book_reviewsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.book_reviewsite.dao.BookInfoDAO;
import com.internousdev.book_reviewsite.dto.BookDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;
	private BookInfoDAO bookInfoDAO = new BookInfoDAO();
	private List<BookDTO> bookShelfList = new ArrayList<BookDTO>();

	public String execute() throws SQLException {

		//マイページに入る前に本棚の情報を取得
		bookShelfList = bookInfoDAO.getBookShelfInfo((session.get("userId")).toString());
		session.put("bookShelfList", bookShelfList);

		session.remove("insertErrorFlg");
		return SUCCESS;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
