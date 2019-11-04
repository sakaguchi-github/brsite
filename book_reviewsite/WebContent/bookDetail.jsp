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
<title>本詳細</title>
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

				<div style="margin-left: 3em; margin-top: 8em">
					<s:iterator value="#session.bookDetail">
						<div class="card my-3 py-2 border-info"
							style="border-radius: 1em; min-width: 200px; width: 600px">
							<div class="card-body">

								<table style="width: 560px">
									<tbody>
										<tr>
											<h3 class="text-center mb-3 pb-3">
												<b><s:property value="title" /></b>
											</h3>
										</tr>
										<tr>

											<td><img
												src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>'
												style="width: 220px"></td>

											<td>


												<h5 class="card-subtitle mb-2">
													著者：
													<s:property value="author" />
													<br> 共著者など：
													<s:property value="co_Author" />
												</h5>
												<div class="card-text py-2">
													<p>
														出版：
														<s:property value="publisher" />
														<br> <br> 種別：
														<s:property value="typeName" />
														<br> ジャンル：
														<s:property value="genreName" />
													</p>
												</div>
												<p class="text-muted">
													登録日：
													<s:property value="registDate" />
												</p>

											</td>
										</tr>


									</tbody>
								</table>
								<s:if test="#session.loginFlg">
									<div class="text-center">
										<br>
										<s:form action="PostAction">
											<input type="button" class="btn btn-info"
												value="この本のレビューを書く！" onclick="submitAction('PostAction')">
											<s:param name="bookId" value="%{bookId}"></s:param>
										</s:form>
									</div>
								</s:if>
								<s:else>
									<br>
									<h6 class="text-muted text-center">※レビューするためにはログインが必要です</h6>
								</s:else>


							</div>
						</div>
					</s:iterator>
				</div>


				<h4 style="margin-top: 35px; text-indent: 1em">
					<b>この本のレビュー</b>
				</h4>
				<hr style="background-color: #000">
				<div class="row mb-3">
					<div class="col-12">

						<s:if test="!(#session.bookReviewList.size() > 0)">
							<h6 class="m-3" style="text-indent: 2em">投稿されたレビューはありません</h6>
						</s:if>
						<s:iterator value="#session.bookReviewList">
							<div class="card m-3 border-info" style="border-radius: 1rem">
								<div class="card-body">

									<div class="row">
										<div class="col-12 pr-3">
											<h5 class="card-title">
												<b> 『 <s:property value="highlight" /> 』
												</b>
											</h5>

											<div class="card-text mt-3">
												<p>
													オススメ度<i class="fas fa-star"></i>
													<s:property value="recommendation" />
												</p>
												<p>
													<s:if test="sFlg">
														<h3 class="text-danger">※このレビューにはネタバレが含まれています※</h3>
														<h6 class="text-muted">「このレビューを読む」から詳細画面を開くと読むことができます</h6>
													</s:if>
													<s:else>
														<s:property value="text" />
													</s:else>
												</p>
											</div>
											<div class="text-right">
												<h6 class="card-subtitle mb-2 text-muted">
													<i class="fas fa-user"></i> 投稿者：
													<s:property value="nickName" />
												</h6>
												<div class="text-muted">
													投稿日：
													<s:property value="registDate" />
												</div>
												<a
													href='<s:url action="ReviewDetailAction"><s:param name="reviewId" value="%{reviewId}" /></s:url>'>
													このレビューを読む </a>
											</div>
										</div>
									</div>
								</div>
							</div>
						</s:iterator>

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