package com.jpa.springjpaexercise.service;

import com.jpa.springjpaexercise.domain.dto.ReviewRequest;
import com.jpa.springjpaexercise.domain.dto.ReviewResponse;
import com.jpa.springjpaexercise.domain.entity.Hospital;
import com.jpa.springjpaexercise.domain.entity.Review;
import com.jpa.springjpaexercise.repository.HospitalRepository;
import com.jpa.springjpaexercise.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final HospitalRepository hospitalRepository;

    public ReviewService(ReviewRepository reviewRepository, HospitalRepository hospitalRepository) {
        this.reviewRepository = reviewRepository;
        this.hospitalRepository = hospitalRepository;
    }

    public ReviewResponse addReview(int id, ReviewRequest reviewCreateRequest) {
        Optional<Hospital> hospital = hospitalRepository.findById(id);
        Review review = Review.builder()
                .title(reviewCreateRequest.getTitle())
                .content(reviewCreateRequest.getContent())
                .patientName(reviewCreateRequest.getPatientName())
                .hospital(hospital.get())
                .build();
        Review savedReview = reviewRepository.save(review);
        return new ReviewResponse(savedReview.getId(),
                savedReview.getTitle(),
                savedReview.getContent(),
                savedReview.getContent(),
                "리뷰 등록이 성공 했습니다.");
    }

    /*public ReviewRequest get(int id){
        Optional<Review> optionalReview = reviewRepository.findById(id);
        ReviewRequest reviewRequest = Review.of(optionalReview.get());
        return reviewRequest;
    }

    public ReviewRequest getReview(int id){
        Optional<Review> optionalReview = reviewRepository.findById(id);
        Review review;
        if (optionalReview.isPresent()){
            return ReviewRequest.of(optionalReview.get());
        }else {
            return ReviewRequest.builder().message("불러올 수 없는 id입니다.").build();
        }
    }*/
}

