package com.jpa.springjpaexercise.controller;

import com.jpa.springjpaexercise.domain.dto.ReviewResponse;
import com.jpa.springjpaexercise.service.HospitalService;
import com.jpa.springjpaexercise.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    private final HospitalService hospitalService;
    private final ReviewService reviewService;


    public ReviewController(HospitalService hospitalService, ReviewService reviewService) {
        this.hospitalService = hospitalService;
        this.reviewService = reviewService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewResponse> getOneReview(@PathVariable int id){
        return ResponseEntity.ok().body(reviewService.getOneReview(id));
    }

}
