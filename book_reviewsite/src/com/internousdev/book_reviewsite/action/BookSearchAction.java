package com.internousdev.book_reviewsite.action;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.book_reviewsite.dao.BookInfoDAO;
import com.internousdev.book_reviewsite.dto.BookDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BookSearchAction extends ActionSupport implements SessionAware {
	private String bookType;
	private String bookGenre;
	private String keywords;
	private List<BookDTO> bookInfoDTOList;
	private Map<String, Object> session;

	public String execute() {

		BookInfoDAO bookInfoDAO = new BookInfoDAO();

		// 処理用の変数に値を入れる
		if (StringUtils.isBlank(keywords)) {
			//キーワードが null,""," ","　"の時に空文字に設定する
			keywords = "";
		} else {
			// キーワードの"　"を" "に変換して" "2個以上を" "に変換
			keywords = keywords.replaceAll("　", " ").replaceAll("\\s{2,}", " ").trim();
		}

		// カテゴリーの選択肢が存在しない場合は、すべてのカテゴリーを設定する
		if (bookType.equals("なし")) {

			if (bookGenre.equals("なし")) {

				bookInfoDTOList = bookInfoDAO.getBookListWithKeyword(keywords.split(" "));
				session.put("bookInfoDTOList", bookInfoDTOList);

			}else {

				bookInfoDTOList = bookInfoDAO.getBookListWithGenreAndKeyword(bookGenre, keywords.split(" "));
				session.put("bookInfoDTOList", bookInfoDTOList);

			}

		} else {

			if (bookGenre.equals("なし")) {

				bookInfoDTOList = bookInfoDAO.getBookListWithTypeAndKeyword(bookType, keywords.split(" "));
				session.put("bookInfoDTOList", bookInfoDTOList);

			}else {

				bookInfoDTOList = bookInfoDAO.getBookListWithTypeAndGenreAndKeyword(bookType, bookGenre, keywords.split(" "));
				session.put("bookInfoDTOList", bookInfoDTOList);

			}

		}

		return SUCCESS;
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

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public List<BookDTO> getBookInfoDTOList() {
		return bookInfoDTOList;
	}

	public void setBookInfoDTOList(List<BookDTO> bookInfoDTOList) {
		this.bookInfoDTOList = bookInfoDTOList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
