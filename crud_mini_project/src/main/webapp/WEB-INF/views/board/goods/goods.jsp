<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${goods.goods_name} 상품 페이지</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
<script>
	function loginPage(){
		alert("로그인 후에 이용 가능합니다");
		location.href="../login/loginForm.jsp";
	}
</script>
</head>
<body>
	<div>
	<jsp:include page="${pageContext.request.contextPath}/common/header.jsp" />
		<form action="../cart/cart_Process.jsp">
	        <section class="py-5">
	            <div class="container px-4 px-lg-5 my-5">
	                <div class="row gx-4 gx-lg-5 align-items-center">
	                    <div class="col-md-6">
	                    	<img class="card-img-top mb-5 mb-md-0" src="../${goods.goods_image}" alt="..." /></div>
	                    <div class="col-md-6">
                   	        <input type="hidden" name="cart_goods_no" value="${goods.goods_no}"/>
                            <div class="small mb-1">상품번호 : ${goods.goods_no}</div>
	                        <h1 class="display-5 fw-bolder">${goods.goods_name} </h1>
	                        <div class="fs-5 mb-5">
	                            <span>${goods.goods_price}원</span>
	                        </div>
	                        <div class="small mb-1">
	                        	<p class="lead">${goods.goods_content}</p>
	                        </div>
	                        <div class="d-flex">
  	                            <input class="form-control text-center me-3" name="cart_goods_quantity" type="num" min="1" value="1" style="max-width: 3rem" />
  	    <%	
			String loginCheck = (String) session.getAttribute("user_id");
			if(loginCheck == null){
		%>
	                            <a class="btn btn-outline-dark flex-shrink-0" href="../login/loginForm.jsp" onclick="loginPage()">장바구니에 추가</a>
	    <%
			} else {
		%> 
       	                        <input class="btn btn-outline-dark flex-shrink-0" type="submit" value="장바구니에 추가"/>
	    <%
			}
	    %>
	                        </div>



	                    </div>

	                </div>
	            </div>
	        </section>
        </form>

		<jsp:include page="${pageContext.request.contextPath}/common/footer.jsp" />
	</div>
</body>
</html>