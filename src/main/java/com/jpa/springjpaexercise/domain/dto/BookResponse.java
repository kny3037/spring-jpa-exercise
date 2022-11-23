package com.jpa.springjpaexercise.domain.dto;

import com.jpa.springjpaexercise.domain.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {
    private Long id;
    private String name;
    private String authorName;

    public static BookResponse of(Book book, String authorName){
        return BookResponse.builder()
                .id(book.getId())
                .name(book.getName())
                .authorName(authorName)
                .build();
    }
}
