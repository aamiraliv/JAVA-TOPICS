package com.librarysystem;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayAllBooks() {
        System.out.println("available book:");
        for (Book book : books) {
            if (!book.isBorrowed()) {
                System.out.println("-" + book.getTitle() + " by " + book.getAuther());
            }
        }
    }

    public void borrowBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && !book.isBorrowed()) {
                book.BookBorrow();
                System.out.println("you borrowed book: " + book.getTitle());
                return;
            }
        }
        System.out.println("book is not available or already borrowed");
    }

    public void returnBook(String title) {

        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.isBorrowed()) {
                book.returnBook();
                System.out.println("you returned the book: " + book.getTitle());
                return;
            }
        }
        System.out.println("invalid book . or book is not borrowed from the library.");
    }
}
