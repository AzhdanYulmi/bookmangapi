package com.dost.bookmanagementapi.service;

import com.dost.bookmanagementapi.model.Book;

public interface BookService {
    Book getBookById(int id);

    Book addBook(Book book);

    Book updateBook(int id, Book book);

    void deleteBook(int id);
}
