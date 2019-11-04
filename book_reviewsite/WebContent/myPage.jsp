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
<title>マイページ</title>
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
	style="background-color: white; font-family: 'Lato', 'Noto Sans JP', '游ゴシック Medium', '游ゴシック体', 'Yu Gothic Medium', YuGothic, 'メイリオ', Meiryo, 'ＭＳ Ｐゴシック', 'MS PGothic', sans-serif">

	<jsp:include page="header.jsp" />

	<div class="container-fluid">

		<div class="row">
			<div class="col-9" style="margin-left: 12em; height: 100%">

				<jsp:include page="jumbotron.jsp" />

				<div class="row" style="margin-left: 1em; margin-top: 6em">
					<div class="col-12 mx-3 my-3">

						<ul class="nav nav-tabs nav-justified" role="tablist">
							<li class="nav-item"><a class="nav-link active"
								data-toggle="tab" href="#mypage-tab-1" role="tab"
								aria-controls="item1" aria-selected="true"> <i
									class="fas fa-user"></i><span class="d-none d-sm-inline pl-1">
										アカウント情報</span>
							</a></li>
							<li class="nav-item"><a class="nav-link" data-toggle="tab"
								href="#mypage-tab-2" role="tab" aria-controls="item1"
								aria-selected="false"> <i class="fas fa-book"></i><span
									class="d-none d-sm-inline pl-1"> 登録した本の一覧</span>
							</a></li>
							<li class="nav-item"><a class="nav-link" data-toggle="tab"
								href="#mypage-tab-3" role="tab" aria-controls="item1"
								aria-selected="false"> <i class="fas fa-edit"></i><span
									class="d-none d-sm-inline pl-1"> レビュー投稿履歴</span>
							</a></li>
						</ul>

						<!-- 各タブ内容 -->
						<div class="tab-content">
							<div id="mypage-tab-1" class="tab-pane fade show active my-3">

								<br>
								<h3 class="m-3">アカウント情報</h3>
								<s:if test="#session.loginFlg">
									<s:iterator value="#session.loginUser">
										<ul class="my-3">
											<li><h5>
													ニックネーム：
													<s:property value="nickName" />
												</h5></li>
											<li><h5>
													ユーザーID：
													<s:property value="userId" />
												</h5></li>
											<li><h5>
													パスワード： <a href='<s:url action="ResetPasswordAction" />'>再設定する</a>
												</h5></li>
											<li><h5>
													登録日時：
													<s:property value="registDate" />
												</h5></li>
										</ul>
									</s:iterator>
								</s:if>
							</div>

							<div id="mypage-tab-2" class="tab-pane fade">

								<div class="row justyfy-content-between m-3 text-center">
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
										<h6>まだ本が登録されていません。</h6>
									</s:else>
								</div>
							</div>

							<div id="mypage-tab-3" class="tab-pane fade">
								<div class="row">
									<div class="col-12 m-3">
										<s:iterator value="#session.userReviewList">
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
																<s:property value="text" />
															</p>
															<div class="text-right">
																<p class="text-muted">
																	投稿日：
																	<s:property value="registDate" />
																	<br> ネタバレ設定：
																	<s:if test="sFlg">
																		あり
																	</s:if>
																	<s:else>
																		なし
																	</s:else>
																</p>
																<a
																	href='<s:url action="ReviewDetailAction"><s:param name="reviewId" value="%{reviewId}" /></s:url>'>
																	レビュー詳細画面を開く </a>
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