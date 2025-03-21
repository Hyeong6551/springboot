<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../header.jsp" />
<div class="container mt-5">
    <h2 class="mb-4">게시판</h2>
    <div class="text-end mb-3">
        <a href="/board/write" class="btn btn-primary">글쓰기</a>
    </div>
    <div class="card">
        <div class="card-body">
            <table class="table table-hover">
                <thead class="table-light">
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>작성일</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${boards}" var="board">
                    <tr>
                        <td>${board.id}</td>
                        <td><a href="/board/${board.id}" class="text-decoration-none">${board.title}</a></td>
                        <td>${board.author}</td>
                        <td><fmt:formatDate value="${board.createdAt}" pattern="yyyy-MM-dd HH:mm"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<jsp:include page="../footer.jsp" />