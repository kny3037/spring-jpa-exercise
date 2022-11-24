package com.jpa.springjpaexercise.domain.dto;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewRequest {
    private String title;
    private String content;
    private String patientName;
}
