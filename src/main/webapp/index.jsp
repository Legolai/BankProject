<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Bank - Login</title>
    </head>
    <body>
        <form style="display: flex; flex-direction: column; width: 40%; margin: 0 auto" action="LoginServlet" method="post">
            <c:if test="${requestScope.errors != null}">
                <span>${requestScope.errors}</span>
            </c:if>
            <label for="username">Username: </label>
            <input name="username" id="username" type="text">
            <label for="password">Password: </label>
            <input name="password" id="password" type="password">
            <input type="submit" value="Login">
            <a href="CreateAccount">Create new account</a>
        </form>
    </body>
</html>