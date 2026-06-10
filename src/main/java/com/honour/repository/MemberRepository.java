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
        Member member = members.stream()
                    .filter(x -> x.getName() == name)
                    .findFirst()
                    .orElseThrow();

    return member;
    }
}
