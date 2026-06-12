package com.honour.service;

import java.time.LocalDate;
import java.util.Scanner;

import com.honour.entity.Book;
import com.honour.entity.Member;
import com.honour.repository.BookRepository;
import com.honour.repository.MemberRepository;

public class RegistrationService {
    Scanner scan = new Scanner(System.in);

    MemberRepository memberRepository = new MemberRepository();
    BookRepository bookRepository = new BookRepository();

    public void registerMember() {
        System.out.println("Enter Member Id: ");
        int id = Integer.parseInt(scan.nextLine());
        System.out.println("Enter your Name: ");
        String name = scan.nextLine();
        System.out.println("Enter your addressh: ");
        String address = scan.nextLine();

        memberRepository.addMember(new Member(name, id, address));

    }

    public void registerBook() {
        System.out.println("Enter the title of the book: ");
        String title = scan.nextLine();
        System.out.println("Enter the Author of the book: ");
        String author = scan.nextLine();
        System.out.println("Enter the Year the book was published: ");
        int year = Integer.parseInt(scan.nextLine());

        Book book = new Book(title, author, year);
        bookRepository.addBook(book);

    }
}