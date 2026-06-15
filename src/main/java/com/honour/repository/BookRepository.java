package com.honour.repository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import com.honour.entity.Book;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BookRepository {

    private File eBooks = new File("library_data/eBooks.json");

    private ObjectMapper mapper = new ObjectMapper();
    

    private List<Book> books = new ArrayList<Book>();

    public void addBook(Book book) throws Exception{
        books.add(book);
        mapper.writeValue(eBooks, books);
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

    public void loadBooks(){

        try{
        books = mapper.readValue(eBooks, new TypeReference<List<Book>>(){});
       
        }
        catch (Exception e) {
            System.out.println("Failed to load the data, reason: ");
            e.printStackTrace();
        }
    }
}
