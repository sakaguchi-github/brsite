package com.internousdev.book_reviewsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.book_reviewsite.dao.BookInfoDAO;
import com.internousdev.book_reviewsite.dto.BookDTO;
import com.opensymphony.xwork2.ActionSupport;

public class PostAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;
	private BookInfoDAO bookInfoDAO = new BookInfoDAO();
	private List<BookDTO> bookDetail = new ArrayList<BookDTO>();

	//画面遷移のためにSUCCESSを返すメソッド
	//または本の登録画面から続いてレビューを投稿する際に、該当本の詳細を取得するためのメソッド
	//戻り値：画面遷移するための変数result
	public String execute() throws SQLException {

		String result = SUCCESS;

		//本の登録画面からレビュー投稿に映る場合のフラグ判定、、書籍情報取得
		if (session.get("continuePostFlg").toString().equals("on")) {

			bookDetail = bookInfoDAO.getRecentRegistBookInfo(Integer.parseInt((session.get("id")).toString()));
			session.put("bookDetail", bookDetail);

		}

		return result;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
