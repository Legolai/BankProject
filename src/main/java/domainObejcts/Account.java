package domainObejcts;

import java.util.ArrayList;

public class Account {
    private String name;
    private String code;
    private int balance;
    private boolean mayOverDraw;
    private ArrayList<Integer> transactions;

    public Account(String name, String code, int balance, boolean mayOverDraw) {
        this.name = name;
        this.code = code;
        this.balance = balance;
        this.mayOverDraw = mayOverDraw;
        transactions = new ArrayList<>();
        addTransaction(balance);
    }

    public String getName() {
        return name;
    }
    public String getCode() {
        return code;
    }
    public int getBalance() {
        return balance;
    }
    public ArrayList<Integer> getTransactions() {
        return transactions;
    }
    public void setMayOverDraw(boolean mayOverDraw) {
        this.mayOverDraw = mayOverDraw;
    }

    public int deposit(int amount) {
        if (amount > 0){
            balance += amount;
            addTransaction(amount);
        }
        return balance;
    }

    public int withdraw(int amount) {
        if (amount > 0 && (balance - amount > 0 || mayOverDraw)){
            balance -= amount;
            addTransaction(-amount);
        }
        return balance;
    }

    public void addTransaction(int amount) {
        transactions.add(amount);
    }


}
