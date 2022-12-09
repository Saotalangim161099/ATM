import java.util.Date;

public class Transaction {
    // the amount of the transaction
    private double amount;

    // the time and date of the transaction
    private Date timestamp;

    // a memo for the transaction
    private String memo;

    // the account in which the transaction was performed
    private Account inAccount;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Account getInAccount() {
        return inAccount;
    }

    public void setInAccount(Account inAccount) {
        this.inAccount = inAccount;
    }
}
