package com.librarysystem;

public class Book {
    private String title;
    private String auther;
    private boolean isBorrowed;

    public Book(String title, String auther) {
        this.auther = auther;
        this.title = title;
        this.isBorrowed = false;
    }

    public String getAuther() {
        return auther;
    }

    public String getTitle() {
        return title;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void BookBorrow() {
        isBorrowed = true;
    }

    public void returnBook() {
        isBorrowed = false;
    }
}
