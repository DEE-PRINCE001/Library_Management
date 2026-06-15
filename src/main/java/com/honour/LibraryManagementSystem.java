package com.honour;

import java.util.Scanner;

import com.honour.service.LibraryService;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LibraryService libraryService = new LibraryService();

        boolean endSession = false;
        while (true) {

            if (endSession) {
                break;
            }
            System.out.println("=========LIBRARY MANAGEMENT SYSTEM============\n");

            System.out.println("Here are our services \n");
            System.out.println("1. Register Book");
            System.out.println("2. Register Member");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.println();
            int choice = Integer.parseInt(scan.nextLine());

            switch (choice) {
                case 1: {
                    libraryService.registerBook();
                    System.out.println("The book was registered successfully");
                    break;
                }
                case 2: {
                    libraryService.registerMember();

                    break;
                }
                case 3: {
                    libraryService.borrowBook();
                    break;
                }
                case 4: {
                    libraryService.returnBook();
                    break;
                }
                case 5: {

                    System.out.println("Thank for choosing us");
                    endSession = true;

                }
            }
            
        }

    }

}