package practice.implementaions.stackOverflow.apis;

import practice.implementaions.stackOverflow.exceptions.MemberAlreadyExists;

public interface GuestActivities {

    boolean signup(String name, String email, String pass, String contact) throws MemberAlreadyExists;
}
