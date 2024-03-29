package com.example.awsexam.service;

import com.example.awsexam.domain.Posts;
import com.example.awsexam.domain.repository.PostsRepository;
import com.example.awsexam.dto.PostsListResponse;
import com.example.awsexam.web.dto.PostsRequestDto;
import com.example.awsexam.web.dto.PostsResponseDto;
import com.example.awsexam.web.dto.PostsSaveRequestDto;
import com.example.awsexam.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostsService {
    private final PostsRepository postsRepository;


    @Transactional
    public void delete(Long id){
        Posts posts = postsRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        postsRepository.delete(posts);
    }
    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity())
                .getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new
                        IllegalArgumentException("해당 사용자가 없습니다. id="+ id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id)
                .orElseThrow(()-> new
                        IllegalArgumentException("해당 사용자가 없습니다. id=" +id));
        return new PostsResponseDto(entity);
    }


    @Transactional(readOnly = true)
    public List<PostsListResponse> findAllDesc(){
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponse::new)
                .collect(Collectors.toList());
    }

}
