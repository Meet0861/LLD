package practice.implementaions.stackOverflow.models;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Member extends User{
    private Account account;
    private List<Badge> badges;

    public Member(Account account) {
        this.account = account;
        badges = new ArrayList<>();
    }

    public boolean createQuestion(){
        //TODO
        return true;
    }

    public boolean createTag(){
        //TODO
        return true;
    }
}
