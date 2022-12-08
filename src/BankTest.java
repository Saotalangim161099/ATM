import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    @org.junit.jupiter.api.Test
    void getNewUserUUID() {
        Bank amex = new Bank("AMEX");
        for (int i = 0; i < 1000; i++) {
            System.out.println("User ID: " + amex.getNewUserUUID());
        }
    }

    @org.junit.jupiter.api.Test
    void getNewAccountUUID() {
    }

    @org.junit.jupiter.api.Test
    void addAccount() {
    }

    @org.junit.jupiter.api.Test
    void addUser() {
    }
}