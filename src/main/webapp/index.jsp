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
        ${requestScope.msg}
        <br/>
        <c:forEach items="${applicationScope.accounts}" var="item">
            ${item.value.name} : ${item.value.balance} <br/>
        </c:forEach>
    </body>
</html>