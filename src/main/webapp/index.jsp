<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP - Hello World</title>
    </head>
    <body>
        <h1><%= "Hello World!" %>
        </h1>
        <br/>
        <a href="hello-servlet">Hello Servlet</a>
        <br/><br/>
        ${requestScope.msg}
        <br/><br/>
        <c:forEach items="${applicationScope.accounts}" var="item">
            ${item.value.name} : ${item.value.balance}
            <br/>
        </c:forEach>

        <br><br><br>
        <form action="LoginServlet" method="post">
            <label for="navn">Kontonavn:</label>
            <input type="text" id="navn" name="navn"><br><br>
            <label for="pass">Password:</label>
            <input type="text" id="pass" name="pass"><br><br>
            <input type="submit" value="Log in">
        </form>
        <br><br>
        ${requestScope.error}

    </body>
</html>