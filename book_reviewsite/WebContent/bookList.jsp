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
			<div class="col-9" style="margin-left: 12em">

				<jsp:include page="jumbotron.jsp" />

				<form action="BookSearchAction"
					style="line-height: 20%; margin-left: 1em; margin-top: 7em">


					<div class="dropdown d-inline-block">
						<button class="btn btn-secondary dropdown-toggle"
							data-toggle="dropdown">書籍カテゴリー選択</button>
						<div class="dropdown-menu">
							<a href="#" class="dropdown-item">TEST</a>
							<%-- 								<s:if test='#session.bookCategoryDTOList!=null && #session.bookCategoryDTOList.size()>0'> --%>
							<%-- 									<li><s:select name="categoryId" --%>
							<%-- 											list="#session.bookCategoryDTOList" listValue="categoryName" --%>
							<%-- 											listKey="categoryId" class="dropdown-item" /></li> --%>
							<%-- 								</s:if> --%>

						</div>
						<button class="btn btn-secondary dropdown-toggle"
							data-toggle="dropdown">ジャンル選択</button>
						<div class="dropdown-menu">
							<a href="#" class="dropdown-item">TEST</a>
							<%-- 								<s:if test='#session.bookCategoryDTOList!=null && #session.bookCategoryDTOList.size()>0'> --%>
							<%-- 									<li><s:select name="categoryId" --%>
							<%-- 											list="#session.bookCategoryDTOList" listValue="categoryName" --%>
							<%-- 											listKey="categoryId" class="dropdown-item" /></li> --%>
							<%-- 								</s:if> --%>

						</div>
					</div>
					<div class="btn-group text-center"
						style="overflow: hidden; white-space: nowrap">

						<input type="text" class="form-control mr-2" name="keyword"
							placeholder="本のタイトル、著者名">
						<div class="input-group-btn">
							<button class="btn btn-dark" type="submit">
								<i class="fa fa-search"></i>
							</button>
						</div>
					</div>
				</form>

				<div class="row">
					<div class="col-12 mt-3 text-center">
						<table>
							<s:iterator value="#session.bookListAll" status="st">

								<s:if test="#st.index%4 == 0">
									<tr>
								</s:if>
								<td class="m-2 p-2 text-center">
									<div class="card text-center d-inline-block">
										<div class="card-body">
											<h6 class="card-subtitle text-muted">
												<s:property value="genreId" />
											</h6>
										</div>
										<img src="./images/bookicon03.png" style="width: 150px">
										<div class="card-body">
											<h4 class="card-title overflow-hidden">
												<s:property value="title" />
											</h4>
											<p class="card-text overflow-hidden">
												著者：<s:property value="author" />
											</p>
											<p>
												<a
													href='<s:url action="BookDetailAction"><s:param name="bookId" value="%{bookId}" /></s:url>'
													class="btn btn-info">本の詳細
												</a>
											</p>
										</div>
									</div>
								</td>
								<s:if test="#st.index%4 == 3">
									</tr>
								</s:if>

							</s:iterator>
						</table>
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