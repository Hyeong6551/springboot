<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
<title>hyeong's shops</title>
</head>
<body>
	<div>
	<jsp:include page="board/common/header.jsp" />
		<%-- Categories --%>
		<div class="categories my-5 p-5">
			<div class="small-container">
				<div class="row">
					<c:forEach items="${goods}" var="goods">
						<div class="col-3">
							<a href="goods/${goods.goods_no}">
								<img src="${goods.goods_image}>">
								<h6>${goods.goods_name}</h6>
								<p>${goods.goods_price}원</p>
							</a>
						</div>
					</c:forEach>
				</div>
			</div>
		</div> <%-- Categories end --%>
		<jsp:include page="board/common/footer.jsp" />
	</div>
</body>
</html>