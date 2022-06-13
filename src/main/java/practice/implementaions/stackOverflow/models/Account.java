package practice.implementaions.stackOverflow.models;

import practice.implementaions.stackOverflow.enums.AccountStatus;

public class Account {
    private int id;
    private AccountStatus status;
    private String emailId;
    private String password;
    private String contact;

    public Account(int id, AccountStatus status, String emailId, String password, String contact) {
        this.id = id;
        this.status = status;
        this.emailId = emailId;
        this.password = password;
        this.contact = contact;
    }

    public boolean resetPassword(String oldPass, String newPass){
        //TODO
        return true;
    }
}
