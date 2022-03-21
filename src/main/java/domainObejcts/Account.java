package domainObejcts;

public class Account {
    private String name;
    private String code;
    private int balance;
    private boolean mayOverDraw;

    public Account(String name, String code, int balance, boolean mayOverDraw) {
        this.name = name;
        this.code = code;
        this.balance = balance;
        this.mayOverDraw = mayOverDraw;
    }

    public String getCode() {
        return code;
    }
    public int getBalance() {
        return balance;
    }
    public String getName() {
        return name;
    }
    public void setMayOverDraw(boolean mayOverDraw) {
        this.mayOverDraw = mayOverDraw;
    }

    public int deposit(int amount) {
        if (amount > 0){
            balance += amount;
        }
        return balance;
    }

    public int withdraw(int amount) {
        if (amount > 0 && (balance - amount > 0 || mayOverDraw)){
            balance -= amount;
        }
        return balance;
    }


}
