package practice.implementaions.BiddingService.models;

public abstract class User {
    private int id;
    private String name;
    private Contact contact;
    private Address address;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
//        this.contact = contact;
//        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
