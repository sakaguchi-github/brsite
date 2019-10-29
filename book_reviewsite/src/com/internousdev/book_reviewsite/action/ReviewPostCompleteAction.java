package com.internousdev.book_reviewsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.book_reviewsite.dao.ReviewPostDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ReviewPostCompleteAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;
	private ReviewPostDAO reviewPostDAO = new ReviewPostDAO();

	public String execute() throws SQLException {

		String result;
		int intBookId = Integer.parseInt(session.get("rp_bookId").toString());
		int intRecommendation = Integer.parseInt(session.get("rp_recommendation").toString());

		int res = reviewPostDAO.reviewPost(session.get("userId").toString(), intBookId,
				session.get("rp_highlight").toString(),
				intRecommendation, session.get("rp_tag").toString(), session.get("rp_text").toString());

		if (res > 0) {
			result = SUCCESS;
			session.remove("bookDetail");
			session.remove("rp_highlight");
			session.remove("rp_recommendation");
			session.remove("rp_tag");
			session.remove("rp_text");
		} else {
			result = ERROR;
			session.put("insertErrorFlg", false);
		}

		return result;
	}

	//SessionAware実装によるオーバーライド義務
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
