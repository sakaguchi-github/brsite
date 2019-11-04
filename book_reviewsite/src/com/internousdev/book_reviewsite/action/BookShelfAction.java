package com.internousdev.book_reviewsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.book_reviewsite.dao.BookInfoDAO;
import com.internousdev.book_reviewsite.dto.BookDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BookShelfAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;
	private BookInfoDAO bookInfoDAO = new BookInfoDAO();
	private List<BookDTO> bookShelfList = new ArrayList<BookDTO>();
	private String message;

	public String execute() throws SQLException {

		String result = SUCCESS;

		//ログイン出来ていれば該当ユーザーの登録した本の一覧が表示されるメソッド
		//戻り値：画面遷移するための変数result
		if (Integer.parseInt((session.get("id")).toString()) > 0) {

			bookShelfList = bookInfoDAO.getBookShelfInfo(Integer.parseInt((session.get("id")).toString()));
			session.put("bookShelfList", bookShelfList);

			//本が未登録の場合にメッセージを準備
			if (bookShelfList.isEmpty()) {
				setMessage("まだ本が登録されていません");
			}

		} else {
			//ログイン情報を確認出来なかった場合にはエラー画面へ
			result = "systemError";
		}

		return result;
	}

	public List<BookDTO> getBookShelfList() {
		return bookShelfList;
	}

	public void setBookShelfList(List<BookDTO> bookShelfList) {
		this.bookShelfList = bookShelfList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	//SessionAware実装によるオーバーライド義務
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
