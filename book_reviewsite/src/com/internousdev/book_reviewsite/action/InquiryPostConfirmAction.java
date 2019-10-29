package com.internousdev.book_reviewsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.book_reviewsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class InquiryPostConfirmAction extends ActionSupport implements SessionAware {

	private String iType;
	private String iTitle;
	private String iText;
	private String errorMessage;
	public Map<String, Object> session;

	public String execute(){
		String result = SUCCESS;

		if (((LoginDTO) session.get("loginUser")).isLoginFlg()) {

			if (!(iType.equals("") || iTitle.equals("") || iText.equals(""))) {
				session.put("iType", iType);
				session.put("iTitle", iTitle);
				session.put("iText", iText);
			} else {
				//レビュー本文が空欄の場合にはエラーメッセージをフィールド変数に代入
				setErrorMessage("未入力項目があります");
				result = ERROR;
			}
		}

		return result;
	}

	public String getiType() {
		return iType;
	}

	public void setiType(String iType) {
		this.iType = iType;
	}

	public String getiTitle() {
		return iTitle;
	}

	public void setiTitle(String iTitle) {
		this.iTitle = iTitle;
	}

	public String getiText() {
		return iText;
	}

	public void setiText(String iText) {
		this.iText = iText;
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
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
