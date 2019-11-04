package com.internousdev.book_reviewsite.action;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.book_reviewsite.dao.ReviewListDAO;
import com.internousdev.book_reviewsite.dto.ReviewDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ReviewSearchAction extends ActionSupport implements SessionAware {
	private String recommendation;
	private String keywords;
	private List<ReviewDTO> reviewDTOList;
	private Map<String, Object> session;

	public String execute() {

		ReviewListDAO reviewListDAO = new ReviewListDAO();

		// 処理用の変数に値を入れる
		if (StringUtils.isBlank(keywords)) {
			//キーワードが null,""," ","　"の時に空文字に設定する
			keywords = "";
		} else {
			// キーワードの"　"を" "に変換して" "2個以上を" "に変換
			keywords = keywords.replaceAll("　", " ").replaceAll("\\s{2,}", " ").trim();
		}

		// カテゴリーの選択肢が存在しない場合は、すべてのカテゴリーを設定する
		if (recommendation.equals("なし")) {

			reviewDTOList = reviewListDAO.getReviewListWithKeyword(keywords.split(" "));
			session.put("reviewDTOList", reviewDTOList);

		} else {

			reviewDTOList = reviewListDAO.getReviewListWithRecommendationAndKeyword(recommendation, keywords.split(" "));
			session.put("reviewDTOList", reviewDTOList);

		}

		return SUCCESS;
	}

	public String getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public List<ReviewDTO> getReviewDTOList() {
		return reviewDTOList;
	}

	public void setReviewDTOList(List<ReviewDTO> reviewDTOList) {
		this.reviewDTOList = reviewDTOList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
