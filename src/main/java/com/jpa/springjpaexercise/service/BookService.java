package com.jpa.springjpaexercise.service;

import com.jpa.springjpaexercise.domain.dto.BookResponse;
import com.jpa.springjpaexercise.domain.entity.Author;
import com.jpa.springjpaexercise.domain.entity.Book;
import com.jpa.springjpaexercise.repository.AuthorRepository;
import com.jpa.springjpaexercise.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookResponse> findBooks(Pageable pageable) {
        Page<Book> books = bookRepository.findAll(pageable);
        List<BookResponse> bookResponses = books.stream()
                .map(book -> BookResponse.of(book)).collect(Collectors.toList());
        return bookResponses;
    }
}

