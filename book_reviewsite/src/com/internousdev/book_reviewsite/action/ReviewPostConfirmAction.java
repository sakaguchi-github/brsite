package com.internousdev.book_reviewsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ReviewPostConfirmAction extends ActionSupport implements SessionAware {

	private int bookId;
	private String highlight;
	private String text;
	private int recommendation;
	private boolean sFlg;
	private String errorMessage;
	public Map<String, Object> session;

	//確認画面に表示するために、入力内容をセッションに格納するメソッド
	public String execute() {
		String result = SUCCESS;

		//紐付ける書籍のIDが存在するか確認し、本文が空欄でなければセッションに格納
		if (bookId > 0) {
			if (!(text.equals(""))) {
				session.put("bookId", bookId);
				session.put("highlight", highlight);
				session.put("text", text);
				session.put("recommendation", recommendation);
				session.put("sFlg", sFlg);

			} else {
				//本文が空欄の場合にはエラーメッセージを準備
				setErrorMessage("【レビュータイトルとレビュー本文は必須項目です】");
				result = ERROR;
			}
		} else {
			//bookIdが取得できていない場合にはエラー画面へ遷移
			result = "systemError";
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
