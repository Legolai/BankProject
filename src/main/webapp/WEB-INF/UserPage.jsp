<%--
  Created by IntelliJ IDEA.
  User: bruger
  Date: 3/22/2022
  Time: 10:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserPage</title>
</head>
<body>

    <h1>Velkommen ${sessionScope.navn} Du er nu logget ind paa din konto</h1>
    <br><br>
    <h1>Din saldo er ${sessionScope.account.balance}</h1>

    <a href="LogoutServlet">Log af og gaa til index</a>

    <br><br><br>
    <h2>Deposit</h2>        <!-- depositing money -->
    <form action="TransactionServlet">
        <label for="depositvalue">Amount to deposit:</label>
        <input type="text" id="depositvalue" name="depositvalue" value=0><br><br>
        <input type="submit" value="deposit">
    </form>

    <br><br><br>
    <h2>Withdraw</h2>        <!-- withdrawing money -->
    <form action="TransactionServlet">
        <label for="withdrawvalue">Amount to withdraw:</label>
        <input type="text" id="withdrawvalue" name="withdrawvalue" value=0><br><br>
        <input type="submit" value="withdraw">
    </form>

</body>
</html>
