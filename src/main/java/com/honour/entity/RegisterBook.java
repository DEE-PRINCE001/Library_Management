package com.honour.entity;


import java.util.Date;

public class RegisterBook {
    Member member;
    Book book;
    Date date;
    boolean isReturned =false;

    public RegisterBook() {

    }

    public boolean isReturned() {
        return isReturned;
    }

    public void setReturned(boolean isReturned) {
        this.isReturned = isReturned;
    }

    public RegisterBook(Member member, Book book, Date date) {
        this.member = member;
        this.book = book;
        this.date = date;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    

}
