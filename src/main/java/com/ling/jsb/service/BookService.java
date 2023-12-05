package com.ling.jsb.service;

import com.ling.jsb.pojo.Book;

import java.util.List;

public interface BookService {
    void insertBook(Book book);

    void deleteBookById(Integer id);

    void updateBook(Book book);

    Book findBookById(Integer id);

    List<Book> getAllBooks();
}