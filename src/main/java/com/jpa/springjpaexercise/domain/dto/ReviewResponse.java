package com.jpa.springjpaexercise.domain.dto;


import com.jpa.springjpaexercise.domain.entity.Review;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewResponse {
    private int id;
    private String title;
    private String content;
    private String patientName;
    private String message;

    public static ReviewResponse of(Review review, String message) {
        return ReviewResponse.builder()
                .id(review.getId())
                .patientName(review.getPatientName())
                .title(review.getTitle())
                .content(review.getContent())
                .message(message)
                .build();
    }
}
