package domainObejcts;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Account {
    private final String name;
    private String email;
    private String code;
    private List<Transaction> transactions;
    private int transactionPointer;
    private boolean mayOverDraw;

    public Account(String name, String code, int balance, boolean mayOverDraw) {
        this.name = name;
        this.code = code;
        this.mayOverDraw = mayOverDraw;
        this.transactions = new ArrayList<>();
        this.transactionPointer = 0;
        deposit(balance, "Deposited at creation");
    }

    public Account(String name, String email, String code) {
        this.name = name;
        this.email = email;
        this.code = code;
        this.transactions = new ArrayList<>();
        this.transactionPointer = 0;
        this.mayOverDraw = false;
    }

    public String getCode() {
        return code;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public List<Transaction> getTransactions() {return transactions;}
    public void setMayOverDraw(boolean mayOverDraw) {
        this.mayOverDraw = mayOverDraw;
    }

    public boolean isMayOverDraw() {
        return mayOverDraw;
    }

    public int deposit(int amount) {
        if (amount > 0){
            transactions.add(new Transaction("", (sum) -> sum + amount));
            transactionPointer++;
        }
        return calculateBalance();
    }

    public int deposit(int amount, String msg) {
        if (amount > 0){
            transactions.add(new Transaction(msg, (sum) -> sum + amount));
            transactionPointer++;
        }
        return calculateBalance();
    }

    public int withdraw(int amount) {
        if (amount > 0 && (calculateBalance() - amount > 0 || mayOverDraw)){
            transactions.add(new Transaction( "", (sum) -> sum - amount));
            transactionPointer++;
        }
        return calculateBalance();
    }

    public int withdraw(int amount, String msg) {
        if (amount > 0 && (calculateBalance() - amount > 0 || mayOverDraw)){
            transactions.add(new Transaction(msg, (sum) -> sum - amount));
            transactionPointer++;
        }
        return calculateBalance();
    }

    public int calculateBalance(){
        int sum = 0;
        for (Transaction transaction : transactions) {
            sum = transaction.doTransaction(sum);
        }
        return sum;
    }


}
