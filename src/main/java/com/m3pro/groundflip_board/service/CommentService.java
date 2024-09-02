package com.m3pro.groundflip_board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.m3pro.groundflip_board.entity.dto.CommentRequest;
import com.m3pro.groundflip_board.entity.dto.CommentResponse;
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
	public void createComment(Long postId, CommentRequest commentRequest) {
		Post post = postRepository.findById(postId)
			.orElseThrow(() -> new RuntimeException("Post not found"));

		commentRepository.save(
			Comment.builder()
				.content(commentRequest.getContent())
				.userId(commentRequest.getUserId())
				.post(post)
				.likes(0L)
				.build()
		);
	}

	@Transactional
	public void putComment(Long commentId, CommentRequest commentRequest) {
		Comment comment = commentRepository.findById(commentId)
			.orElseThrow(() -> new RuntimeException("Comment not found"));

		comment.updateContent(commentRequest.getContent());
	}

	@Transactional
	public void deleteComment(Long id) {
		commentRepository.deleteById(id);
	}

	public List<CommentResponse> getPostsComment(Long postId){
		List<Comment> comments = commentRepository.findByPostId(postId);
		return comments.stream().map(CommentResponse::from).toList();
	}

	public List<CommentResponse> getUsersComment(Long userId){
		List<Comment> comments = commentRepository.findByUserId(userId);
		return comments.stream().map(CommentResponse::from).toList();
	}


}
