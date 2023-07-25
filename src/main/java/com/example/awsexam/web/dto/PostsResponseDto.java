package com.example.awsexam.web.dto;

import com.example.awsexam.domain.Posts;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
public class PostsResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;
    public PostsResponseDto(Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
