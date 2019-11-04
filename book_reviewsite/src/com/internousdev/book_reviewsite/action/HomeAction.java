package com.internousdev.book_reviewsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.book_reviewsite.dao.RankingDAO;
import com.internousdev.book_reviewsite.dao.ReviewListDAO;
import com.internousdev.book_reviewsite.dto.ReviewDTO;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;
	private ReviewListDAO reviewListDAO = new ReviewListDAO();
	private ArrayList<ReviewDTO> reviewList = new ArrayList<ReviewDTO>();
	private RankingDAO rankingDAO = new RankingDAO();
	private ArrayList<ReviewDTO> rankingList = new ArrayList<ReviewDTO>();

	public String execute() throws SQLException {

		//TOP画面で表示するレビュー情報＆ランキング情報の準備
		reviewList = reviewListDAO.getReviewList_ForTop();
		session.put("reviewList_ForTop", reviewList);

		rankingList = rankingDAO.getBookRankingTop5();
		session.put("rankingList", rankingList);

		//レビュー投稿から詳細画面へ移る時に使うフラグの準備
		session.put("continueCheckFlg", "off");

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

	public Map<String, Object> getSession() {
		return session;
	}

	//SessionAware実装によるオーバーライド義務
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
