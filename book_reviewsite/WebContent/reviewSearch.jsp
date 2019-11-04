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
<title>レビューリスト</title>
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
			<div class="col-10" style="margin-left: 12em">

				<jsp:include page="jumbotron.jsp" />
				<div style="margin-left: 1em; margin-top: 7em">
					<s:form action="ReviewSearchAction">
						<div class="form-group row">
							<div class="text-dark">
								<select class="bg-white custom-select"
									name="recommendation" style="width: 8em">
									<option value="なし" selected>オススメ度</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
								</select>
							</div>
							<div class="btn-group ml-2">
								<input type="text" class="form-control mr-2" name="keywords" style="width: 20em"
									placeholder="レビュータイトル、本文など">
								<div class="input-group-btn">
									<button class="btn btn-dark" type="submit">
										<i class="fa fa-search"></i>
									</button>
								</div>
							</div>
						</div>
					</s:form>
				</div>

				<div class="row">
					<div class="col-11 m-3">
						<s:iterator value="#session.reviewDTOList">
							<div class="card m-3 border-info" style="border-radius: 1rem">
								<div class="card-body">
									<div class="row">
										<div class="col-12 pr-3">
											<h5 class="card-title">
												<b> 『 <s:property value="highlight" /> 』
												</b>
											</h5>
											<p>
												オススメ度<i class="fas fa-star"></i>
												<s:property value="recommendation" />
											</p>
											<p class="card-text">
												<s:if test="sFlg">
													<h3 class="text-danger">※このレビューにはネタバレが含まれています※</h3>
													<h6 class="text-muted">「このレビューを読む」から詳細画面を開くと読むことができます</h6>
												</s:if>
												<s:else>
													<s:property value="text" />
												</s:else>
											</p>
											<div class="text-right">
												<p class="card-subtitle mb-2 text-muted">
													<i class="fas fa-user"></i> 投稿者：
													<s:property value="nickName" />
												</p>
												<p class="text-muted">
													投稿日：
													<s:property value="registDate" />
												</p>
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