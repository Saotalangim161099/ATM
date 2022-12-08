import java.util.Random;

public class BankMain {
    public static void main(String[] args) {

        Bank amex = new Bank("AMEX");

        /* print out 1000 user ID
        for (int i = 0; i < 1000; i++) {
            System.out.println("User ID: " + amex.getNewUserUUID());
        }*/

        // print out 1000 account ID
        for (int i = 0; i < 1000; i++) {
            System.out.println("Account ID: " + amex.getNewAccountUUID());
        }

        /* Test create an ID with length of 7 by creating 7 random numbers, convert each to string and concatenate them to create a string of length 7
        Random random = new Random();
        String UUID = "";
        for (int i = 0; i < 7; i++) {
            int randomInteger = random.nextInt(10);
            System.out.println("Random integer: " + randomInteger);
            UUID += String.valueOf(randomInteger);
        }
        System.out.println("UUID of User: " + UUID);
        //}*/
    }
}
