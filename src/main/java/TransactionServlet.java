import domainObejcts.Account;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TransactionServlet", value = "/TransactionServlet")
public class TransactionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String depositvalue = request.getParameter("depositvalue");
        String withdrawvalue = request.getParameter("withdrawvalue");
        boolean deposit = false;
        int amount = 0;
        try {
            if (withdrawvalue == null) {
                amount = Integer.parseInt(depositvalue);
                deposit = true;
            } else {
                amount = Integer.parseInt(withdrawvalue);
            }

        } catch (NumberFormatException e) {
            String error = "amount needs to be a number";
            request.setAttribute("error",error);
            request.getRequestDispatcher("WEB-INF/UserPage.jsp").forward(request,response);
        }

        HttpSession session = request.getSession();

        Account account = (Account) session.getAttribute("account");
        if (deposit) {
            account.deposit(amount);
        } else {
            account.withdraw(amount);
        }
        session.setAttribute("account",account);
        request.getRequestDispatcher("WEB-INF/UserPage.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
