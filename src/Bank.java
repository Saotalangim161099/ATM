import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Random;

public class Bank {
    private String name;
    ArrayList<User> usersList;
    private ArrayList<Account> accountsList;

    // constructor with only name of the bank
    public Bank(String name) {
        this.name = name;
        usersList = new ArrayList<User>();
        accountsList = new ArrayList<Account>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<User> getUsersList() {
        return usersList;
    }

    public void setUsersList(ArrayList<User> usersList) {
        this.usersList = usersList;
    }

    public ArrayList<Account> getAccountsList() {
        return accountsList;
    }

    public void setAccountsList(ArrayList<Account> accountsList) {
        this.accountsList = accountsList;
    }

    // method to generate a random string of a given-length integer
    private String generateRandomString(int len) {
        Random random = new Random();
        String result = "";
        for (int i = 0; i < len; i++) {
            result += String.valueOf(random.nextInt(10));
        }
        return result;
    }

    // create a user ID with length of 6, and it must be unique
    // User ID includes 6 random characters
    public String getNewUserUUID() {
        int len = 6;
        String userUUID;
        do {
            userUUID = generateRandomString(len);
        }

        // stop the loop right when the UUID is unique
        while (!isUserUUIDUnique(userUUID));
        return userUUID;
    }

    // check whether the user ID is unique in the ID of users list
    private boolean isUserUUIDUnique(String userUUID) {
        for (User u : this.usersList) {
            if (userUUID.compareTo(u.getUUID()) == 0) {
                return false;
            }
        }
        return true;
    }

    // create an account ID with length of 10, and it must be unique
    // Account ID includes 10 random characters
    public String getNewAccountUUID() {
        int len = 10;
        Random random = new Random();
        String accountUUID;
        do {
            accountUUID = generateRandomString(len);
        }
        while (!isUserUUIDUnique(accountUUID));
        return accountUUID;
    }

    // check whether the user ID is unique, by traversing the users' ID list and compare
    // if compareTo method return 0, return false
    private boolean accountUUIDUnique(ArrayList<User> usersList, String accountUUID) {
        for (User u : usersList) {
            if (accountUUID.compareTo(u.getUUID()) == 0) {
                return false;
            }
        }
        return true;
    }


    // add account to accounts list
    public void addAccount(Account newAccount) {
        accountsList.add(newAccount);
    }

    // Method: Add new user to the bank. Return the newUser object
    public User addUser(String firstName, String lastName, String pin) throws NoSuchAlgorithmException {
        // create new User object
        User newUser = new User(firstName, lastName, pin, this);

        // add newUser object to the users list
        usersList.add(newUser);

        // create and add new account of the user to the bank
        Account newAccount = new Account("Savings", newUser, this);
        // add newAccount to the list of accounts
        addAccount(newAccount);

        newUser.addAccount(newAccount);

        return newUser;
    }

    // validate log in by validating UUID and pin. Return user if there is one user matching with the logged UUID and pin
    public User userLogIn(String givenUUID, String givenPin) throws NoSuchAlgorithmException {
        for (User user : this.usersList) {
            if (user.validateUUID(givenUUID) == true && user.validatePin(givenPin) == true) {
                return user;
            }
        }
        return null;
    }


}
