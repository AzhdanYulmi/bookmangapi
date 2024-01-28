package com.dost.bookmanagementapi.mapper;

import com.dost.bookmanagementapi.dto.BookRequestDTO;
import com.dost.bookmanagementapi.dto.BookResponseDTO;
import com.dost.bookmanagementapi.model.Book;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapperImpl implements BookMapper {
    @Override
    public BookResponseDTO mapBookToResponse(Book book) {
        if (book == null) {
            return null;
        }
        return new BookResponseDTO(
                book.getId(),
                book.getName(),
                book.getAuthor(),
                book.getPrice(),
                book.getPictureUrl()
        );
    }


    @Override
    public Book mapRequestToBook(BookRequestDTO bookRequestDTO) {
        if (bookRequestDTO == null) {
            return null;
        }
        return new Book(
                0,
                bookRequestDTO.getName(),
                bookRequestDTO.getAuthor(),
                bookRequestDTO.getPrice(),
                bookRequestDTO.getPictureUrl()
        );
    }


    @Override
    public List<BookResponseDTO> mapListOfBooksToResponse(List<Book> books) {
        if (books == null) {
            return null;
        }
        return books.stream()
                .map(this::mapBookToResponse)
                .collect(Collectors.toList());
    }

}
