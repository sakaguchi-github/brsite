package com.internousdev.book_reviewsite.dto;

public class InquiryDTO {

	private int inquiryId;
	private String regiUserId;
	private String iType;
	private String iTitle;
	private String iText;
	private String registDate;
	private String replyDate;
	private boolean fFlg;

	public int getInquiryId() {
		return inquiryId;
	}

	public void setInquiryId(int inquiryId) {
		this.inquiryId = inquiryId;
	}

	public String getRegiUserId() {
		return regiUserId;
	}

	public void setRegiUserId(String regiUserId) {
		this.regiUserId = regiUserId;
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

	public String getRegistDate() {
		return registDate;
	}

	public void setRegistDate(String registDate) {
		this.registDate = registDate;
	}

	public String getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
	}

	public boolean isfFlg() {
		return fFlg;
	}

	public void setfFlg(boolean fFlg) {
		this.fFlg = fFlg;
	}

}
