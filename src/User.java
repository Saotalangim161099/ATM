import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Random;

public class User {

    //    The first name of the user
    private String firstName;

    //    The last name of the user
    private String lastName;

    //    The ID number of the user
    private String uuid;

    //    The MD5 hash of the user's PIN
    // Do difference: We store PIN HASH, only get input for PIN from the user from the beginning ONLY!
    //private byte[] pinHash;
    private String pinHash;

    //    The list of accounts for this user
    private ArrayList<Account> accounts;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUUID() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }


    public String getPinHash() {
        return pinHash;
    }

    public void setPinHash(String pin) {
        this.pinHash = pin;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public User(String firstName, String lastName, String pin, Bank theBank) throws NoSuchAlgorithmException {
        this.firstName = firstName;
        this.lastName = lastName;

        /*store the pin's MD5 hash, rather than the original value, for security reasons
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            this.pinHash = md.digest(pin.getBytes());
        } catch (NoSuchAlgorithmException e) {
            System.err.println("ERROR, caught NoSuchAlgorithmException");
            e.printStackTrace();
            System.exit(1);
        }*/

        // convert pin into MD5 hashing
        this.pinHash = hashMD5Pin(pin);

        // get a new, unique universal ID for the user
        this.uuid = theBank.getNewUserUUID();

        // create empty list of accounts
        this.accounts = new ArrayList<>();

        // print log message
        System.out.printf("New user %s, %s with ID %s created.\n", lastName, firstName, this.uuid);
    }

    // Using Hashing function MessageDigest, we need to convert pin into MD5 Hash.
    private String hashMD5Pin(String pin) throws NoSuchAlgorithmException {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.reset();
            md.update(pin.getBytes());
            byte[] digest = md.digest();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < digest.length; ++i) {
                sb.append(Integer.toHexString((digest[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();

        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }

    // check if the givenPin is equal to the Pin of the user(the working user object), but there's only pinHash stored for user, so we need to convert the givenPin to pinHash first, and compare 2 pinHash.
    // Return true if givenPinHash is equal to the givenUser's pinHash. Otherwise, return false.
    public boolean validatePin(String givenPin) throws NoSuchAlgorithmException {

        // convert givenPin to pinHash using method hashMD5Pin()
        String givenPinHash = hashMD5Pin(givenPin);
        return givenPinHash.equals(this.getPinHash());
    }

    // check if the UUID is equal to the givenUUID
    // Return true if both UUID are equal. Otherwise, return false.
    public boolean validateUUID(String givenUUID) {
        return givenUUID.equals(this.getUUID());
    }

    public void addAccount(Account newAccount) {
        accounts.add(newAccount);
    }

    // print account summary

    public String generateRandomString(int len) {
        Random random = new Random();
        String result = "";
        for (int i = 0; i < len; i++) {
            result += String.valueOf(random.nextInt(10));
        }
        return result;
    }

    // print account summary
    public void printAccountsSummary() {
        System.out.printf("\n\n%s's accounts summary", this.getFirstName());
        for (int i = 0; i < this.accounts.size(); i++) {
            System.out.printf("%d) %s\n", i + 1, this.accounts.get(i).getSummaryLine());
        }
        System.out.println();
    }

    // get the number of accounts of the user
    public int numAccounts() {
        return this.accounts.size();
    }
}
