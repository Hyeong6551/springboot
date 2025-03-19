<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/logRg.css" type="text/css">
</head>
<body>
<jsp:include page="../common/header.jsp"/>
	<div class="register-container my-5">
		<p>회원가입이 완료되었습니다</p><br>	
		<a href="loginForm" class="btn btn-secondary">로그인 화면으로 이동</a>
	</div>
<jsp:include page="../common/footer.jsp" />
</body>
</html>