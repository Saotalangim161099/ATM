import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class ATM {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        // init Scanner
        Scanner scanner = new Scanner(System.in);

        // init Bank
        Bank amex = new Bank("amex");

        // add a user, which also creates a savings account
        User phuc = new User("Phuc", "Nguyen", "161099", amex);

        // add a checking account for the user
        Account newAccount = new Account("Checking", phuc, amex);
        phuc.addAccount(newAccount);
        amex.addAccount(newAccount);

        User currUser;
        while (true) {

            // stay in the login prompt until successful login
            currUser = ATM.mainMenuPrompt(amex, scanner);

            // stay in the main menu until user quits
            ATM.printUserMenu(currUser, scanner);

        }

    }

    public static void printUserMenu(User theUser, Scanner scanner) {

        // print a summary of the user's accounts
        theUser.printAccountSummary();

        // init choice
        int choice;

        // user menu
        do {
            System.out.printf("Welcome %s, what would you like to do?", theUser.getFirstName());
            System.out.println("1. Show account transaction history.");
            System.out.println("2. Withdraw.");
            System.out.println("3. Deposit.");
            System.out.println("4. Transfer.");
            System.out.println("5. Quit.");
            System.out.println();
            System.out.println("Enter choice: ");
            choice = scanner.nextInt();

            if (choice < 1 || choice > 5) {
                System.out.println("Invalid choice. Please choose 1-5.");
            }
        } while (choice < 1 || choice > 5);

        // process the choice
        switch (choice) {
            case 1:
                ATM.showTransHistory(theUser, sc);
                break;
            case 2:
                ATM.withdrawFunds(theUser, sc);
                break;
            case 3:
                ATM.depositFunds(theUser, sc);
                break;
            case 4:
                ATM.transferFunds(theUser, sc);
                break;
        }

        // redisplay this menu unless the user wants to quit
        if (choice != 5) {
            ATM.printUserMenu(theUser, scanner);
        }

    }

    public static User mainMenuPrompt(Bank theBank, Scanner scanner) throws NoSuchAlgorithmException {

        // inits
        String userID;
        String pin;
        User authUser;

        // prompt the user for user ID/ Pin combo until a correct one is reached
        do {
            System.out.printf("\n\nWelcome to %s\n\n", theBank.getName());
            System.out.println("Enter user ID: ");
            userID = scanner.nextLine();

            System.out.println("Enter pin: ");
            pin = scanner.nextLine();

            // try to get the user object corresponding to the ID and pin combo
            authUser = theBank.userLogIn(userID, pin);
            if (authUser == null) {
                System.out.println("Incorrect user ID/pin combination."
                        + "Please try again.");
            }
        } while (authUser == null); // continue looping until successful login

        return authUser;
    }

    public static void showTransHistory(User theUser, Scanner scanner){
        int theAccount;

        // get acc
    }
}
