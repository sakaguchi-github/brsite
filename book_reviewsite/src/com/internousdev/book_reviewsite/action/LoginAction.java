package com.internousdev.book_reviewsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.book_reviewsite.dao.LoginDAO;
import com.internousdev.book_reviewsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {

	private String userId;
	private String password;
	public Map<String, Object> session;
	private LoginDAO loginDAO = new LoginDAO();
	private LoginDTO loginDTO = new LoginDTO();
	private String errorMessage = "";

	//DBからユーザー情報を呼び出しセッションに格納するメソッド、存在しない場合にはエラーメッセージを準備する
	//戻り値：画面遷移するための変数result
	public String execute() {
		String result = ERROR;
		loginDTO = loginDAO.getLoginUserInfo(userId, password);
		session.put("loginUser", loginDTO);

		if (Integer.parseInt((session.get("id")).toString()) > 0) {
			session.put("id", loginDTO.getId());
			session.put("userId", loginDTO.getUserId());
			session.put("nickName", loginDTO.getNickName());
			session.put("status", loginDTO.getStatus());
			session.put("registDate", loginDTO.getRegistDate());
			session.put("updateDate", loginDTO.getUpdateDate());
			session.put("loginFlg", true);
			result = SUCCESS;
		} else {
			setErrorMessage("ログインできませんでした、再度入力をお試しください");
		}
		return result;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getErrorMessgae() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	// SessionAware実装によるオーバーライド義務
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
