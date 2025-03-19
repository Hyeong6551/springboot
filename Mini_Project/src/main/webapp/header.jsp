<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<%
	String user_id = (String)session.getAttribute("user_id");
%>
	<%-- Header --%>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container px-4 px-lg-5">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">Hyeong's shop</a>
            <div class="collapse navbar-collapse">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                    <li class="nav-item"><a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/cart/cartForm.jsp">장바구니</a></li>
                    <li class="nav-item"><a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/order/orderList.jsp">주문목록</a></li>
                    <%
                    // 트러블 슈팅 user_id.equals("admin") 으로 하니 안되고 
                    // 아래와 같이 코드를 바꾸니까 실행됨
                    if("admin".equals(user_id)){
                    	%>
                    	   <li class="nav-item"><a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/goods/goodsList.jsp">상품추가</a></li>
                    	<%
                    } else {}
                    %>
                </ul>
                <%
            	if(user_id == null){
            	%>
     	        <form class="d-flex ">
                    <a class="btn btn-outline-dark ms-2"  href="${pageContext.request.contextPath}/login/loginForm.jsp">로그인</a>
                    <a class="btn btn-outline-dark ms-2"  href="${pageContext.request.contextPath}/login/registerForm.jsp">회원가입</a>
                </form>
            	<%
            	} else {
            		%>
            	<form class="d-flex align-items-center">
            		<p class="mx-2 mb-0"><a href="${pageContext.request.contextPath}/users/userForm.jsp"><%=user_id %></a>님 환영합니다!</p>
            		<a class="btn btn-outline-danger ms-2"  href="${pageContext.request.contextPath}/login/logout.jsp">로그아웃</a>
       		    </form>
            		<%
            	}
                %>
            </div>
        </div>
    </nav>
 <%-- Header end --%>
</body>
</html>