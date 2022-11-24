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
import java.util.stream.Collectors;

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

    public ReviewResponse getOneReview(int id) {
        Optional<Review> optionalReview = reviewRepository.findById(id);
        Review review = optionalReview.get();
        ReviewResponse reviewResponse = Review.of(review,id+"번 리뷰를 성공적으로 조회하였습니다.");
        return reviewResponse;
    }

    public List<ReviewResponse> getHospitalReviews(int id){
        Optional<Hospital> optionalHospital = hospitalRepository.findById(id);
        Hospital hospital = optionalHospital.get();
        List<ReviewResponse> reviewResponses = hospital.getReviews().stream()
                .map(review -> ReviewResponse.of(review, id+"번 리뷰를 성공적으로 조회하였습니다."))
                .collect(Collectors.toList());
        return reviewResponses;
    }


}

