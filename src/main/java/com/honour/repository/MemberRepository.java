package com.honour.repository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.honour.entity.Member;

public class MemberRepository {
    private List<Member> members = new ArrayList<Member>();
    ObjectMapper mapper = new ObjectMapper();

    File eMembers = new File("library_data/eMembers.json");

    public MemberRepository(){

        try {
    
            members = mapper.readValue(eMembers, new TypeReference<List<Member>>() {});
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }


    public void addMember(Member member) {
        members.add(member);
        try{
            mapper.writeValue(eMembers, members);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
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
