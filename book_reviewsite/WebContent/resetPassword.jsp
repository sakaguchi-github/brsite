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
<title>パスワード再設定</title>
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

	<jsp:include page="header.jsp" />

	<div class="container-fluid">

		<div class="row">
			<div class="col-9" style="margin-left: 12em; height: 100%">

				<jsp:include page="jumbotron.jsp" />

				<!-- 入力内容が正しくなかった場合のエラーメッセージ表示 -->
				<s:if test='errorMessage != ""'>
					<s:property value="%{errorMessage}" escape="false" />
				</s:if>

				<div class="row" style="margin-left: 1em; margin-top: 5em">
					<div class="col-12 mt-3">

						<div class="card" style="width: 300px; margin: 0 auto;">
							<h4 class="card-header">パスワード再設定フォーム</h4>
							<div class="card-body">

								<s:form action="ResetPasswordCompleteAction">
									<div class="form-group mb-4">
										<label for="password">現在のパスワード</label> <input type="text"
											class="form-control" name="password">
									</div>
									<div class="form-group mb-4">
										<label for="passCheck1">新しいパスワード</label> <input
											type="password" class="form-control" name="passCheck1">
									</div>
									<div class="form-group mb-4">
										<label for="passCheck2">新しいパスワード（再入力）</label> <input
											type="password" class="form-control" name="passCheck2">
									</div>
									<div class="row">
										<div class="col-12 text-right">
											<button type="submit" class="btn btn-info"
												style="margin: 0 0 0 auto;">確認</button>
										</div>
									</div>
								</s:form>

							</div>
							<div class="card-footer text-info text-right"></div>
						</div>

					</div>
				</div>
			</div>

		</div>

	</div>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>