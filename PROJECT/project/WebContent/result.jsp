<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<script type="text/javascript" src="js/jquery.js"></script>
<link href="css/rating_star.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/rating_star.js"></script>

<title>result.jsp</title>
</head>
<body>
등록하는 정보입니다.<br><br>
<% 
   

	request.setCharacterEncoding("UTF-8") ; 
	String title=request.getParameter("title");
	String region=request.getParameter("region");
	String gender=request.getParameter("gender");
	String location=request.getParameter("location");
	String detail=request.getParameter("detail");
	
%>

제목 : <%= title %><br>
지역 : <%= region %><br>
성별 : <%= gender %><br>
위치 : <%= location %><br>
세부정보: <%= detail %><br>

db에서 불러온 정보
<table border="1" bgcolor="#FF7575" bordercolor="white">
		<c:forEach items="${requestScope.regiData}" var="regiData">
			<tr>
				<td>${regiData.title}</td>
				<td>${regiData.region}</td>
				<td>${regiData.gender}</td>
				<td>${regiData.location }</td>
				<td>${regiData.detail }</td>
				<td>별점 Demo2(input type is hidden) 
						<input name="my_input"
							value="5" id="rating_simple2" type="hidden"></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>