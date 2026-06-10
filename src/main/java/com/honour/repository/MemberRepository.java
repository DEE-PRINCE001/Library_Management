package com.honour.repository;

import java.util.List;
import com.honour.entity.Member;

public class MemberRepository {
    List<Member> members;

    public void addMember(Member member) {
        members.add(member);
    }

    public List<Member> getMembers() {
        return members;
    }
    public Member getMemberByName(String name){
        return members.stream()
                        .filter(x -> x.getName() == name)
                        .findFirst()
                        .orElseThrow();
    }
}
