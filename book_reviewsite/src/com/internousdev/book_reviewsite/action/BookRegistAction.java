package com.internousdev.book_reviewsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BookRegistAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;

	//画面遷移のためにSUCCESSを返す
	public String execute() throws SQLException {

		return SUCCESS;
	}

	//SessionAware実装によるオーバーライド義務
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
