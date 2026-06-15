package com.honour.service;

import com.honour.repository.MemberRepository;
import com.honour.repository.RegisterBookRepository;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.honour.entity.Book;
import com.honour.entity.Member;
import com.honour.entity.RegisterBook;
import com.honour.repository.BookRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;

public class LibraryService {
    Scanner scan = new Scanner(System.in);
    private final ObjectMapper mapper = new ObjectMapper();

    private final String FOLDER_PATH = "library_data/";

    MemberRepository memberRepository = new MemberRepository();
    BookRepository bookRepository = new BookRepository();
    RegisterBookRepository registerBookRepository = new RegisterBookRepository();

    public LibraryService() {
        try {
            Path path = Paths.get(FOLDER_PATH);
            Files.createDirectories(path);

        } catch (IOException e) {
            System.out.println("Could not create directory: " + e.getMessage());
        }
    }

    public void registerMember() {
        System.out.println("Enter Member Id: ");
        int id = Integer.parseInt(scan.nextLine());
        System.out.println("Enter your Name: ");
        String name = scan.nextLine();
        System.out.println("Enter your addressh: ");
        String address = scan.nextLine();

        memberRepository.addMember(new Member(name, id, address));

        Member aMember = new Member(name, id, address);

        memberRepository.addMember(aMember);

        try {
            File file = new File(FOLDER_PATH + "Members.json");

            mapper.writerWithDefaultPrettyPrinter()
                    .writeValue(file, aMember);

            System.out.println("Member saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving member to JSON file.");
            e.printStackTrace();
        }

    }

    public void registerBook() {
        System.out.println("Enter the title of the book: ");
        String title = scan.nextLine();
        System.out.println("Enter the Author of the book: ");
        String author = scan.nextLine();
        System.out.println("Enter the Year the book was published: ");
        int year = Integer.parseInt(scan.nextLine());
        try {
            Book book = new Book(title, author, year);
            bookRepository.addBook(book);
         
            File file = new File(FOLDER_PATH + "Book.json");

            mapper.writerWithDefaultPrettyPrinter()
                    .writeValue(file, book);

            System.out.println("Member saved successfully!");
     

        System.out.println("Book registered successfully via repository!");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void borrowBook() {
        System.out.println("Enter your name");
        String name = scan.nextLine();

        try {
            Member member = memberRepository.getMemberByName(name);
            System.out.println("Enter the title of the book");
            String title = scan.nextLine();
            try {
                Book book = bookRepository.getBookByTitle(title);

                registerBookRepository.addRegisterBook(new RegisterBook(member, book, new Date()));
                System.out.println("Borrow Operation Successful");
                System.out.println("here is the details of the book you borrowed");
                System.out.println("--------------");
                System.out.println(book.toString());

            } catch (NoSuchElementException e) {
                System.out.println("The book: " + title + " is not available");
            }

        } catch (NoSuchElementException e) {
            System.out.println("You are not yet registered, Kindly register now");
        }
    }

    public void returnBook() {
        System.out.println("Enter your name");
        String name = scan.nextLine();

        try {

            Member member = memberRepository.getMemberByName(name);

            System.out.println("Enter the name of the book to be returned");
            String title = scan.nextLine();

            try {
                List<RegisterBook> records = registerBookRepository.getRegisterBooks();

                records.stream()
                        .filter((x) -> x.getMember().equals(member))
                        .filter((x) -> x.getBook().getTitle().equalsIgnoreCase(title))
                        .findAny()
                        .orElseThrow();

                System.out.println("Kindly drop the book on the tableh");
                System.out.println("The return operation is successful ...;");
            }

            catch (NoSuchElementException a) {
                System.out.println("There is no Record of you borrowing this book");
            }

        } catch (NoSuchElementException e) {
            System.out.println("Where you get the book, You ain't our member");
        }
    }

    public void loadBooks(){
        bookRepository.loadBooks();
    }


    
}
