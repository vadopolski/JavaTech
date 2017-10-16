package com.trainings;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class LibrarySessionBean implements LibrarySessionBeanRemote {

    List<String> bookShelf;

    public LibrarySessionBean(){
        bookShelf = new ArrayList<String>();
    }

    @Override public void addBook(String bookName) {
        bookShelf.add(bookName);
    }

    @Override public List getBooks() {
        return bookShelf;
    }
}
