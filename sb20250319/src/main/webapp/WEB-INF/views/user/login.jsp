<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인 폼</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page="${pageContext.request.contextPath}/header.jsp" />
<form:form action="/login" method="post" modelAttribute="userDto">
    <div class="container my-5">
        <label for="id"><b>아이디</b></label>
        <form:input path="id" placeholder="아이디를 입력해주세요" name="id" id="id" />

        <label for="password"><b>비밀번호</b></label>
        <form:password path="password" placeholder="비밀번호를 입력해주세요" name="password" id="password" />

        <button type="submit" class="btn btn-primary">로그인</button>
        <p>계정이 없으신가요?<a href="/register">계정 생성</a>.</p>
    </div>
</form:form>
<jsp:include page="${pageContext.request.contextPath}/footer.jsp" />
</body>
</html>
