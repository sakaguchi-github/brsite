<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="container-fluid">

	<!-- 	<div class="row" style="background: url(./images/bg02.jpg)"> -->
	<div class="row">
		<div class="col-9" style="margin-left: 12em; height: 100%">

			<jsp:include page="jumbotron.jsp" />

			<div class="row justify-content-between"
				style="margin-left: 2em; margin-top: 5em">
				<div class="col-12">

					<s:iterator value="#session.reviewList_ForTop" status="st">

						<s:if test="#st.index%2 == 0">
							<div class="d-inline-flex justify-content-center">
								<div class="row">
									<div class="col-3 ml-3 my-3 p-3">
										<a
											href='<s:url action="BookDetailAction"><s:param name="bookId" value="%{bookId}" /></s:url>'>
											<b><s:property value="title" /></b>
										</a><br> <a style="font-size: 0.9em"
											href='<s:url action="AuthorDetailAction"><s:param name="bookId" value="%{bookId}" /></s:url>'>
											<s:property value="author" />
										</a> <img src="./images/bookicon05.png" class="img-fluid"
											style="filter: drop-shadow(3px 8px 9px rgba(0, 0, 0, 0.5))" />

									</div>
									<div class="col-8 mr-3 my-3 p-3 border border-dark bg-white overflow-hidden"
										style="border-radius: 1rem">
										<h5 class="p-2">
											<b>『<s:property value="highlight" />』
											</b>
										</h5>
										<p class="p-2">
											<s:property value="text" />
										</p>
										<div class="text-right" style="vertical-align: bottom">
											<h6
												style="text-indent: 1em; padding-right: 0.2em; color: lightslategray">
												<i class="fas fa-user"></i>
												投稿者：
												<s:property value="regiUserId" />
											</h6>
											<a
												href='<s:url action="ReviewDetailAction"><s:param name="reviewId" value="%{reviewId}" /></s:url>'>
												このレビューを読む </a>
										</div>
									</div>
								</div>
							</div>
						</s:if>

						<s:elseif test="#st.index%2 == 1">
							<div class="d-inline-flex justify-content-center">
								<div class="row">
									<div class="col-8 mr-3 my-3 p-3 border border-dark bg-white"
										style="border-radius: 1rem">
										<h5 class="p-2">
											<b>『<s:property value="highlight" />』
											</b>
										</h5>
										<p class="p-2">
											<s:property value="text" />
										</p>
										<div class="text-left" style="vertical-align: bottom">
											<h6 style="color: lightslategray">
											<i class="fas fa-user"></i>
												投稿者：
												<s:property value="regiUserId" />
											</h6>
											<a
												href='<s:url action="ReviewDetailAction"><s:param name="reviewId" value="%{reviewId}" /></s:url>'>
												このレビューを読む </a>
										</div>
									</div>
									<div class="col-3 ml-3 my-3 p-3">
										<a
											href='<s:url action="BookDetailAction"><s:param name="bookId" value="%{bookId}" /></s:url>'>
											<b><s:property value="title" /></b>
										</a><br> <a style="font-size: 0.9em"
											href='<s:url action="AuthorDetailAction"><s:param name="bookId" value="%{bookId}" /></s:url>'>
											<s:property value="author" />
										</a> <img src="./images/bookicon05.png" class="img-fluid"
											style="filter: drop-shadow(3px 8px 9px rgba(0, 0, 0, 0.5))" />

									</div>
								</div>
							</div>
						</s:elseif>

					</s:iterator>

				</div>
			</div>
		</div>

	</div>

</div>