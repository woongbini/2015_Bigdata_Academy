<%@page import="kodb.domain.PeopleDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%--1����
    		page������
			1. ����ÿ� text����� html�� �� ���̸�, �ѱ� ����� �����ϰ� ����
				�� ���� �۾���euc-kr ��, �ѱ۷ε� �ۼ����� ����
			2. impost���� ���� --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>view.jsp</title>
	</head>
	<body>
		LoginCheck���� ���� �����Ų ģ�� ������ �� id���� �Բ� ����ϱ�<br><hr><br>
		<% //���� �ڹ� �ڵ� ���� tag ; scripting tag��� ��
			//������ request�κ��� ��ȯ
			String id = request.getParameter("id");
			PeopleDTO people = (PeopleDTO)request.getAttribute("s");
			out.println(people.getName());
		%>
		<br><hr><br>
		expression tag : EL tag - ��� ��� tag <br>
		<font color = "blue"> ${requestScope.s.name} </font>
		
		<br>
		<%=id %>
		<br><br><hr><br>
	</body>
</html>