package com.honour.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import com.honour.entity.Book;

public class BookRepository {
    private List<Book> books = new ArrayList<Book>();

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public Book getBookByTitle(String title) throws NoSuchElementException {
        Book book = books.stream()
                            .filter(b -> b.getTitle().equalsIgnoreCase(title))
                            .findFirst()
                            .orElseThrow();

        return book;
    }
}
