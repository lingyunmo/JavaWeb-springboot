package com.ling.jsb.service.impl;

import com.ling.jsb.dao.BookMapper;
import com.ling.jsb.pojo.Book;
import com.ling.jsb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookMapper bookMapper;

    @Autowired
    public BookServiceImpl(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public Book findBookById(Integer id) {
        return bookMapper.findBookById(id);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookMapper.getAllBooks();
    }
}