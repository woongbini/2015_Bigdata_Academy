<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>successDel.jsp</title>
	</head>
	<body>
		���� ������ ���ϸ޼��� ��� <br><br><br>
		${sessionScope.name }
		<%--�α׾ƿ���ưŬ���ϸ� ������ �����Ѵٰ� ����
				��ũ�� Ŭ���ϸ� controller���� �ٷ� ��û���۵ȴٰ� ����
				�������� �̵��ϱ� ��ũ Ŭ���� index.html�� �̵� --%>
		<a href = "../kodb?command=logout">�α׾ƿ�</a> <br>
		<a href = "<%=request.getContextPath() %>/kodb?command=logout">�α׾ƿ�</a> <br><br>
		<a href = "<%=request.getContextPath()%>/index.html">�������� ����</a> <br>
		
	</body>
</html>