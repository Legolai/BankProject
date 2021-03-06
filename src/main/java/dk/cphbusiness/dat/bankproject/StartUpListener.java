package dk.cphbusiness.dat.bankproject;

import domainObejcts.Account;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.HashMap;
import java.util.Map;

@WebListener
public class StartUpListener implements ServletContextListener{
    private Map<String, Account> accounts = new HashMap<>();

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /* This method is called when the servlet context is initialized(when the Web application is deployed). */
        Account account1 = new Account("Nicolai", "1", 150, false);
        Account account2 = new Account("Denis", "1", 15, true);
        Account account3 = new Account("Betül", "1", 170, false);
        Account account4 = new Account("Long", "1", 15, true);
        Account account5 = new Account("Kristoffer", "1", 1500, false);
        Account account6 = new Account("Søren", "1", 2157, false);

        accounts.put(account1.getName().toLowerCase(), account1);
        accounts.put(account2.getName().toLowerCase(), account2);
        accounts.put(account3.getName().toLowerCase(), account3);
        accounts.put(account4.getName().toLowerCase(), account4);
        accounts.put(account5.getName().toLowerCase(), account5);
        accounts.put(account6.getName().toLowerCase(), account6);

        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("accounts", accounts);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
    }
}
