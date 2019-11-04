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
<title>レビュー詳細</title>
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
					<s:iterator value="#session.reviewDetail">
						<div class="card my-3 py-2 border-dark"
							style="border-radius: 1em; min-width: 200px;">
							<div class="card-body">

								<table>
									<tbody>
										<tr>
											<h3 class="mb-3 pb-3">
												<b>『<s:property value="highlight" />』
												</b>
											</h3>
										</tr>
										<tr>
											<h5 class="card-subtitle mb-2">
												<p>
													オススメ度<i class="fas fa-star"></i>
													<s:property value="recommendation" />
												</p>
											</h5>
											<div class="card-text py-2">
												<p>
													<s:property value="text" />
												</p>
												<p class="card-subtitle mb-2 text-muted">
													<i class="fas fa-user"></i> 投稿者：
													<s:property value="nickName" />
												</p>
												<p class="text-muted text-left">
													投稿日：
													<s:property value="registDate" />
												</p>
											</div>

											<p class="text-center">
												<a
													href='<s:url action="BookDetailAction"><s:param name="bookId" value="%{bookId}" /></s:url>'
													class="btn btn-info">「<s:property value="title" />」の詳細
												</a>
											</p>
										</tr>
									</tbody>
								</table>

							</div>
						</div>
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