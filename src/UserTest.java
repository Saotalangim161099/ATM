import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void validatePinWithRandomPin() throws NoSuchAlgorithmException {
        Bank amex = new Bank("amex");
        User phuc = new User("Phuc", "Nguyen", "161099", amex);
        for (int i = 0; i < 1000; i++) {
            String givenPin = phuc.generateRandomString(6);
            assertEquals(false, phuc.validatePin(givenPin));
        }
    }

    @Test
    void validatePincorrect() throws NoSuchAlgorithmException {
        Bank amex = new Bank("amex");
        User phuc = new User("Phuc", "Nguyen", "161099", amex);
        assertEquals(true, phuc.validatePin("161099"));

    }

    @Test
    void validateUUIDWithRandomUUID() throws NoSuchAlgorithmException {
        Bank amex = new Bank("amex");
        User phuc = new User("Phuc", "Nguyen", "161099", amex);
        for (int i = 0; i < 1000; i++) {
            String givenUUID = phuc.generateRandomString(6);
            assertEquals(false, phuc.validateUUID(givenUUID));
        }
    }
}