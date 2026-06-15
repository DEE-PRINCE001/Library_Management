package com.honour.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.honour.entity.Book;
import com.honour.entity.Member;
import com.honour.repository.BookRepository;
import com.honour.repository.MemberRepository;

public class RegistrationService {
    Scanner scan = new Scanner(System.in);
    private final ObjectMapper mapper = new ObjectMapper();

    MemberRepository memberRepository = new MemberRepository();
    BookRepository bookRepository = new BookRepository();

    private final String FOLDER_PATH = "library_data/";

    public RegistrationService() {
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

        Book book = new Book(title, author, year);
        bookRepository.addBook(book);

        try {
            File file = new File(FOLDER_PATH + "Book.json");

            mapper.writerWithDefaultPrettyPrinter()
                    .writeValue(file, book);


            System.out.println("Member saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving member to JSON file.");
            e.printStackTrace();
        }

        System.out.println("Book registered successfully via repository!");
    }
}