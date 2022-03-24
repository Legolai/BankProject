package dk.cphbusiness.dat.bankproject;

import domainObejcts.Account;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "CreateAccountServlet", value = "/CreateAccount")
public class CreateAccountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/CreateAccount.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        Map<String, Account> accountMap = (Map<String, Account>) servletContext.getAttribute("accounts");

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");

        String error = "";
        if (accountMap.containsKey(username.toLowerCase())) {
            error = "Account already exists!";
        } else if (accountMap.values().stream().anyMatch(account -> email.equalsIgnoreCase(account.getEmail()))) {
            error = "Email is already in use!";
        } else if (!password.equals(repassword)) {
            error = "Repeated password does not match!";
        }
        else {
            Account newAccount = new Account(username, email, password);
            accountMap.put(newAccount.getName().toLowerCase(), newAccount);
            HttpSession session = request.getSession();
            session.setAttribute("account", accountMap.get(username.toLowerCase()));
            request.getRequestDispatcher("WEB-INF/Account.jsp").forward(request, response);
        }

        request.setAttribute("error", error);
        request.getRequestDispatcher("WEB-INF/CreateAccount.jsp").forward(request, response);
    }
}
