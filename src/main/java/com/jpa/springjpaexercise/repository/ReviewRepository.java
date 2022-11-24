package com.jpa.springjpaexercise.repository;

import com.jpa.springjpaexercise.domain.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
