package com.internousdev.book_reviewsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class Menu_ReviewPostAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;

	public String execute(){
		session.put("errorMessage", "");
		return SUCCESS;
	}

	// SessionAware実装によるオーバーライド義務
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
