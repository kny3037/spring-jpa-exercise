package com.jpa.springjpaexercise.domain.entity;

import com.jpa.springjpaexercise.domain.dto.ReviewRequest;
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

    /*public static ReviewRequest of(Review review) {
        return ReviewRequest.builder()
                .id(review.getId())
                .hospitalId(review.getHospital().getId())
                .content(review.getContent())
                .patientName(review.getPatientName())
                .build();
    }*/

}