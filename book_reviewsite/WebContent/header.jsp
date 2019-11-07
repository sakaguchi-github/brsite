<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<header>

	<div class="bg-white ml-auto"
		style="width: 12em; height: 100vh; margin-left: -15px; position: fixed; z-index: 1000;">
		<div class="px-0 py-3">
			<a href='<s:url action="BackTopAction" />'> <img
				src="./images/bi_dojin.png" class="img-fluid p-3"></a>
		</div>

		<s:if test="!(#session.loginFlg)">
			<table class="table table-borderless table-hover text-center">
				<tbody>
					<tr>
						<td><a href='<s:url action="BackTopAction" />'
							style="text-decoration: none; color: #000; display: block; padding: 0.75em; margin: -0.75em;">TOP</a></td>
					</tr>
					<tr>
						<td><a href='<s:url action="BookListAction" />'
							style="text-decoration: none; color: #000; display: block; padding: 0.75em; margin: -0.75em;">本を探す</a></td>
					</tr>
					<tr>
						<td><a href='<s:url action="ReviewListAllAction" />'
							style="text-decoration: none; color: #000; display: block; padding: 0.75em; margin: -0.75em;">レビューを探す</a></td>
					</tr>
					<tr>
						<td><a href='<s:url action="Menu_LoginAction" />'
							style="text-decoration: none; color: #000; display: block; padding: 0.75em; margin: -0.75em;">ログイン</a></td>
					</tr>
					<tr>
						<td><a href='<s:url action="Menu_UserCreateAction" />'
							style="text-decoration: none; color: #000; display: block; padding: 0.75em; margin: -0.75em;">新規登録</a></td>
					</tr>
				</tbody>
			</table>
		</s:if>

		<s:else>
			<p class="mt-0 text-center text-info" style="font-size: 0.8em">
				ログインユーザー：<br>
				<s:property value="#session.nickName" />
				さん
			</p>
			<table class="table table-borderless table-hover text-center">
				<tbody>
					<!-- 管理者権限でログインした時だけ表示される管理者用ページ -->
					<s:if test="#session.status == 1">
						<tr>
							<td><a href='<s:url action="AdminAction" />'
								class="bg-warning"
								style="text-decoration: none; color: #000; display: block; padding: 0.75em; margin: -0.75em;">管理者用ページ</a></td>
						</tr>
					</s:if>
					<!--  -->
					<tr>
						<td><a href='<s:url action="BackTopAction" />'
							style="text-decoration: none; color: #000; display: block; padding: 0.75em; margin: -0.75em;">TOP</a></td>
					</tr>
					<tr>
						<td><a href='<s:url action="BookListAction" />'
							style="text-decoration: none; color: #000; display: block; padding: 0.75em; margin: -0.75em;">本を探す</a></td>
					</tr>
					<tr>
						<td><a href='<s:url action="ReviewListAllAction" />'
							style="text-decoration: none; color: #000; display: block; padding: 0.75em; margin: -0.75em;">レビューを探す</a></td>
					</tr>
					<tr>
						<td><a href='<s:url action="BookRegistAction" />'
							style="text-decoration: none; color: #000; display: block; padding: 0.75em; margin: -0.75em;">本を登録する</a></td>
					</tr>
					<tr>
						<td><a href='<s:url action="Menu_ReviewPostAction" />'
							style="text-decoration: none; color: #000; display: block; padding: 0.75em; margin: -0.75em;">レビューする</a></td>
					</tr>
					<tr>
						<td><a href='<s:url action="MyPageAction" />'
							style="text-decoration: none; color: #000; display: block; padding: 0.75em; margin: -0.75em;">マイページ</a></td>
					</tr>
					<tr>
						<td><a href='<s:url action="LogoutAction" />'
							style="text-decoration: none; color: #000; display: block; padding: 0.75em; margin: -0.75em;">ログアウト</a></td>
					</tr>
				</tbody>
			</table>
		</s:else>

	</div>

</header>
