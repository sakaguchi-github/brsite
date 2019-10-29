package com.internousdev.book_reviewsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.book_reviewsite.dao.BookInfoDAO;
import com.internousdev.book_reviewsite.dto.BookDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BookListAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;
	private BookInfoDAO bookInfoDAO = new BookInfoDAO();
	private List<BookDTO> bookListAll = new ArrayList<BookDTO>();

	public String execute() throws SQLException {

		bookListAll = bookInfoDAO.getBookListInfo();
		session.put("bookListAll", bookListAll);

		String result = SUCCESS;
		return result;
	}

	public List<BookDTO> getBookListAll() {
		return bookListAll;
	}

	public void setBookListAll(List<BookDTO> bookListAll) {
		this.bookListAll = bookListAll;
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