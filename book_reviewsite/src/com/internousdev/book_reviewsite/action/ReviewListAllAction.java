package com.internousdev.book_reviewsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.book_reviewsite.dao.ReviewListDAO;
import com.internousdev.book_reviewsite.dto.ReviewDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ReviewListAllAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;
	private ReviewListDAO reviewListDAO = new ReviewListDAO();
	private ArrayList<ReviewDTO> reviewListAll = new ArrayList<ReviewDTO>();

	public String execute() throws SQLException {

		reviewListAll = reviewListDAO.getReviewAll();
		session.put("reviewListAll", reviewListAll);

		String result = SUCCESS;
		return result;
	}

	public ArrayList<ReviewDTO> getReviewListAll() {
		return reviewListAll;
	}

	public void setReviewListAll(ArrayList<ReviewDTO> reviewListAll) {
		this.reviewListAll = reviewListAll;
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
