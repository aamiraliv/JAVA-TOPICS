package com.librarysystem;

import java.util.ArrayList;

public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Member extends User {
    private ArrayList<String> borrowedBooks;

    public Member(String name) {
        super(name);
        borrowedBooks = new ArrayList<>();
    }

    public void borrowBook(Library library, String title) {
        library.borrowBook(title);
        borrowedBooks.add(title);
    }

    public void returnBook(Library library, String title) {
        library.returnBook(title);
        borrowedBooks.remove(title);
    }

    public void viewBorrowedBooks() {
        System.out.println("borrowed books: ");
        for (String book : borrowedBooks) {
            System.out.println("- " + book);
        }
    }
}