package com.internousdev.book_reviewsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.book_reviewsite.dao.UserCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateCompleteAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;
	private UserCreateCompleteDAO userCreateCompleteDAO = new UserCreateCompleteDAO();

	public String execute()throws SQLException{

		userCreateCompleteDAO.createUser(session.get("userId").toString(),session.get("password").toString(),session.get("nickName").toString());
		String result = SUCCESS;

		return result;
	}

	//SessionAware実装によるオーバーライド義務
	//sessionフィールドにセッション情報を格納するため
	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}