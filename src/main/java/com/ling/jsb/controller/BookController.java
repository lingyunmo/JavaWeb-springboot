package com.ling.jsb.controller;

import com.ling.jsb.pojo.Book;
import com.ling.jsb.pojo.Result;
import com.ling.jsb.pojo.ResultUtil;
import com.ling.jsb.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/myBook")
@Slf4j
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/book")
    public String findBookById(Integer id, Model model) {
        Book book = bookService.findBookById(id);
        model.addAttribute("book", book);
        return "book";
    }

    @GetMapping("/books")
    public String getAllBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/book2")
    public Result findBookById2(Integer id) {
        log.info("id= {}", id);
        Book book = bookService.findBookById(id);
        return ResultUtil.success(book);
    }
}