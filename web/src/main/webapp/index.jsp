<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: thidas
  Date: 12/07/2025
  Time: 23:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>Home</h1>
<c:if test="${empty pageContext.request.userPrincipal}">
    <a href="${pageContext.request.contextPath}/register.jsp">Register</a>
    <a href="${pageContext.request.contextPath}/login.jsp">Login</a>

    <h1>Hello, ${pageContext.request.userPrincipal.name}</h1>
</c:if>
<c:if test="${not empty pageContext.request.userPrincipal}">
    <a href="${pageContext.request.contextPath}/logout">Logout</a>

</c:if>
</body>
</html>
