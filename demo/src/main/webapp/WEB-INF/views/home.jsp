<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>

<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.5.2/sketchy/bootstrap.min.css" rel="stylesheet"> 
  
	<title>Home</title>
</head>
<body>





<c:choose>
<c:when test="${not empty sessionScope.loginId }">
<a>${sessionScope.loginId } 님 환영합니다. </a><br>

<a href="member/logout">로그아웃</a>
</c:when>
<c:otherwise>

<a href="member/countryCheck">Join</a>
<a href="member/loginForm">Login</a>
</c:otherwise>
</c:choose>

</body>
</html>
