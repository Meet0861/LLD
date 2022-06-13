package practice.implementaions.stackOverflow.models;

public class Admin extends Member{
    private Account account;

    public Admin(Account account) {
        super(account);
    }

    public boolean blockAccount(Account account){
        //TODO
        return true;
    }

    public boolean unBlockAccount(Account account){
        //TODO
        return true;
    }

}
