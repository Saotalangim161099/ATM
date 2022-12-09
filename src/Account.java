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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public User getHolder() {
        return holder;
    }

    public void setHolder(User holder) {
        this.holder = holder;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Account(String name, User holder, Bank theBank) {
        this.name = name;
        this.holder = holder;

        this.uuid = theBank.getNewAccountUUID();

        // add to holder and bank lists
        holder.addAccount(this);
        theBank.addAccount(this);
    }

    // return the summary of the account including UUID, balance, name of account
    public String getSummaryLine() {
        double balance = this.getBalance();
        if (balance >= 0) {
            return String.format("%s : $%.02f : %s", this.getUuid(), balance, this.getName());
        } else {
            return String.format("%s : $(%.02f) : %s", this.getUuid(), balance, this.getName());

        }
    }


    // get the balance of this account by adding the amounts of the transactions
    public double getBalance() {
        double balance = 0;
        for (Transaction t : this.getTransactions()) {
            balance += t.getAmount();
        }
        return balance;
    }
}
