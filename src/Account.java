import java.util.ArrayList;

public class Account {
    //  the name of the account
    private String name;

    //    the current balance of the account
    private double balance;

    //    the account ID number
    private String uuid;

    //    the user object that owns this account
    private User holder;

    //    the list of transactions for this account
    private ArrayList<Transaction> transactions;

    public Account(String name, User holder, Bank theBank) {
        this.name = name;
        this.holder = holder;

        this.uuid = theBank.getNewAccountUUID();

        // add to holder and bank lists
        holder.addAccount(this);
        theBank.addAccount(this);
    }

    // Method: User login
    // Validate the user's UUID and pin
}
