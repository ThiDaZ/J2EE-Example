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
    <title>Login</title>
</head>
<body>
<h1>Login</h1>
<form action="${pageContext.request.contextPath}/login" method="post">
    <table>
        <tr>
            <th>Email</th>
            <td><input type="text" name="email"></td>
        </tr>
        <tr>
            <th>Password</th>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Login"></td>
        </tr>
    </table>
</form>
</body>
</html>
