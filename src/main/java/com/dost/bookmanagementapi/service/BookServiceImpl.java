package com.dost.bookmanagementapi.service;

import com.dost.bookmanagementapi.exception.BookNotFoundException;
import com.dost.bookmanagementapi.model.Book;
import com.dost.bookmanagementapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book getBookById(int id) {
        Optional<Book> optionalBook = bookRepository.findById(id);

        if (optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            throw new BookNotFoundException("Not not found for id: " + id);
        }
    }

    @Override
    public Book addBook(Book book) {
        bookRepository.save(book);

        return book;
    }

    @Override
    public Book updateBook(int id, Book book) {
        Book bookToBeUpdated = getBookById(id);

        book.setId(id);
        bookRepository.save(book);

        return bookToBeUpdated;
    }

    @Override
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }
}
