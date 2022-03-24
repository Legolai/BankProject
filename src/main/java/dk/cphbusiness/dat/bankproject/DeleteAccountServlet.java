package dk.cphbusiness.dat.bankproject;

import domainObejcts.Account;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "DeleteAccountServlet", value = "/DeleteAccountServlet")
public class DeleteAccountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        if(account == null){
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        String error = "";
        int balance = account.calculateBalance();
        if( balance > 0){
            error = "You must empty your account to close it!";
        } else if (balance < 0){
            error = "You must pay of your debt to close the account!";
        }
        else {
            ServletContext servletContext = getServletContext();
            Map<String, Account> accountMap = (Map<String, Account>) servletContext.getAttribute("accounts");
            accountMap.remove(account.getName().toLowerCase());
            request.getRequestDispatcher("LogoutServlet").forward(request, response);
        }
        request.setAttribute("deleteAccountError", error);
        request.getRequestDispatcher("WEB-INF/Account.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
