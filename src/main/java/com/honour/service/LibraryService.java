package com.honour.service;
import com.honour.repository.MemberRepository;
import java.time.LocalDate;
import java.util.Scanner;

import com.honour.entity.Book;
import com.honour.entity.Member;
import com.honour.repository.BookRepository;

public class LibraryService {
    Scanner scan = new Scanner(System.in);

    MemberRepository memberRepository = new MemberRepository();
    BookRepository bookRepository = new BookRepository();

    public void registerMember(){
        System.out.println("Enter Member Id: ");
        int id = Integer.parseInt(scan.nextLine());
        System.out.println("Enter your Name: ");
        String name = scan.nextLine();
        System.out.println("Enter your addressh: ");
        String address = scan.nextLine();
        
        memberRepository.addMember(new Member(name, id, address));
        
    }
    
    public void registerBook(){
        System.out.println("Enter the title of the book: ");
        String title  = scan.nextLine();
        System.out.println("Enter the Author of the book: ");
        String author = scan.nextLine();
        System.out.println("Enter the Year the book was published: ");
        int year = Integer.parseInt(scan.nextLine());

        Book book = new Book(title, author, year);
        bookRepository.addBook(book);

    }

    public void borrowBook(){
        System.out.println("Enter your name");
        String name = scan.nextLine();
        Member member = memberRepository.getMemberByName(name);

        if (member != null){
            System.out.println("Enter the title of the book");
            String title = scan.nextLine();
            Book book = bookRepository.getBookByTitle(title);

            if (book != null){
                System.out.println("Borrow Operation Successful");
                System.out.println("here is the details of the book you borrowed");
                System.out.println("--------------");
                System.out.println(book.toString());

            }
            else{
                System.out.println("The book: " + title + " is not available");
            }


            
        }
        else {
            System.out.println("You are not yet registered, Kindly register now");
            return;
        }
    }


    public void returnBook(){
        System.out.println("Enter your name");
        String name = scan.nextLine();
        Member member = memberRepository.getMemberByName(name);

        if (member != null){
            System.out.println("Enter the name of the book to be returned");
            String title = scan.nextLine();
            Book book = bookRepository.getBookByTitle(title);

            if (book != null){
                System.out.println("Kindly drop the book on the tableh");
                System.out.println("The return operation is successful ...;");
            }

            else{
                System.out.println("There is no book with that title, kindly check the title and try again.");
            }
        }
        else{
            System.out.println("Where you get the book, You ain't our member");
        }
    }
}

    


