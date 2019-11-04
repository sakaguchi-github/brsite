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
<title>本の登録</title>
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

				<div class="row" style="margin-left: 2em; margin-top: 7em">

					<!-- 書籍登録フォーム -->

					<div class="col-12">
						<div
							class="col-12 text-center alert alert-warning border border-dark">
							<h3>本の登録</h3>
						</div>

						<!-- 未入力項目がある場合に表示するエラーメッセージ -->
						<s:if test='errorMessage != ""'>
							<div class="col-12 m-3 text-center" style="border-radius: 1rem;">
								<h4>
									<s:property value="%{errorMessage}" />
								</h4>
							</div>
						</s:if>

						<s:form action="BookRegistConfirmAction">
							<div class="form-group row">
								<label class="col-3 col-form-label text-right" for="title">タイトル：</label>
								<div class="col-8">
									<input type="text" class="form-control" name="title">
								</div>
							</div>
							<div class="form-group row">
								<label class="col-3 col-form-label text-right" for="author">著者：</label>
								<div class="col-8">
									<input type="text" class="form-control" name="author">
								</div>
							</div>
							<div class="form-group row">
								<label class="col-3 col-form-label text-right" for="co_Author">共著者など：</label>
								<div class="col-8">
									<input type="text" class="form-control" name="co_Author">
								</div>
							</div>
							<div class="form-group row">
								<label class="col-3 col-form-label text-right" for="publisher">出版：</label>
								<div class="col-8">
									<input type="text" class="form-control" name="publisher">
								</div>
							</div>
							<div class="form-group row">
								<label class="col-3 col-form-label text-right" for="bookType">種別：</label>
								<div class="col-3">
									<select class="custom-select" name="bookType"
										style="min-width: 10em">
										<option value="コミック" selected>コミック</option>
										<option value="小説">小説</option>
										<option value="ライトノベル">ライトノベル</option>
										<option value="絵本">絵本</option>
										<option value="参考書">参考書</option>
										<option value="学術書">学術書</option>
										<option value="同人誌">同人誌</option>
										<option value="その他">その他</option>
									</select>
								</div>
							</div>
							<div class="form-group row">
								<label class="col-3 col-form-label text-right" for="bookGenre">ジャンル：</label>
								<div class="col-3">
									<select class="custom-select" name="bookGenre"
										style="min-width: 10em">
										<option value="青春" selected>青春</option>
										<option value="恋愛">恋愛</option>
										<option value="感動">感動</option>
										<option value="ホラー">ホラー</option>
										<option value="サスペンス">サスペンス</option>
										<option value="推理">推理</option>
										<option value="SF">SF</option>
										<option value="伝記">伝記</option>
										<option value="ノンフィクション">ノンフィクション</option>
										<option value="歴史">歴史</option>
										<option value="その他">その他</option>
									</select>
								</div>
							</div>
							<div class="row">
								<div class="col-12 mt-3 text-center">
									<button type="submit" class="btn btn-info" style="width: 15em">入力内容確認</button>
								</div>
							</div>
						</s:form>

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