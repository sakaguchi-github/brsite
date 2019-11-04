package com.internousdev.book_reviewsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.book_reviewsite.dao.ReviewPostDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ReviewPostCompleteAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;
	private ReviewPostDAO reviewPostDAO = new ReviewPostDAO();

	//確定されたレビュー入力内容をDBに登録するメソッド
	//戻り値：画面遷移のための変数result
	public String execute() throws SQLException {

		String result;

		//DBに登録できるようにセッションの一部をint型に変換する
		int intBookId = Integer.parseInt(session.get("bookId").toString());
		int intRecommendation = Integer.parseInt(session.get("recommendation").toString());
		int intId = Integer.parseInt((session.get("id")).toString());

		int res = reviewPostDAO.reviewPost(intId, intBookId,
				session.get("highlight").toString(),
				intRecommendation, session.get("text").toString(),
				Boolean.parseBoolean(session.get("sFlg").toString()));

		//更新に成功していれば一時保存されていたセッション情報を消去
		//さらに、続けてレビュー詳細画面に移れるようにフラグを立てる
		//失敗の場合エラー画面に遷移
		if (res > 0) {
			result = SUCCESS;
			session.remove("bookId");
			session.remove("highlight");
			session.remove("text");
			session.remove("recommendation");
			session.remove("sFlg");
			session.put("continueCheckFlg", "on");
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
