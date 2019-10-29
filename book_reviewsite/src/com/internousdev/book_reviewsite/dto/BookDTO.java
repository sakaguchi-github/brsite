package com.internousdev.book_reviewsite.dto;

public class BookDTO {

	private int bookId;
	private int regiUserId;
	private String title;
	private String author;
	private String co_Author;
	private String publisher;
	private int bookType;
	private int bookGenre1;
	private int bookGenre2;
	private int bookGenre3;
	private String registDate;
	private String updateDate;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getRegiUserId() {
		return regiUserId;
	}

	public void setRegiUserId(int regiUserId) {
		this.regiUserId = regiUserId;
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

	public int getBookType() {
		return bookType;
	}

	public void setBookType(int bookType) {
		this.bookType = bookType;
	}

	public int getBookGenre1() {
		return bookGenre1;
	}

	public void setBookGenre1(int bookGenre1) {
		this.bookGenre1 = bookGenre1;
	}

	public int getBookGenre2() {
		return bookGenre2;
	}

	public void setBookGenre2(int bookGenre2) {
		this.bookGenre2 = bookGenre2;
	}

	public int getBookGenre3() {
		return bookGenre3;
	}

	public void setBookGenre3(int bookGenre3) {
		this.bookGenre3 = bookGenre3;
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