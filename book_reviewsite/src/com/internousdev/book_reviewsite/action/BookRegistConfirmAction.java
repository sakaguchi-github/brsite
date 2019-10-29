package com.internousdev.book_reviewsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BookRegistConfirmAction extends ActionSupport implements SessionAware {

	private String title;
	private String author;
	private String co_Author;
	private String publisher;
	private int genreId;
	private String errorMessage;
	public Map<String, Object> session;

	public String execute() {
		String result = SUCCESS;

		if (!(title.equals("")) && !(author.equals("")) && genreId != 0) {
			session.put("title", title);
			session.put("author", author);
			session.put("co_Author", co_Author);
			session.put("publisher", publisher);
			session.put("genreId", genreId);
		} else {
			//空欄がある場合にはエラーメッセージをフィールド変数に代入
			setErrorMessage("未入力項目があります。");
			result = ERROR;
		}
		return result;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCo_Author() {
		return co_Author;
	}

	public void setCo_Author(String co_Author) {
		this.co_Author = co_Author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getGenreId() {
		return genreId;
	}

	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	//SessionAware実装によるオーバーライド義務
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
