package domainObejcts;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.function.Function;

public class Transaction {
    private final String msg;
    private final Function<Integer, Integer> action;
    private final Instant createdDate;

    public Transaction(String msg, Function<Integer, Integer> action) {
        this.msg = msg;
        this.action = action;
        this.createdDate = Instant.now();
    }

    public int getAmount() {
        return doTransaction(0);
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public String getMsg() {
        return msg;
    }

    public Integer doTransaction(int sum) {
        return action.apply(sum);
    }
}
