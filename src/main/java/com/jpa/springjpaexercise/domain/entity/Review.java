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

    public ReviewResponse of() {
        return ReviewResponse.builder()
                .id(this.id)
                .hospitalName(this.hospital.getHospitalName())
                .patientName(this.patientName)
                .title(this.title)
                .content(this.content)
                .build();
    }
}