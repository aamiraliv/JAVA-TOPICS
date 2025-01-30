package com.librarysystem;

import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        Library l = new Library();

        l.addBook(new Book("The Alchemist", "Paulo Coelho"));
        l.addBook(new Book("1984", "George Orwell"));
        l.addBook(new Book("To Kill a Mockingbird", "Harper Lee"));

        Member m = new Member("jhone");

        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Library Menu : ");
            System.out.println("1. View available books");
            System.out.println("2. borrow a book");
            System.out.println("3. return book");
            System.out.println("4. view borrowed books");
            System.out.println("exit");
            System.out.print("enter your choice:");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    l.displayAllBooks();
                    break;
                case 2:
                    System.out.println("enter the title of the book you borrow:");
                    String BorrowTitle = sc.nextLine();
                    m.borrowBook(l, BorrowTitle);
                    break;
                case 3:
                    System.out.println("enter the title of the book you return");
                    String ReturnBook = sc.nextLine();
                    m.returnBook(l, ReturnBook);
                    break;
                case 4:
                    m.viewBorrowedBooks();
                    break;
                case 5:
                    System.out.println("exiting from the library managment system");
                    break;
                default:
                    System.out.println("invalid choice please try again!!");
            }
        } while (choice != 0);
    }
}
