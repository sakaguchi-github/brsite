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
<title>本リスト</title>
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

		<div class="row text-nowrap">
			<div class="col-10" style="margin-left: 12em">

				<jsp:include page="jumbotron.jsp" />

				<div style="margin-left: 1em; margin-top: 7em">
					<s:form action="BookSearchAction">
						<div class="form-group row">
							<div class="text-dark">
								<select class="bg-white custom-select"
									name="bookType" style="width: 10em">
									<option value="なし" selected>書籍種別</option>
									<option value="コミック">コミック</option>
									<option value="小説">小説</option>
									<option value="ライトノベル">ライトノベル</option>
									<option value="絵本">絵本</option>
									<option value="参考書">参考書</option>
									<option value="学術書">学術書</option>
									<option value="同人誌">同人誌</option>
									<option value="その他">その他</option>
								</select>
							</div>
							<div class="text-dark">
								<select class="bg-white ml-2 custom-select" name="bookGenre"
									style="width: 10em">
									<option value="なし" selected>ジャンル</option>
									<option value="青春">青春</option>
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
							<div class="btn-group ml-2">
								<input type="text" class="form-control mr-2" name="keywords" style="width: 20em"
									placeholder="本のタイトル、著者・共著者名、出版社名など">
								<div class="input-group-btn">
									<button class="btn btn-dark" type="submit">
										<i class="fa fa-search"></i>
									</button>
								</div>
							</div>
						</div>
					</s:form>
				</div>

				<div class="row justyfy-content-between m-3 text-center">

					<s:iterator value="#session.bookInfoDTOList" status="st">

						<div class="card m-2 p-3 text-center d-inline-block"
							style="width: 250px; white-space: normal;">

							<img
								src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>'
								style="height: 150px">
							<div class="card-body">
								<h4 class="overflow-hidden">
									<s:property value="title" />
								</h4>
								<p class="coverflow-hidden text-left">
									著者：
									<s:property value="author" />
									<br> ジャンル：
									<s:property value="genreName" />

								</p>
								<p>
									<a
										href='<s:url action="BookDetailAction"><s:param name="bookId" value="%{bookId}" /></s:url>'
										class="btn btn-info">本の詳細 </a>
								</p>
							</div>
						</div>

						<s:if test="#st.index%3 == 2">
							<p></p>
						</s:if>

					</s:iterator>

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