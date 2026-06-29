package com.honour.repository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.honour.entity.Book;

public class BookRepository {
    private List<Book> books = new ArrayList<Book>();

    private File eBooks = new File ("library_data/eBooks.json");

    ObjectMapper mapper = new ObjectMapper();

    public BookRepository() {
        try{
        books = mapper.readValue(eBooks, new TypeReference<List<Book>>(){});
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void updateBook(Book book){
        Book bookToBeRemoved = getBookByTitle(book.getTitle());
        books.remove(bookToBeRemoved);
        books.add(book);
        try {
            mapper.writeValue(eBooks, books);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void addBook(Book book) {
        books.add(book);
        try{
            mapper.writeValue(eBooks, books);
        }catch(Exception e){
            e.printStackTrace();
        }
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
