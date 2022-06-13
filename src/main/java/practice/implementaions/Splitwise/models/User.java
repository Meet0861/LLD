package practice.implementaions.Splitwise.models;

public class User {
    private int id;
    private String name;
    private String emailId;
    private String contact;


    public User(int id, String name, String emailId, String contact) {
        this.id = id;
        this.name = name;
        this.emailId = emailId;
        this.contact = contact;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
