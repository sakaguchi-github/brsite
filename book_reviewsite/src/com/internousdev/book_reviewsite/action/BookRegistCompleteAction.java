package com.internousdev.book_reviewsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.book_reviewsite.dao.BookRegistDAO;
import com.opensymphony.xwork2.ActionSupport;

public class BookRegistCompleteAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;
	private BookRegistDAO bookRegistDAO = new BookRegistDAO();

	//確定された書籍情報をDBに登録するメソッド
	//戻り値：画面遷移のための変数result
	public String execute() throws SQLException {

		String result;
		//セッションから取り出した値をDBに登録するために、一部の値をint型にする
		int intId = Integer.parseInt(session.get("id").toString());

		int res = bookRegistDAO.bookRegist(intId,
				session.get("title").toString(),
				session.get("author").toString(),
				session.get("co_Author").toString(),
				session.get("publisher").toString(),
				session.get("bookType").toString(),
				session.get("bookGenre").toString());

		//登録成否判定、成功した場合続けてレビュー投稿に移れるように投稿フラグを立てる
		if (res > 0) {
			result = SUCCESS;
			session.put("continuePostFlg", "on");
		} else {
			result = "systemError";
		}

		return result;
	}

	//SessionAware実装によるオーバーライド義務
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
