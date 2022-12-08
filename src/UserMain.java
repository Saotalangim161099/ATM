import java.security.NoSuchAlgorithmException;

public class UserMain {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        // create Bank Object for AMEX
        Bank amex = new Bank("AMEX");
        User phuc = new User("Phuc", "Nguyen", "161099", amex);

    }
}
