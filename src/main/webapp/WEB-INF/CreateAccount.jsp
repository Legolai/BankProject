<%--
  Created by IntelliJ IDEA.
  User: macnp
  Date: 24/03/2022
  Time: 09.20
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="CreateAccount" method="post" style="display: flex; flex-direction: column; width: clamp(200px, 50%, 800px); margin: 0 auto">
        <c:if test="${requestScope.error != null}">
            <span style="color: red">${requestScope.error}</span>
        </c:if>
        <label for="username">Username: </label>
        <input type="text" id="username" name="username" required>
        <label for="email">E-mail: </label>
        <input type="email" id="email" name="email" required>
        <label for="password">Password: </label>
        <input type="password" id="password" name="password" required>
        <label for="repassword">Repeat password: </label>
        <input type="password" id="repassword" name="repassword" required>
        <input type="submit" value="Create Account">
        <a href="../index.jsp">Login</a>
    </form>

</body>
</html>
