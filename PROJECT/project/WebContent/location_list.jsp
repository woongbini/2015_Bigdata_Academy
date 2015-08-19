<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% String cp = request.getContextPath(); %> <%--ContextPath 선언 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel='stylesheet'
	href="http://fonts.googleapis.com/earlyaccess/nanumbrushscript.css">
<link rel='stylesheet'
	href="http://fonts.googleapis.com/earlyaccess/nanumgothic.css">
<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css">
	<link href="<%=cp%>/css/bootstrap.min.css" rel="stylesheet">
<title>location_list.jsp</title>
<style>
body {
	font-family: "Nanum Gothic";
}
</style>
</head>
<body>
	<div class="col-xs-12">
		<c:forEach items="${requestScope.regiData}" var="regiData">
			<h2>${regiData.board_number }-${regiData.title}</h2>
			<p>
				지역 : ${regiData.region}<br> 날짜: ${regiData.date}<br>
			<p class="lead">
				<button type="button" class="btn btn-default" data-toggle="collapse"
					data-target="#loc_readMore1">더보기</button>
			</p>
			<div id="loc_readMore1" class="panel-collapse collapse ">
				<div class="panel-body">
					<p>
						모집 인원: ${regiData.number_of_person}<br> 
						나이대 : ${regiData.age}<br>
						성별 : ${regiData.gender}<br> 
						게시자 : ${regiData.user_id}<br>
						위치 x좌표: ${regiData.location_x}<br> 
						위치 y좌표: ${regiData.location_y}<br> 
						상세 정보: ${regiData.detail}
					</p>
				</div>
			</div>
			<div class="panel-group" id="accordion1">
				<div class="panel">
					<div class="panel-heading">
						<ul class="list-inline">
							<p class="pull-right">
								<span class="label label-default">keyword</span> <span
									class="label label-default">tag</span> <span
									class="label label-default">post</span>
							</p>
							<li><a href="#">2 Days Ago</a></li>
							<li><a type="button" data-toggle="collapse"
								data-target="#loc_comment1"><i
									class="glyphicon glyphicon-comment"></i> 2 Comments</a></li>
							<li><a href="#"><i class="glyphicon glyphicon-share"></i>
									14 Shares</a></li>
							<li><a href="#"><i class="glyphicon glyphicon-heart"></i>
									찜하기</a></li>
						</ul>
					</div>
					<div id="loc_comment1" class="panel-collapse collapse ">
						<div class="panel-body">댓글보여주는 페이지</div>
					</div>
				</div>
			</div>
			</c:forEach>
	</div>
	
	<div class="col-xs-12">
	
	
		<h2>게시글1 : 배드민턴 같이 해요</h2>
		<p>글쓰기 폼에서 입력한 정보 보여주는 곳</p>
		<p class="lead">
			<button type="button" class="btn btn-default"  data-toggle="collapse"
				data-target="#loc_readMore1">Read More</button>
		</p>
		<div id="loc_readMore1" class="panel-collapse collapse ">
			<div class="panel-body">상세정보 보여주기 페이지</div>
		</div>
		<div class="panel-group" id="accordion1">
			<div class="panel">
				<div class="panel-heading">
					<ul class="list-inline">
						<p class="pull-right">
							<span class="label label-default">keyword</span> <span
								class="label label-default">tag</span> <span
								class="label label-default">post</span>
						</p>
						<li><a href="#">2 Days Ago</a></li>
						<li><a type="button" data-toggle="collapse"
							data-target="#loc_comment1"><i
								class="glyphicon glyphicon-comment"></i> 2 Comments</a></li>
						<li><a href="#"><i class="glyphicon glyphicon-share"></i>
								14 Shares</a></li>
						<li><a href="#"><i class="glyphicon glyphicon-heart"></i>
								찜하기</a></li>
					</ul>
				</div>
				<div id="loc_comment1" class="panel-collapse collapse ">
					<div class="panel-body">댓글보여주는 페이지</div>
				</div>
			</div>
		</div>
	</div>
	<!--게시글 1 끝 -->

	<!--게시글 2-->
	<div class="col-xs-12">
		<h2>게시글2 : 배드민턴 같이 해요</h2>
		<p>글쓰기 폼에서 입력한 정보 보여주는 곳</p>
		<p class="lead">
			<button type="button" class="btn btn-default" data-toggle="collapse"
				data-target="#loc_readMore2">Read More</button>
		</p>
		<div id="loc_readMore2" class="panel-collapse collapse ">
			<div class="panel-body">상세정보 보여주기 페이지</div>
		</div>
		<div class="panel-group" id="accordion1">
			<div class="panel">
				<div class="panel-heading">
					<ul class="list-inline">
						<p class="pull-right">
							<span class="label label-default">keyword</span> <span
								class="label label-default">tag</span> <span
								class="label label-default">post</span>
						</p>
						<li><a href="#">2 Days Ago</a></li>
						<li><a type="button" data-toggle="collapse"
							data-target="#loc_comment2"><i
								class="glyphicon glyphicon-comment"></i> 2 Comments</a></li>
						<li><a href="#"><i class="glyphicon glyphicon-share"></i>
								14 Shares</a></li>
						<li><a href="#"><i class="glyphicon glyphicon-heart"></i>
								찜하기</a></li>
					</ul>
				</div>
				<div id="loc_comment2" class="panel-collapse collapse ">
					<div class="panel-body">댓글보여주는 페이지</div>
				</div>
			</div>
		</div>
	</div>
	<!--게시글 2 끝 -->

	<!--게시글 3-->
	<div class="col-xs-12">
		<h2>게시글3 : 배드민턴 같이 해요</h2>
		<p>글쓰기 폼에서 입력한 정보 보여주는 곳</p>
		<p class="lead">
			<button type="button" class="btn btn-default"  data-toggle="collapse"
				data-target="#loc_readMore3">Read More</button>
		</p>
		<div id="loc_readMore3" class="panel-collapse collapse ">
			<div class="panel-body">상세정보 보여주기 페이지</div>
		</div>
		<div class="panel-group" id="accordion1">
			<div class="panel">
				<div class="panel-heading">
					<ul class="list-inline">
						<p class="pull-right">
							<span class="label label-default">keyword</span> <span
								class="label label-default">tag</span> <span
								class="label label-default">post</span>
						</p>
						<li><a href="#">2 Days Ago</a></li>
						<li><a type="button" data-toggle="collapse"
							data-target="#loc_comment3"><i
								class="glyphicon glyphicon-comment"></i> 2 Comments</a></li>
						<li><a href="#"><i class="glyphicon glyphicon-share"></i>
								14 Shares</a></li>
						<li><a href="#"><i class="glyphicon glyphicon-heart"></i>
								찜하기</a></li>
					</ul>
				</div>
				<div id="loc_comment3" class="panel-collapse collapse ">
					<div class="panel-body">댓글보여주는 페이지</div>
				</div>
			</div>
		</div>
	</div>
	<!--게시글 3 끝 -->
	<script src="http://code.jquery.com/jquery-2.1.1.min.js" type="text/javascript"></script>
    <script src="<%=cp%>/js/bootstrap.min.js"></script>


</body>
</html>