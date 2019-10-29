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
<title>本登録確認</title>
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

				<!-- 書籍登録確認フォーム -->

				<!-- 未入力項目がある場合に表示するエラーメッセージ -->
				<s:if test='errorMessage != ""'>
					<div>
						<s:property value="%{errorMessage}" />
					</div>
				</s:if>

				<div class="row" style="margin-left: 1em; margin-top: 5em">
					<div class="col-5 mt-3">

						<div class="card" style="width: 500px; margin: 0 auto;">
							<h4 class="card-header">本の登録</h4>
							<div class="card-body">

								<br>
								<h5>投稿する内容は以下でよろしいですか？</h5>
								<br>

								<s:form action="BookRegistConfirmAction">
									<div class="form-group mb-4">
										<label for="title">タイトル：</label> <input type="text"
											value="<s:property value="title" escape="false" />"
											class="form-control-plaintext ml-2" name="title" readonly>
									</div>
									<div class="form-group mb-4">
										<label for="author">著者：</label> <input type="text"
											value="<s:property value="author" escape="false" />"
											class="form-control-plaintext ml-2" name="author" readonly>
									</div>
									<div class="form-group mb-4">
										<label for="co_Author">共著者・編著者など：</label> <input type="text"
											value="<s:property value="co_Author" escape="false" />"
											class="form-control-plaintext ml-2" name="co_Author" readonly>
									</div>
									<div class="form-group mb-4">
										<label for="publisher">出版：</label> <input
											class="form-control-plaintext ml-2" name="publisher"
											value="<s:property value="publisher" escape="false" />"
											readonly>
									</div>
									<div class="form-group mb-4">
										<label for="genreId">ジャンル：</label> <input
											class="form-control-plaintext ml-2" name="genreId"
											value="<s:property value="genreId" escape="false" />"
											readonly>
									</div>
									<div class="row">
										<div class="col-12 text-right">
											<input type="button" value="修正する"
												onclick="submitAction('BookRegistAction')"> <input
												type="button" value="この内容で本を登録する"
												onclick="submitAction('BookRegistCompleteAction')">
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