package com.dost.bookmanagementapi.controller;

import com.dost.bookmanagementapi.dto.BookRequestDTO;
import com.dost.bookmanagementapi.dto.BookResponseDTO;
import com.dost.bookmanagementapi.model.Book;
import com.dost.bookmanagementapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<BookResponseDTO> getBookById(@PathVariable int id) {
        BookResponseDTO book = BookResponseDTO.fromEntity(bookService.getBookById(id));
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BookResponseDTO> addBook(@RequestBody BookRequestDTO bookRequestDTO) {
        BookResponseDTO bookResponseDTO = bookService.saveBook(bookRequestDTO);
        if (bookResponseDTO != null) {
            return new ResponseEntity<>(bookResponseDTO, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponseDTO> updateBook(@PathVariable int id, @RequestBody BookRequestDTO bookRequestDTO) {
        BookResponseDTO updatedBookResponseDTO = bookService.updateBook(id, bookRequestDTO);
        if (updatedBookResponseDTO != null) {
            return new ResponseEntity<>(updatedBookResponseDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
