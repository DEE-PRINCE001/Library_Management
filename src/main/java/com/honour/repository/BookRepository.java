package com.honour.repository;

import java.util.List;
import com.honour.entity.Book;

public class BookRepository {
    List<Book> books;

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }
}
