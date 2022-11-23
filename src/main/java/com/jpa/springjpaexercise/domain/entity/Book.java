package com.jpa.springjpaexercise.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book2")
public class Book {
    @Id
    private Long id;
    private String name;
    //private Long authorId; //id만 name은 없음

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
}
