package com.m3pro.groundflip_board.service;

import org.springframework.stereotype.Service;

import com.m3pro.groundflip_board.entity.dto.CommentRequest;
import com.m3pro.groundflip_board.entity.entity.Comment;
import com.m3pro.groundflip_board.entity.entity.Post;
import com.m3pro.groundflip_board.entity.repository.CommentRepository;
import com.m3pro.groundflip_board.entity.repository.PostRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {

	private final CommentRepository commentRepository;
	private final PostRepository postRepository;

	@Transactional
	public void postComment(CommentRequest commentRequest) {
		Post post = postRepository.findById(commentRequest.getPostId())
			.orElseThrow(() -> new RuntimeException("Post not found"));

		commentRepository.save(
			Comment.builder()
				.content(commentRequest.getContent())
				.user_id(commentRequest.getUserId())
				.post(post)
				.build()
		);
	}

	@Transactional
	public void putComment(Long id, CommentRequest commentRequest) {
		Comment comment = commentRepository.findById(id)
			.orElseThrow(() -> new RuntimeException("Comment not found"));

		comment.updateContent(commentRequest.getContent());
	}

	@Transactional
	public void deleteComment(Long id) {
		commentRepository.deleteById(id);
	}



}
