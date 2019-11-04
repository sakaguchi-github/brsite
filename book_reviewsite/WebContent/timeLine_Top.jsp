<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="container-fluid">

	<div class="row">
		<div class="col-9" style="margin-left: 12em; height: 100%">

			<jsp:include page="jumbotron.jsp" />

			<div class="row justify-content-between"
				style="margin-left: 1em; margin-top: 7em">
				<div class="col-9">
					<s:iterator value="#session.reviewList_ForTop" status="st">
						<ul class="list-unstyled border border-dark px-2 py-3 bg-white"
							style="border-radius: 1rem; margin-top: -10px">
							<li><h5 style="text-indent: 1em; border-bottom: 1.5px solid">
									<b>『<s:property value="highlight" />』
									</b>
								</h5></li>
							<li class="media p-3">
								<div class="d-block" style="width: 150px;">
									<img
										src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>'
										class="img-fluid" /><br> <a
										href='<s:url action="BookDetailAction"><s:param name="bookId" value="%{bookId}" /></s:url>'>
										<b style="font-size: 0.8em"><s:property value="title" /></b>
									</a><br> <span style="font-size: 0.8em">/<s:property
											value="author" /></span>
								</div>
								<div class="media-body ml-3 px-3 pb-3">
									<p>
										オススメ度<i class="fas fa-star"></i>
										<s:property value="recommendation" />
									</p>
									<s:if test="sFlg">
										<h3 class="text-danger">※このレビューにはネタバレが含まれています※</h3>
										<h6 class="text-muted">「このレビューを読む」から詳細画面を開くと読むことができます</h6>
									</s:if>
									<s:else>
										<s:property value="text" />
									</s:else>
									<br> <br>
									<div style="text-align: right; vertical-align: bottom">
										<p
											style="font-size: 0.8em; text-indent: 1em; padding-right: 0.2em; color: lightslategray">
											<i class="fas fa-user"></i>
											<s:property value="nickName" />
										</p>
										<p>
											<a
												href='<s:url action="ReviewDetailAction"><s:param name="reviewId" value="%{reviewId}" /></s:url>'>
												▶︎このレビューを読む </a>
										</p>
									</div>
								</div>
							</li>
						</ul>
					</s:iterator>
				</div>

				<div class="col-3 text-center">
					<div class="border border-dark"></div>
					<br>
					<h5>
						レビュー数TOP5<i class="fas fa-crown fa-sm"></i>
					</h5>
					<s:iterator value="#session.rankingList" status="st">
						<div class="d-block mb-3" style="width: 100%;">
							<img
								src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>'
								class="img-fluid" style="height: 100px" /><br>
							<div style="font-size: 0.8em">
								<a
									href='<s:url action="BookDetailAction"><s:param name="bookId" value="%{bookId}" /></s:url>'>
									<b><s:property value="title" /></b>
								</a><br>
							</div>
						</div>
					</s:iterator>
					<br>
					<div class="border border-dark"></div>
				</div>
			</div>

		</div>
	</div>

</div>