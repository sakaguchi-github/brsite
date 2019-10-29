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
<body style="background-color: wheat; font-family: 'Lato', 'Noto Sans JP', '游ゴシック Medium', '游ゴシック体', 'Yu Gothic Medium', YuGothic, 'メイリオ', Meiryo, 'ＭＳ Ｐゴシック', 'MS PGothic', sans-serif">

	<jsp:include page="header.jsp" />

	<div class="container-fluid">

		<div class="row">
			<div class="col-9" style="margin-left: 12em; height: 100%">

				<jsp:include page="jumbotron.jsp" />

				<div class="row" style="margin-left: 1em; margin-top: 5em">
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
									class="d-none d-sm-inline pl-1"> My本棚</span>
							</a></li>
							<li class="nav-item"><a class="nav-link" data-toggle="tab"
								href="#mypage-tab-3" role="tab" aria-controls="item1"
								aria-selected="false"> <i class="fas fa-edit"></i><span
									class="d-none d-sm-inline pl-1"> レビュー投稿履歴</span>
							</a></li>
							<li class="nav-item"><a class="nav-link" data-toggle="tab"
								href="#mypage-tab-4" role="tab" aria-controls="item1"
								aria-selected="false"> <i class="fas fa-question"></i><span
									class="d-none d-sm-inline pl-1"> お問い合わせ</span>
							</a></li>
						</ul>

						<!-- 各タブ内容 -->
						<div class="tab-content">
							<div id="mypage-tab-1" class="tab-pane fade show active my-3">

								<h3>アカウント情報</h3>
								<s:if test="#session.loginFlg">
									<s:iterator value="#session.loginUser">
										<ul class="my-3">
											<li><span>ニックネーム：</span> <s:property value="nickName" /></li>
											<li><span>ユーザーID：</span> <s:property value="userId" /></li>
											<li><span>パスワード：</span> <a
												href='<s:url action="ResetPasswordAction" />'>再設定する</a></li>
											<li><span>登録日時：</span> <s:property value="registDate" /></li>
											<li><span>登録書籍数：</span> <s:property
													value="regiBookAmount" /></li>
											<li><span>レビュー投稿数：</span> <s:property
													value="postReviewAmount" /></li>
										</ul>
									</s:iterator>
								</s:if>
							</div>

							<div id="mypage-tab-2" class="tab-pane fade">
								<h3>My本棚</h3>
								<s:if test="#session.bookShelfList.size > 0">
									<s:iterator value="#session.bookShelfList">

										<div class="card my-3 border-info" style="display: inline-block">
											<div class="card-body">

													<div class="col-3">
														<img src="./images/bookicon03.png" class="img-fluid">

														<h5 class="card-title">
															<s:property value="title" />
														</h5>
														<div class="card-text">
															<h6>
																<s:property value="author" />
																<br>
																<s:property value="co_Author" />
																<br>
																<s:property value="publisher" />
																<br>
																<s:property value="genreId" />
															</h6>
														</div>
														<div class="text-right"></div>
													</div>
												</div>
											</div>

									</s:iterator>
								</s:if>
								<s:else>
									<h6>まだ本が登録されていません。</h6>
								</s:else>
							</div>

							<div id="mypage-tab-3" class="tab-pane fade">
								<h3>レビュー投稿履歴</h3>
								<p>レビュー投稿履歴をここに表示</p>
							</div>

							<div id="mypage-tab-4" class="tab-pane fade">
								<h3>お問い合わせ</h3>

								<div class="col-5 mt-3">

									<div class="card" style="width: 500px; margin: 0 auto;">
										<h4 class="card-header">お問い合わせフォーム</h4>
										<div class="card-body">

											<s:form action="InquiryPostConfirmAction">
												<div class="form-group mb-4">
													<label for="iType">お問い合わせ種別</label> <select
														class="form-control input-sm col-6" name="iType">
														<option>利用方法に関する問い合わせ</option>
														<option>サイトに関する問い合わせ</option>
														<option>通報</option>
														<option>その他</option>
													</select>
												</div>
												<div class="form-group mb-4">
													<label for="iTitle">タイトル</label> <input type="text"
														class="form-control" name="iTitle">
												</div>
												<div class="form-group mb-4">
													<label for="iText">本文</label>
													<textarea class="form-control" name="iText" rows="10"></textarea>
												</div>
												<div class="row">
													<div class="col-12 text-right">
														<button type="submit" class="btn btn-info"
															style="margin: 0 0 0 auto;">入力内容確認</button>
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