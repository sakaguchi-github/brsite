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
<title>本棚</title>
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

				<div class="row" style="margin-left: 1em; margin-top: 6em">
					<div class="col-12 mt-3">
						<div class="row justyfy-content-between m-3 text-center">
							<div
								class="col-12 text-center alert alert-warning border border-dark">
								<h3>登録済みの本</h3>
							</div>
							<s:if test="#session.bookShelfList.size() > 0">
								<s:iterator value="#session.bookShelfList" status="st">
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
							</s:if>
							<s:else>
								<h5 style="text-indent: 2em"><b>まだ本が登録されていません。</b></h5>
							</s:else>
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