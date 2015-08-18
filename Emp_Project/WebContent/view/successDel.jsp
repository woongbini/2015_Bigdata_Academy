<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>successDel.jsp</title>
	</head>
	<body>
		삭제 성공시 축하메세지 출력 <br><br><br>
		${sessionScope.name }
		<%--로그아웃버튼클릭하면 세션을 삭제한다고 가정
				링크를 클릭하면 controller에게 바로 요청전송된다고 가정
				메인으로 이동하기 링크 클릭시 index.html로 이동 --%>
		<a href = "../kodb?command=logout">로그아웃</a> <br>
		<a href = "<%=request.getContextPath() %>/kodb?command=logout">로그아웃</a> <br><br>
		<a href = "<%=request.getContextPath()%>/index.html">메인으로 리동</a> <br>
		
	</body>
</html>