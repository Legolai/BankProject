package dk.cphbusiness.dat.bankproject;

import domainObejcts.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "TransactionServlet", value = "/TransactionServlet")
public class TransactionServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String amountString = request.getParameter("amount");
        String transactionType = request.getParameter("type").toLowerCase();
        log("The amount was: " + amountString);

        try {
            int amount = Integer.parseInt(amountString);
            Account account = (Account) session.getAttribute("account");
            if ("withdraw".equals(transactionType)) {account.withdraw(amount, "Withdraw");}
            else if ("deposit".equals(transactionType)) {account.deposit(amount, "Deposit");}

        } catch (NumberFormatException e){
            String error = "The amount has to be a number!";
            request.setAttribute("ownAccountError", error);
        }
        request.getRequestDispatcher("WEB-INF/Account.jsp").forward(request, response);
    }
}
