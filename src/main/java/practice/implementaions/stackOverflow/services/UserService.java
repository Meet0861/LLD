package practice.implementaions.stackOverflow.services;

import practice.implementaions.stackOverflow.enums.AccountStatus;
import practice.implementaions.stackOverflow.exceptions.MemberAlreadyExists;
import practice.implementaions.stackOverflow.models.Account;
import practice.implementaions.stackOverflow.repository.MembersRepo;

public class UserService {
    private static int id = 0;
    private final MembersRepo usersRepo;

    public UserService() {
        this.usersRepo = new MembersRepo();
    }

    public boolean createMember(String name, String emailId, String pass, String contact) throws MemberAlreadyExists {
        Account account = new Account(++id, AccountStatus.ACTIVE, emailId, pass, contact);
        return usersRepo.addMember(account, id);
    }


}
