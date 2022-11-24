package com.jpa.springjpaexercise.controller;


import com.jpa.springjpaexercise.domain.dto.HospitalResponse;
import com.jpa.springjpaexercise.domain.dto.ReviewRequest;
import com.jpa.springjpaexercise.domain.dto.ReviewResponse;
import com.jpa.springjpaexercise.service.HospitalService;
import com.jpa.springjpaexercise.service.ReviewService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hospitals")
public class HospitalController {

    private final HospitalService hospitalService;
    private final ReviewService reviewService;

    public HospitalController(HospitalService hospitalService, ReviewService reviewService) {
        this.hospitalService = hospitalService;
        this.reviewService = reviewService;
    }
    @GetMapping("")
    public ResponseEntity<List<HospitalResponse>> getHospitals(Pageable pageable) {
        return ResponseEntity.ok().body(hospitalService.getHospitalList(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewResponse> getOneReview(@PathVariable int id){
        return ResponseEntity.ok().body(reviewService.getOneReview(id));
    }

    @PostMapping("/{id}/reviews")
    public ResponseEntity<ReviewResponse> addReview(@PathVariable int id, @RequestBody ReviewRequest reviewRequest) {
        return ResponseEntity.ok().body(reviewService.addReview(id,reviewRequest));
    }

    @GetMapping("/{id}/reviews")
    public ResponseEntity<List<ReviewResponse>> getHospitalReviews(@PathVariable int id){
        return ResponseEntity.ok().body(reviewService.getHospitalReviews(id));
    }


}
