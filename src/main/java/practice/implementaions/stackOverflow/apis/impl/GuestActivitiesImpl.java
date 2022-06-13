package practice.implementaions.stackOverflow.apis.impl;

import practice.implementaions.stackOverflow.apis.GuestActivities;
import practice.implementaions.stackOverflow.exceptions.MemberAlreadyExists;
import practice.implementaions.stackOverflow.services.UserService;

public class GuestActivitiesImpl implements GuestActivities {

    private final UserService userService;

    public GuestActivitiesImpl() {
        this.userService = new UserService();
    }

    @Override
    public boolean signup(String name, String email, String pass, String contact) throws MemberAlreadyExists {
        return userService.createMember(name, email, pass, contact);
    }
}
