<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<header>

	<div class="row mb-3 mt-auto text-nowrap"
		style="width: 100vw; height: 5em; margin-left: -1em; position: fixed; z-index: 999; background-color: dodgerblue">

<!-- 	<div class="bg-dark row mb-3 mt-auto text-nowrap" -->
<!-- 		style="background: url(./images/wood02.jpeg); background-size: cover; width: 100vw; height: 4em; margin-left: -1em; position: fixed; z-index: 999;"> -->


		<div class="col-6 text-white py-3"
			style="height: 5em; padding-left: 1.5em;">
			<h1 class="mb-3" style="display: inline-block"><b>KIMAMA</b></h1>
			<p class="ml-3 d-none d-lg-inline-block" style="display: inline-block; font-size: 12px">
				小説でもコミックスでも、参考書でも同人誌でも。<br>誰でも読んだ本を自由きままにレビューできるSNSです。
			</p>
		</div>

		<div class="col-3 mr-auto my-3 pt-2" style="display: inline-block">

			<form action="BookSearchAction" style="line-height: 20%;">
				<div class="btn-group text-center ml-3"
					style="overflow: hidden; white-space: nowrap">
					<input type="text" class="form-control mr-2" name="keyword" placeholder="本のタイトル、著者名">
					<div class="input-group-btn">
						<button class="btn btn-dark" type="submit">
							<i class="fa fa-search"></i>
						</button>
					</div>
				</div>
			</form>

		</div>
	</div>

</header>