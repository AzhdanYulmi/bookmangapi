package com.dost.bookmanagementapi.mapper;

import com.dost.bookmanagementapi.dto.BookRequestDTO;
import com.dost.bookmanagementapi.dto.BookResponseDTO;
import com.dost.bookmanagementapi.model.Book;

import java.util.List;

public interface BookMapper {
    BookResponseDTO mapBookToResponse(Book book);

    Book mapRequestToBook(BookRequestDTO bookRequestDTO);

    List<BookResponseDTO> mapListOfBooksToResponse(List<Book> books);
}
