package com.internousdev.book_reviewsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.book_reviewsite.dao.InquiryPostDAO;
import com.opensymphony.xwork2.ActionSupport;

public class InquiryPostCompleteAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;
	private InquiryPostDAO inquiryPostDAO = new InquiryPostDAO();

	public String execute() throws SQLException {

		String result;

		int res = inquiryPostDAO.inquiryPost(session.get("userId").toString(), session.get("iType").toString(),
				session.get("iTitle").toString(), session.get("iText").toString());

		if (res > 0) {
			result = SUCCESS;
			session.remove("iType");
			session.remove("iTitle");
			session.remove("iText");
		} else {
			//投稿に失敗した場合にはエラーメッセージを表示
			session.put("insertErrorFlg", true);
			result = ERROR;
		}

		return result;
	}

	//SessionAware実装によるオーバーライド義務
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
