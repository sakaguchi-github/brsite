package com.internousdev.book_reviewsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BookRegistConfirmAction extends ActionSupport implements SessionAware {

	private String title;
	private String author;
	private String co_Author;
	private String publisher;
	private String bookType;
	private String bookGenre;
	private String errorMessage;
	public Map<String, Object> session;

	//書籍登録時、入力内容をセッションに格納するメソッド
	//戻り値：画面遷移のための変数result
	public String execute() {

		String result = SUCCESS;

		if (!(title.equals("")) && !(author.equals(""))) {
			session.put("title", title);
			session.put("author", author);
			session.put("co_Author", co_Author);
			session.put("publisher", publisher);
			session.put("bookType", bookType);
			session.put("bookGenre", bookGenre);
		} else {
			//空欄がある場合にはエラーメッセージを準備し、元の画面に戻る
			setErrorMessage("【タイトルと著者名は必須項目です】");
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

	public String getBookType() {
		return bookType;
	}

	public void setBookType(String bookType) {
		this.bookType = bookType;
	}

	public String getBookGenre() {
		return bookGenre;
	}

	public void setBookGenre(String bookGenre) {
		this.bookGenre = bookGenre;
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
