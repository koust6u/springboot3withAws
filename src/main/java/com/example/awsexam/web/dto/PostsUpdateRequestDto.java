package com.example.awsexam.web.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostsUpdateRequestDto {
    private String title;
    private String content;

}
