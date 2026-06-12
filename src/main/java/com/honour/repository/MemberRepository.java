package com.honour.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import com.honour.entity.Member;

public class MemberRepository {
    private List<Member> members = new ArrayList<Member>();

    public void addMember(Member member) {
        members.add(member);
    }

    public List<Member> getMembers() {
        return members;
    }

    public Member getMemberByName(String name) throws NoSuchElementException {
        Member member = members.stream()
                    .filter(x -> x.getName().equalsIgnoreCase(name))
                    .findFirst()
                    .orElseThrow();

    return member;
    }
}
