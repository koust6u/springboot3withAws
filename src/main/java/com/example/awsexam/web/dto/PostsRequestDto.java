package com.example.awsexam.web.dto;

import com.example.awsexam.domain.Posts;
import lombok.Getter;

@Getter
public class PostsRequestDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsRequestDto(Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
