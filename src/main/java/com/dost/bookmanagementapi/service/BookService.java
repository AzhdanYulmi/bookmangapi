package com.dost.bookmanagementapi.service;

import com.dost.bookmanagementapi.dto.BookRequestDTO;
import com.dost.bookmanagementapi.dto.BookResponseDTO;
import com.dost.bookmanagementapi.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    Book getBookById(int id);

    List<BookResponseDTO> getAllBooks();

    BookResponseDTO saveBook(BookRequestDTO book);

    BookResponseDTO updateBook(int id, BookRequestDTO book);

    BookResponseDTO deleteBook(int id);
}
