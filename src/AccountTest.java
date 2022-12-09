import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void getName() {
    }

    @Test
    void setName() {
    }

    @Test
    void getBalance() {
    }

    @Test
    void setBalance() {
    }

    @Test
    void getUuid() {
    }

    @Test
    void setUuid() {
    }

    @Test
    void getHolder() {
    }

    @Test
    void setHolder() {
    }

    @Test
    void getTransactions() {
    }

    @Test
    void setTransactions() {
    }

    @Test
    void getSummaryLine() throws NoSuchAlgorithmException {
        Bank amex = new Bank("amex");
        User phuc = new User("Phuc", "Nguyen", "161099", amex);
        Account phucAccount = new Account("Savings", phuc, amex);
        assertEquals(phucAccount.getUuid() + " : $" + String.format("%.02f", phucAccount.getBalance()) + " : Savings", phucAccount.getSummaryLine());

    }
}