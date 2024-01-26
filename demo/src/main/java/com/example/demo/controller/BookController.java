package com.example.demo.controller;



import com.example.demo.service.BookH2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;

import java.util.*;

@RestController
class BookController {
    @Autowired
    private BookH2Service bookH2Service;

    @GetMapping("/books")
    public ArrayList<Book> getBooks() {
        return bookH2Service.getBooks();
    }

    @GetMapping("/books/{bookId}")
    public Book getBookById(@PathVariable("bookId") int bookId) {
        return bookH2Service.getBookById(bookId);
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {
        return bookH2Service.addBook(book);

    }

    @PutMapping("/books/{bookId}")
    public Book updateBook(@PathVariable("bookId") int bookId, @RequestBody Book book) {
        return bookH2Service.updateBook(bookId, book);
    }

    @DeleteMapping("/books/{bookId}")
    public void deleteBook(@PathVariable("bookId") int bookId) {
        bookH2Service.deleteBook(bookId);
    }


}

