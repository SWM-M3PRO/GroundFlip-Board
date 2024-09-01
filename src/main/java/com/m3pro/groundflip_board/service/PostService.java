package com.m3pro.groundflip_board.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.m3pro.groundflip_board.entity.dto.PostRequest;
import com.m3pro.groundflip_board.entity.entity.Post;
import com.m3pro.groundflip_board.entity.repository.PostRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {

	private final PostRepository postRepository;

	@Transactional
	public void createPost(PostRequest postRequest) {
		postRepository.save(
			Post.builder()
				.title(postRequest.getTitle())
				.content(postRequest.getContent())
				.userId(postRequest.getUserId())
				.likes(0L)
				.build());
	}

	@Transactional
	public void putPost(Long id, PostRequest postRequest) {
		Post post = postRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("Post not found"));

		post.updateTitle(postRequest.getTitle());
		post.updateContent(postRequest.getContent());
	}

	@Transactional
	public void deletePost(Long id){
		Post post = postRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("Post not found"));

		postRepository.delete(post);
	}
}
