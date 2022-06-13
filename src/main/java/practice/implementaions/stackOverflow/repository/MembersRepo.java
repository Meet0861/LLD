package practice.implementaions.stackOverflow.repository;

import lombok.Getter;
import practice.implementaions.stackOverflow.Constants.ApplicationConstants;
import practice.implementaions.stackOverflow.exceptions.MemberAlreadyExists;
import practice.implementaions.stackOverflow.models.Account;
import practice.implementaions.stackOverflow.models.Member;

import java.util.HashMap;
import java.util.Map;

@Getter
public class MembersRepo{
    private static Map<Integer, Member> memberMap;

    public MembersRepo() {
        memberMap = new HashMap<>();
    }

    public boolean addMember(Account account, int id) throws MemberAlreadyExists {
        Member member = new Member(account);
        if(memberMap.containsKey(id))
            throw new MemberAlreadyExists(ApplicationConstants.MEMBER_ALREADY_EXISTS);
        memberMap.put(id, member);
        return true;
    }

    public boolean isMember(int id){
        return memberMap.containsKey(id);
    }

    public Member getMemberById(int id){
        return memberMap.get(id);
    }

}
