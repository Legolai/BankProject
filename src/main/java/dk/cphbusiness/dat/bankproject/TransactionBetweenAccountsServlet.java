package dk.cphbusiness.dat.bankproject;

import domainObejcts.Account;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "TransactionBetweenAccountsServlet", value = "/TransactionBetweenAccountsServlet")
public class TransactionBetweenAccountsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        HttpSession session = request.getSession();
        String amountString = request.getParameter("amount");
        String msg = request.getParameter("msg");
        String receiveAccount = request.getParameter("receiveAccount").toLowerCase();
        log("The amount was: " + amountString);

        Map<String, Account> accountMap = (Map<String, Account>) servletContext.getAttribute("accounts");

        String error = "";
        try {
            int amount = Integer.parseInt(amountString);
            Account account = (Account) session.getAttribute("account");
            if (!account.isMayOverDraw() && 0 > account.calculateBalance() - amount) {
                error = "Your account may not be overdrawn!";
            }
            else if (accountMap.containsKey(receiveAccount)){
                account.withdraw(amount, msg);
                String receiveMsg = "Received from " + account.getName();
                accountMap.get(receiveAccount).deposit(amount, receiveMsg);
            }
            else {
                error = "The receiver does not exists";
            }
        } catch (NumberFormatException e){
            error = "The amount has to be a number!";
        }
        request.setAttribute("betweenAccountsError", error);
        request.getRequestDispatcher("WEB-INF/Account.jsp").forward(request, response);
    }
}
