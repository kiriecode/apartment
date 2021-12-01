package Po;

public class register {
    private int identity;
    private String account, password;

    @Override
    public String toString() {
        return "register{" +
                "identity=" + identity +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public int getIdentity() {
        return identity;
    }

    public void setIdentity(int identity) {
        this.identity = identity;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
