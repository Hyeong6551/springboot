
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-sm navbar-dark bg-secondary">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">Main</a>
        <div class="collapse navbar-collapse" id="mynavbar">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link" href="javascript:void(0)">Link</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="javascript:void(0)">Link</a>
                </li>
                <c:choose>
                    <c:when test="${sessionScope.user == 'admin'}">
                        <li class="nav-item">
                            <a class="nav-link" href="/list">회원 관리</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item">
                            <a class="nav-link" href="javascript:void(0)">Link</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
            <c:choose>
                <c:when test="${not empty sessionScope.user}">
                    <form class="d-flex">
                        <p>${sessionScope.user}님 환영합니다!</p>
                        <a class="btn btn-primary" href="/logout">로그아웃</a>
                    </form>
                </c:when>
                <c:otherwise>
                    <form class="d-flex">
                        <a class="btn btn-warning" href="/login">로그인</a>
                        <a class="btn btn-primary" href="/register">회원가입</a>
                    </form>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</nav>
