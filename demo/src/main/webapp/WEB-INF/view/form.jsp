<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/hello" method="get">
    <input type="text" name="name" placeholder="이름 입력">
    <button type="submit">전송</button>
</form>
</body>
</html>