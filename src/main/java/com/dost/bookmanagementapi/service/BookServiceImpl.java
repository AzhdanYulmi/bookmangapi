package com.dost.bookmanagementapi.service;

import com.dost.bookmanagementapi.dto.BookRequestDTO;
import com.dost.bookmanagementapi.dto.BookResponseDTO;
import com.dost.bookmanagementapi.exception.BookNotFoundException;
import com.dost.bookmanagementapi.mapper.BookMapper;
import com.dost.bookmanagementapi.model.Book;
import com.dost.bookmanagementapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public Book getBookById(int id) {
        Optional<Book> optionalBook = bookRepository.findById(id);

        if (optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            throw new BookNotFoundException("Not found for id: " + id);
        }
    }

    @Override
    public List<BookResponseDTO> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return bookMapper.mapListOfBooksToResponse(books);
    }

    @Override
    public BookResponseDTO saveBook(BookRequestDTO bookRequestDTO) {
        Book savedBook = bookMapper.mapRequestToBook(bookRequestDTO);
        bookRepository.save(savedBook);
        return bookMapper.mapBookToResponse(savedBook);
    }

    @Override
    public BookResponseDTO updateBook(int id, BookRequestDTO bookRequestDTO) {
        Book bookToBeUpdated = getBookById(id);
        Book updatedBook = bookMapper.mapRequestToBook(bookRequestDTO);
        updatedBook.setId(id);
        bookRepository.save(updatedBook);

        return bookMapper.mapBookToResponse(updatedBook);
    }

    @Override
    public BookResponseDTO deleteBook(int id) {
        Book bookToBeDeleted = getBookById(id);
        bookRepository.deleteById(id);

        return bookMapper.mapBookToResponse(bookToBeDeleted);
    }
}
