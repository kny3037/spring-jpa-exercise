package com.jpa.springjpaexercise.repository;

import com.jpa.springjpaexercise.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
