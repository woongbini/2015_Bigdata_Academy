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
		<!-- expression tag : ��´�礻
			getName()�� ������ ��ü�� �������(null) nullpointerexception�߻� -->
		<%= ((PeopleDTO)request.getAttribute("s")).getName() %>
		<br>
		<%--EL tag : ������ �� ����� Null���ܰ� �ƴ� blankȭ�� ���� --%>
		${requestScope.s.name}
	</body>
</html>