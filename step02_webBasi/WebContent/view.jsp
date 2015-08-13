<%@page import="kodb.domain.PeopleDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%--1라인
    		page지시자
			1. 응답시에 text기반의 html로 할 것이며, 한글 출력히 가능하게 설정
				이 파일 작업시euc-kr 즉, 한글로도 작성함을 설정
			2. impost문장 선언 --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>view.jsp</title>
	</head>
	<body>
		LoginCheck에서 새로 저장시킨 친구 정보와 내 id값과 함께 출력하기<br><hr><br>
		<% //순수 자바 코드 개발 tag ; scripting tag라고 함
			//데이터 request로부터 반환
			String id = request.getParameter("id");
			PeopleDTO people = (PeopleDTO)request.getAttribute("s");
			out.println(people.getName());
		%>
		<br><hr><br>
		expression tag : EL tag - 출력 담당 tag <br>
		<font color = "blue"> ${requestScope.s.name} </font>
		
		<br>
		<%=id %>
		<br><br><hr><br>
	</body>
</html>