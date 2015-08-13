<%@page import="kodb.domain.PeopleDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>view2.jsp</title>
	</head>
	<body>
		<!-- expression tag : 출력담당ㅋ
			getName()을 보유한 객체가 미존재시(null) nullpointerexception발생 -->
		<%= ((PeopleDTO)request.getAttribute("s")).getName() %>
		<br>
		<%--EL tag : 데이터 미 존재시 Null예외가 아닌 blank화면 제공 --%>
		${requestScope.s.name}
	</body>
</html>