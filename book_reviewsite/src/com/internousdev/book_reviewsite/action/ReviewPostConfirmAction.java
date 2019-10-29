package com.internousdev.book_reviewsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ReviewPostConfirmAction extends ActionSupport implements SessionAware {

	private int bookId;
	private String highlight;
	private int recommendation;
	private String ar_Color;
	private String tag;
	private String text;
	private String errorMessage;
	public Map<String, Object> session;

	public String execute() {
		String result = SUCCESS;

		if (bookId > 0) {
			if (!(text.equals("") || highlight.equals(""))) {
				session.put("rp_bookId", bookId);
				session.put("rp_highlight", highlight);
				session.put("rp_recommendation", recommendation);
				session.put("rp_tag", tag);
				session.put("rp_text", text);
			} else {
				//レビュー本文が空欄の場合にはエラーメッセージをフィールド変数に代入
				setErrorMessage("レビュータイトルまたは本文が未入力です");
				result = ERROR;
			}
		} else {
			//bookIdが取得できていない場合にはエラーメッセージをフィールド変数に代入
			setErrorMessage("本の情報が正しく取得できませんでした、お手数ですが本の選択からやり直してください");
			result = ERROR;
		}
		return result;
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

	public int getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(int recommendation) {
		this.recommendation = recommendation;
	}

	public String getAr_Color() {
		return ar_Color;
	}

	public void setAr_Color(String ar_Color) {
		this.ar_Color = ar_Color;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
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
