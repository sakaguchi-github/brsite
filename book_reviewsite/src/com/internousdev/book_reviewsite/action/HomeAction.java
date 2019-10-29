package com.internousdev.book_reviewsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.book_reviewsite.dao.ImageDAO;
import com.internousdev.book_reviewsite.dao.ReviewListDAO;
import com.internousdev.book_reviewsite.dto.ImageDTO;
import com.internousdev.book_reviewsite.dto.ReviewDTO;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;
	private ReviewListDAO reviewListDAO = new ReviewListDAO();
	private ArrayList<ReviewDTO> reviewList = new ArrayList<ReviewDTO>();
	private List<ImageDTO> imageDTO = new ArrayList<ImageDTO>();

	public String execute() throws SQLException {

		reviewList = reviewListDAO.getReviewList_ForTop();
		session.put("reviewList_ForTop", reviewList);

		ImageDAO imageDAO = new ImageDAO();
		imageDTO = imageDAO.getImage();
		session.put("imageDTO", imageDTO);

		String result = SUCCESS;
		return result;
	}

	public ArrayList<ReviewDTO> getReviewList() {
		return reviewList;
	}

	public void setReviewList(ArrayList<ReviewDTO> reviewList) {
		this.reviewList = reviewList;
	}

	public ReviewListDAO getReviewListDAO() {
		return reviewListDAO;
	}

	public void setReviewListDAO(ReviewListDAO reviewListDAO) {
		this.reviewListDAO = reviewListDAO;
	}

	public List<ImageDTO> getImageDTO() {
		return imageDTO;
	}

	public void setImageDTO(List<ImageDTO> imageDTO) {
		this.imageDTO = imageDTO;
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
