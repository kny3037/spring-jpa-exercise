package com.jpa.springjpaexercise.domain.entity;

import com.jpa.springjpaexercise.domain.dto.ReviewRequest;
import com.jpa.springjpaexercise.domain.dto.ReviewResponse;
import lombok.*;

import javax.persistence.*;
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String content;
    private String patientName;


    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    public static ReviewResponse of(Review review, String message) {
        return new ReviewResponse(
                review.getId(),
                review.getTitle(),
                review.getContent(),
                review.getPatientName(),
                message
                );
    }

}