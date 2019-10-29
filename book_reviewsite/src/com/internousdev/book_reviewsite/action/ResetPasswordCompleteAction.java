package com.internousdev.book_reviewsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.book_reviewsite.dao.ResetPasswordDAO;
import com.internousdev.book_reviewsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordCompleteAction extends ActionSupport implements SessionAware {

	private String password;
	private String passCheck1;
	private String passCheck2;
	public Map<String, Object> session;
	private ResetPasswordDAO resetPasswordDAO = new ResetPasswordDAO();
	private String errorMessage = "";

	public String execute() throws SQLException {

		String result = ERROR;
		int res = 0;

		if (passCheck1.equals(passCheck2)) {

			String newPassword = passCheck1;
			int id = ((LoginDTO) session.get("loginUser")).getId();
			res = resetPasswordDAO.resetPassword(newPassword, id, password);

			if (res <= 0) {
				setErrorMessage("予期せぬエラーが発生しました。再度お試しください。");
			} else {
				result = SUCCESS;
			}

		} else {
			setErrorMessage("新しいパスワードと再入力された物が一致しませんでした。");
		}

		return result;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassCheck1() {
		return passCheck1;
	}

	public void setPassCheck1(String passCheck1) {
		this.passCheck1 = passCheck1;
	}

	public String getPassCheck2() {
		return passCheck2;
	}

	public void setPassCheck2(String passCheck2) {
		this.passCheck2 = passCheck2;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	//SessionAware実装によるオーバーライド義務
	//sessionフィールドにセッション情報を格納するため
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}