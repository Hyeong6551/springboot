<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="header.jsp" />
    <div class="container mt-5">
        <h2 class="mb-4">사용자 목록</h2>
        <a href="<c:url value='/users/new'/>" class="btn btn-primary mb-3">새 사용자 등록</a>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>ID</th>
                <th>이름</th>
                <th>이메일</th>
                <th>전화번호</th>
                <th>작업</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${user}" var="user">
                <tr>
                    <td>${user.no}</td>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.email}</td>
                    <td>
                        <a href="<c:url value='/list/edit/${user.no}'/>" class="btn btn-sm btn-warning">수정</a>
                        <a href="<c:url value='/list/delete/${user.no}'/>"
                           class="btn btn-sm btn-danger"
                           onclick="return confirm('정말 삭제하시겠습니까?')">삭제</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    <script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
    <script src="/webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
</div>

<jsp:include page="footer.jsp" />