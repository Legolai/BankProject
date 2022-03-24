package dk.cphbusiness.dat.bankproject;

import domainObejcts.Account;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Map<String, Account> accountMap = (Map<String, Account>) getServletContext().getAttribute("accounts");

        Account account = accountMap.getOrDefault(username.toLowerCase(), null);

        String errorMsg;

        if (account == null || !account.getCode().equals(password)) {
            errorMsg = "Username or Password was incorrect!";
            request.setAttribute("errors", errorMsg);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("name", account.getName());
        httpSession.setAttribute("account", account);


        request.getRequestDispatcher("WEB-INF/Account.jsp").forward(request, response);
    }
}
