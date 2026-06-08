package com.honour.entity;

import java.time.LocalDate;

public class Record {
    Member member;
    Book book;
    LocalDate date;

    public Record() {

    }

    public Record(Member member, Book book, LocalDate date) {
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    

}
