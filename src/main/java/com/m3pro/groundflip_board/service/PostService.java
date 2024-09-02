package com.m3pro.groundflip_board.service;

import java.util.List;

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

	public List<Post> getAllPosts(){
		List<Post> posts = postRepository.findAll();
		return posts;
	}

	public List<Post> getUserPosts(Long userId){
		List<Post> posts = postRepository.findByUserId(userId);
		return posts;
	}
}
