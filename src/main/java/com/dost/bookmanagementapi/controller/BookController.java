package com.dost.bookmanagementapi.controller;

import com.dost.bookmanagementapi.model.Book;
import com.dost.bookmanagementapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
        Book book = bookService.getBookById(id);

        return ResponseEntity.ok(book);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        bookService.addBook(book);

        return ResponseEntity.ok(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book book) {
        bookService.updateBook(id, book);

        return ResponseEntity.ok(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
    }
}
