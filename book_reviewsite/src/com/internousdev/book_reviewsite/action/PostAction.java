package com.internousdev.book_reviewsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.book_reviewsite.dao.BookInfoDAO;
import com.internousdev.book_reviewsite.dto.BookDTO;
import com.opensymphony.xwork2.ActionSupport;

public class PostAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;
	private BookInfoDAO bookInfoDAO = new BookInfoDAO();
	private List<BookDTO> bookDetail = new ArrayList<BookDTO>();

	//画面遷移のためにSUCCESSを返すだけ
	public String execute() throws SQLException{

		String result = SUCCESS;

		if(session.get("continuePostFlg").toString().equals("on")) {

			bookDetail = bookInfoDAO.getRecentRegistBookInfo(session.get("userId").toString());
			session.put("bookDetail", bookDetail);

		}

		return result;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
