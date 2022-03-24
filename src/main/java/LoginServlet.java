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
        String navn = request.getParameter("navn");
        String password = request.getParameter("pass");

        //System.out.println("navn is: "+navn+" and password is: "+password);

        Map<String, Account> kontoMap = (Map<String, Account>) getServletContext().getAttribute("accounts");
        // accounts are in lowercase name despite what it is in helloservlet

        Account account = kontoMap.getOrDefault(navn, null);

        String errormsg;
        if (account == null) {
            System.out.println("inside account not found");
            errormsg = "Account not found";
            request.setAttribute("error",errormsg);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
        if (!account.getCode().equals(password)) {
            System.out.println("inside wrong password");
            errormsg = "Wrong password or username";
            request.setAttribute("error",errormsg);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }

        HttpSession session = request.getSession();

        session.setAttribute("navn",navn);
        session.setAttribute("account",account);

        request.getRequestDispatcher("WEB-INF/UserPage.jsp").forward(request,response);

    }
}
