<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script defer
	src="https://use.fontawesome.com/releases/v5.11.2/js/all.js"></script>
<script type="text/javascript">
	function submitAction(url) {
		$('form').attr('action', url);
		$('form').submit();
	}
</script>
<title>マイレビューリスト</title>
<style type="text/css">
.form-control::placeholder {
	color: #ccc;
	font-size: 0.9em;
	line-height: 1.8;
}
a {
	color: #007BFF;
}
a:hover {
	color: #17A2B8;
	text-decoration: none;
}
</style>
</head>
<body style="background-color: wheat; font-family: 'Lato', 'Noto Sans JP', '游ゴシック Medium', '游ゴシック体', 'Yu Gothic Medium', YuGothic, 'メイリオ', Meiryo, 'ＭＳ Ｐゴシック', 'MS PGothic', sans-serif">

	<!-- Header -->
	<jsp:include page="header.jsp" />

	<!-- Main -->
	<div id="main">
		<h1>マイページ画面</h1>
		<div id="top_text">
			<h2>MYPAGE</h2>
		</div>
		<div>
			<p>・アカウント情報確認</p>
			<p>・本棚を見る</p>
			<p>・投稿したレビュー</p>
			<p>・問い合わせする</p>
		</div>
		<!-- アクティブユーザーメニューリスト -->
		<s:form>
			<s:if test="#session.loginFlg">
			タブ形式で情報表示？

				<li><input type="button" value="本棚をみる"
					onclick="submitAction('BookShelfAction')"></li>
				<li><input type="button" value="投稿したレビューを確認する"
					onclick="submitAction('ReviewListAction')"><s:param name="reviewList_MyPageFlg" value="true"></s:param></li>
				<li><input type="button" value="問い合わせする"
					onclick="submitAction('InquiryAction')"></li>

			</s:if>
		</s:form>
	</div>

	<!-- Footer -->
	<div id="footer">
		<div id="pr"></div>
	</div>
</body>
</html>