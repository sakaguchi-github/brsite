package com.internousdev.book_reviewsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.book_reviewsite.dao.ReviewListDAO;
import com.internousdev.book_reviewsite.dto.ReviewDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ReviewDetailAction extends ActionSupport implements SessionAware {

	private int reviewId;
	public Map<String, Object> session;
	private ReviewListDAO reviewListDAO = new ReviewListDAO();
	private ArrayList<ReviewDTO> reviewDetail = new ArrayList<ReviewDTO>();

	public String execute() throws SQLException {

		reviewDetail = reviewListDAO.getReviewDetail(reviewId);
		session.put("reviewDetail", reviewDetail);

		String result = SUCCESS;
		return result;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
