package com.internousdev.book_reviewsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.book_reviewsite.dao.UserCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateCompleteAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;
	private UserCreateCompleteDAO userCreateCompleteDAO = new UserCreateCompleteDAO();

	//確定されたユーザー情報をDBに登録するメソッド
	//戻り値：画面遷移のための変数result
	public String execute() throws SQLException {

		String result;
		int res = userCreateCompleteDAO.createUser(session.get("userId").toString(), session.get("password").toString(),
				session.get("nickName").toString());

		//登録成否判定、失敗した場合システムエラー画面に遷移
		if (res > 0) {
			result = SUCCESS;
		} else {
			result = "systemError";
		}

		return result;
	}

	//SessionAware実装によるオーバーライド義務
	//sessionフィールドにセッション情報を格納するため
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}