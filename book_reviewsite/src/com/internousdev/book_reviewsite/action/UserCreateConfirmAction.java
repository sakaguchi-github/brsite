package com.internousdev.book_reviewsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.book_reviewsite.dao.UserInfoDAO;
//import com.internousdev.ecsite2.dao.UserIdCheckDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateConfirmAction extends ActionSupport implements SessionAware {

	private String userId;
	private String password;
	private String nickName;
	private String errorMessage;
	public Map<String, Object> session;
	private UserInfoDAO userInfoDAO = new UserInfoDAO();

	//入力されたユーザー情報をセッションに格納するメソッド
	//空欄がある、またはユーザーIDが重複していた場合にエラーメッセージを準備する
	//戻り値：画面遷移のための変数result
	public String execute() throws SQLException {

		String result = SUCCESS;

		if (!(userId.equals("")) && !(password.equals("")) && !(nickName.equals(""))) {
			session.put("userId", userId);
			session.put("password", password);
			session.put("nickName", nickName);

			//ユーザーID重複判定
			boolean rs = userInfoDAO.checkUserId(userId);
			if (rs) {
				//何もしない
			} else {
				setErrorMessage("【ご入力いただいたユーザーIDはすでに使用されております。】");
				result = ERROR;
			}

		} else {
			setErrorMessage("【未入力項目があります。】");
			result = ERROR;
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

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	//SessionAware実装によるオーバーライド義務
	//sessionフィールドにセッション情報を格納するため
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}