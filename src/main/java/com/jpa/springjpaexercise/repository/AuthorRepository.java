package com.jpa.springjpaexercise.repository;

import com.jpa.springjpaexercise.domain.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
