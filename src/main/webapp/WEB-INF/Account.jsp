<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: macnp
  Date: 21/03/2022
  Time: 20.28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Bank - Account</title>
  </head>
  <body>
    <h1>Welcome ${sessionScope.name} to your account</h1>
    <a href="LogoutServlet">Log out</a>
    <h3>Your balance is ${sessionScope.account.calculateBalance()}</h3>

    <form style="display: flex; flex-direction: column; width: 40%" action="TransactionServlet" method="post">
      <c:if test='${requestScope.ownAccountError != null}'>
        <span>${requestScope.ownAccountError}</span>
      </c:if>
      <label for="amount">Please give an amount: </label>
      <input name="amount" id="amount" type="text" value="0">
      <input type="submit" name="type" value="Deposit">
      <input type="submit" name="type" value="Withdraw">
    </form>

    <form style="display: flex; flex-direction: column; width: 40%" action="TransactionBetweenAccountsServlet" method="post">
      <c:if test='${!requestScope.betweenAccountsError.equals("")}'>
        <span>${requestScope.betweenAccountsError}</span>
      </c:if>
      <label for="amount">Please give an amount: </label>
      <input name="amount" id="amount" type="text" value="0" required>
      <label for="msg">Message: </label>
      <input name="msg" id="msg" type="text" maxlength="120" value="">
      <label for="receiver">Receiver: </label>
      <input name="receiveAccount" id="receiver" type="text" required>
      <input type="submit" value="Do Transaction">
    </form>

    <h3>Transaction History</h3>
    <c:forEach items="${sessionScope.account.getTransactions()}" var="transaction">
      <div style="display: flex; border-bottom: gray 1px solid; justify-content: space-between; max-width: 30%">
        <p>${transaction.getMsg()}</p>
        <p>${transaction.getAmount()} kr.</p>
        <p>${transaction.getCreatedDate()}</p>
      </div>
    </c:forEach>
    <c:if test='${!requestScope.deleteAccountError.equals("")}'>
      <span>${requestScope.deleteAccountError}</span>
    </c:if>
    <button onclick="deleteAccount()" >Delete account</button>
  </body>
  <script>
    deleteAccount = () =>{
      if (confirm('Are you sure you want to delete the account?') === true){
        location.replace("DeleteAccountServlet");
      }
    }
  </script>
</html>
