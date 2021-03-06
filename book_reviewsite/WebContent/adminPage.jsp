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
<title>管理者用ページ</title>

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
			<div class="col-9"
				style="margin-top: 4em; margin-left: 13em; height: 100%;">

				<div class="row">
					<div class="col-12 mt-3 text-center" style="font-size: 0.8em">

						<ul class="nav nav-tabs nav-justified" role="tablist">
							<li class="nav-item"><a class="nav-link active"
								data-toggle="tab" href="#mypage-tab-1" role="tab"
								aria-controls="item1" aria-selected="true"> <i
									class="fas fa-user"></i><span class="d-none d-sm-inline pl-1">
										登録ユーザーリスト</span>
							</a></li>
							<li class="nav-item"><a class="nav-link" data-toggle="tab"
								href="#mypage-tab-2" role="tab" aria-controls="item1"
								aria-selected="false"> <i class="fas fa-book"></i><span
									class="d-none d-sm-inline pl-1"> 書籍リスト</span>
							</a></li>
							<li class="nav-item"><a class="nav-link" data-toggle="tab"
								href="#mypage-tab-3" role="tab" aria-controls="item1"
								aria-selected="false"> <i class="fas fa-edit"></i><span
									class="d-none d-sm-inline pl-1"> レビューリスト</span>
							</a></li>
						</ul>

						<!-- 各タブ内容 -->
						<div class="tab-content">
							<div id="mypage-tab-1" class="tab-pane fade show active my-3">

								<h3 class="py-3">登録ユーザーリスト</h3>
								<table
									class="table table-sm table-striped table-bordered table-hover my-3">
									<thead class="thead-dark">
										<tr>
											<th>管理者権限</th>
											<th>管理No</th>
											<th>ユーザーID</th>
											<th>ニックネーム</th>
											<th>登録日時</th>
											<th>更新日時</th>
										</tr>
									</thead>
									<tbody>
										<s:iterator value="#session.userListAll">
											<s:if test="status == 1">
												<tr class="table-warning">
													<td><s:property value="status" /></td>
													<td><s:property value="id" /></td>
													<td><s:property value="userId" /></td>
													<td><s:property value="nickName" /></td>
													<td><s:property value="registDate" /></td>
													<td><s:property value="updateDate" /></td>
												</tr>
											</s:if>
											<s:else>
												<tr>
													<td><s:property value="status" /></td>
													<td><s:property value="id" /></td>
													<td><s:property value="userId" /></td>
													<td><s:property value="nickName" /></td>
													<td><s:property value="registDate" /></td>
													<td><s:property value="updateDate" /></td>
												</tr>
											</s:else>
										</s:iterator>
									</tbody>
								</table>

							</div>
							<div id="mypage-tab-2" class="tab-pane fade my-3">
								<h3 class="py-3">書籍リスト</h3>
								<table
									class="table table-sm table-striped table-bordered table-hover my-3">
									<thead class="thead-dark">
										<tr>
											<th>書籍管理No</th>
											<th>登録ユーザーNo</th>
											<th>タイトル</th>
											<th>著者</th>
											<th>共著者など</th>
											<th>出版元</th>
											<th>種別</th>
											<th>ジャンル</th>
											<th>登録日時</th>
											<th>更新日時</th>
										</tr>
									</thead>
									<tbody>
										<s:iterator value="#session.bookListAll">
											<tr>
												<td><s:property value="bookId" /></td>
												<td><s:property value="regiUserId" /></td>
												<td><s:property value="title" /></td>
												<td><s:property value="author" /></td>
												<td><s:property value="co_Author" /></td>
												<td><s:property value="publisher" /></td>
												<td><s:property value="typeName" /></td>
												<td><s:property value="genreName" /></td>
												<td><s:property value="registDate" /></td>
												<td><s:property value="updateDate" /></td>
											</tr>
										</s:iterator>
									</tbody>
								</table>
							</div>
							<div id="mypage-tab-3" class="tab-pane fade my-3">

								<h3 class="py-3">レビューリスト</h3>
								<table
									class="table table-sm table-striped table-bordered table-hover my-3">
									<thead class="thead-dark">
										<tr>
											<th>レビュー管理No</th>
											<th>登録ユーザーNo</th>
											<th>登録書籍No</th>
											<th>レビュー見出し</th>
											<th>本文</th>
											<th>オススメ度</th>
											<th>ネタバレフラグ</th>
											<th>登録日時</th>
											<th>更新日時</th>
										</tr>
									</thead>
									<tbody>
										<s:iterator value="#session.reviewListAll" status="st">
											<tr>
												<td><s:property value="reviewId" /></td>
												<td><s:property value="regiUserId" /></td>
												<td><s:property value="title" /></td>
												<td><s:property value="highlight" /></td>
												<td><a
													href='<s:url action="ReviewDetailAction"><s:param name="reviewId" value="%{reviewId}" /></s:url>'>
														読む </a></td>
												<td><s:property value="recommendation" /></td>
												<td><s:property value="sFlg" /></td>
												<td><s:property value="registDate" /></td>
												<td><s:property value="updateDate" /></td>
											</tr>
										</s:iterator>
									</tbody>
								</table>
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