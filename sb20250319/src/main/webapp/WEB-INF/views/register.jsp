<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원가입 폼</title>
    <link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page="header.jsp" />

<form:form action="/register" method="post" modelAttribute="userDto">
  <div class="container">
    <h1>회원가입</h1>
    <p>Please fill in this form to create an account.</p>
    <hr>

    <label for="id"><b>아이디</b></label><br>
    <form:errors path="id" cssClass="errorMsg"/>
    <form:input path="id" placeholder="아이디를 입력해주세요" name="id" id="id" />

    <label for="password"><b>비밀번호</b></label><br>
    <form:errors path="password" cssClass="errorMsg"/>
    <form:password path="password" placeholder="비밀번호를 입력해주세요" name="password" id="password"/>

    <label for="name"><b>이름</b></label><br>
    <form:errors path="name" cssClass="errorMsg"/>
    <form:input path="name" placeholder="아이디를 입력해주세요" name="name" id="name" />

    <label for="email"><b>이메일</b></label>
    <form:input path="email" placeholder="이메일을 입력해주세요" name="email" id="email" />

    <hr>
    <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>

    <button type="submit" class="registerbtn">Register</button>
  </div>

  <div class="container signin">
    <p>Already have an account? <a href="/login">Sign in</a>.</p>
  </div>
</form:form>

<jsp:include page="footer.jsp" />
</body>
</html>
