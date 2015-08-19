<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!-- jstl이라는 외부 tag lib사용한다는 선언 c:으로 시작되는 모든 tag는 jstl core tag라고 표기 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>successAll.jsp</title>
	</head>
	<body>
		요청하신 EMP테이블의 모든 정보 검색된 화면입니다 <br><br><br>
		
		<table border = "1" bgcolor = "gray">
			<c:forEach items = "${requestScope.allData }" var = "emp">
				<tr>
					<td> ${emp.empno } </td>
					<td> ${emp.ename } </td>
					<td> ${emp.job } </td>
					<td> ${emp.mgr } </td>
					<td> ${emp.hiredate } </td>
					<td> ${emp.sal } </td>
					<td> ${emp.comm } </td>
					<td> ${emp.deptno} </td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>