package com.honour.repository;

import java.util.ArrayList;
import java.util.List;

import com.honour.entity.RegisterBook;

public class RegisterBookRepository {
    private List<RegisterBook> RegisterBooks = new ArrayList<RegisterBook>();

    public void addRegisterBook(RegisterBook RegisterBook){
        RegisterBooks.add(RegisterBook);
    }

    public List<RegisterBook> getRegisterBooks(){
        return RegisterBooks;
    }
}
