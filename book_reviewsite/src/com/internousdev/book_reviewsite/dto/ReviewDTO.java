package com.internousdev.book_reviewsite.dto;

public class ReviewDTO {

	private int reviewId;
	private int regiUserId;
	private int bookId;
	private String highlight;
	private String text;
	private int recommendation;
	private boolean sFlg;
	private String registDate;
	private String updateDate;

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public int getRegiUserId() {
		return regiUserId;
	}

	public void setRegiUserId(int regiUserId) {
		this.regiUserId = regiUserId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getHighlight() {
		return highlight;
	}

	public void setHighlight(String highlight) {
		this.highlight = highlight;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(int recommendation) {
		this.recommendation = recommendation;
	}

	public boolean issFlg() {
		return sFlg;
	}

	public void setsFlg(boolean sFlg) {
		this.sFlg = sFlg;
	}

	public String getRegistDate() {
		return registDate;
	}

	public void setRegistDate(String registDate) {
		this.registDate = registDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

}