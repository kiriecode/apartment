package Po;

public class Operation {
    private int operation_id, type, payment_account;
    private String account_id, date;

    @Override
    public String toString() {
        return "operation{" +
                "operation_id=" + operation_id +
                ", type=" + type +
                ", payment_account=" + payment_account +
                ", account_id='" + account_id + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public int getOperation_id() {
        return operation_id;
    }

    public void setOperation_id(int operation_id) {
        this.operation_id = operation_id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getPayment_account() {
        return payment_account;
    }

    public void setPayment_account(int payment_account) {
        this.payment_account = payment_account;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
