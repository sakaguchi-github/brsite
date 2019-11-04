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
<script>
	window.onload = function() {
		var dateObj = new Date();
		var y = dateObj.getFullYear();
		var m = dateObj.getMonth() + 1;
		var d = dateObj.getDate();
		var yb = "日月火水木金土".charAt(dateObj.getDay());
		document.getElementById("currentDate").innerHTML = y + "年" + m + "月"
				+ d + "日(" + yb + ")";
	}
</script>
<title>ログイン</title>
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
<body
	style="background-color: wheat; font-family: 'Lato', 'Noto Sans JP', '游ゴシック Medium', '游ゴシック体', 'Yu Gothic Medium', YuGothic, 'メイリオ', Meiryo, 'ＭＳ Ｐゴシック', 'MS PGothic', sans-serif">

	<jsp:include page="header.jsp" />

	<div class="container-fluid">

		<div class="row">
			<div class="col-9" style="margin-left: 12em; height: 100%">

				<jsp:include page="jumbotron.jsp" />

				<div class="row" style="margin-left: 1em; margin-top: 10em">
					<!-- ログインできなかった場合のメッセージ表示 -->
					<s:if test='errorMessage != ""'>
						<div class="col-12 m-3 text-center" style="border-radius: 1rem;">
							<h4>
								<s:property value="%{errorMessage}" />
							</h4>
						</div>
					</s:if>
					<div class="col-12 mt-3">
						<div class="card" style="width: 300px; margin: 0 auto;">
							<h4 class="card-header">ログインフォーム</h4>
							<div class="card-body">
								<s:form action="LoginAction">
									<div class="form-group mb-4">
										<label for="userId">ユーザーID</label> <input type="text"
											class="form-control" name="userId">
									</div>
									<div class="form-group mb-4">
										<label for="password">パスワード</label> <input type="password"
											class="form-control" name="password">
									</div>
									<div class="row">
										<div class="col-12 text-right">
											<button type="submit" class="btn btn-info"
												style="margin: 0 0 0 auto;">ログイン</button>
										</div>
									</div>
								</s:form>
							</div>
							<div class="card-footer text-info text-right">
								本日は<span id="currentDate"></span>です
							</div>
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