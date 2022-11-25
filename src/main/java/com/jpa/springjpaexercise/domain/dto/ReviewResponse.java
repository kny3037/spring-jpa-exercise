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
    private String hospitalName;
    private String message;

}
