package com.ling.jsb.service;

import com.ling.jsb.pojo.Book;

import java.util.List;

public interface BookService {
    Book findBookById(Integer id);

    List<Book> getAllBooks();
}