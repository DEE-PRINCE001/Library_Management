package com.honour.entity;

public class Member{
    private String name;
    private int memberId;
    private String address;

    public Member() {
    }

    public Member(String name, int memberId, String address) {
        this.name = name;
        this.memberId = memberId;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}