package domainObejcts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account("Nik", "1", 1000, false);
    }

    @Test
    void deposit() {
        assertEquals(1100, account.deposit(100));
    }

    @Test
    void depositNeagtiveAmount() {
        assertEquals(1000, account.deposit(-100));
    }

    @Test
    void withdraw() {
        assertEquals(900, account.withdraw(100));
    }

    @Test
    void withdrawNeagtiveAmount() {
        assertEquals(1000, account.withdraw(-100));
    }

    @Test
    void withdrawOverBalance() {
        assertEquals(1000, account.withdraw(1100));
        account.setMayOverDraw(true);
        assertEquals(-100, account.withdraw(1100));
    }


}