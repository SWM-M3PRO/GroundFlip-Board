package com.m3pro.groundflip_board.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.m3pro.groundflip_board.entity.dto.CommentRequest;
import com.m3pro.groundflip_board.entity.dto.CommentResponse;
import com.m3pro.groundflip_board.entity.entity.Comment;
import com.m3pro.groundflip_board.service.CommentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Tag(name = "comment", description = "댓글 API")
public class CommentController {

	private final CommentService commentService;

	@Operation(summary = "댓글 작성", description = "")
	@PostMapping("/comment/{postId}")
	public ResponseEntity<Integer> postComment(
		@Parameter(description = "댓글 post", required = true)
		@PathVariable Long postId,
		@RequestBody CommentRequest commentRequest
	){
		commentService.createComment(postId, commentRequest);
		return ResponseEntity.ok(201);
	}

	@Operation(summary = "댓글 수정", description = "content 수정")
	@PutMapping("/comment/{commentId}")
	public ResponseEntity<Integer> putComment(
		@Parameter(description = "댓글 put", required = true)
		@PathVariable Long commentId,
		@RequestBody CommentRequest commentRequest
	){
		commentService.putComment(commentId, commentRequest);
		return ResponseEntity.ok(200);
	}

	@Operation(summary = "댓글 삭제", description = "delete comment")
	@DeleteMapping("/comment")
	public ResponseEntity<Integer> deleteComment(
		@Parameter(description = "댓글 delete", required = true)
		@RequestParam Long id
	){
		commentService.deleteComment(id);
		return ResponseEntity.ok(200);
	}

	@Operation(summary = "게시글 댓글 조회", description = "get post comment")
	@GetMapping("/comment/post/{postId}")
	public ResponseEntity<List<CommentResponse>> getPostComment(
		@Parameter(description = "게시글 댓글 get", required = true)
		@PathVariable Long postId
	){
		List<CommentResponse> comments = commentService.getPostsComment(postId);
		return ResponseEntity.ok(comments);
	}

	@Operation(summary = "유저 댓글 조회", description = "get user comment")
	@GetMapping("/comment/user/{userId}")
	public ResponseEntity<List<CommentResponse>> getUserComment(
		@Parameter(description = "유저 댓글 get", required = true)
		@PathVariable Long userId
	){
		List<CommentResponse> comments = commentService.getUsersComment(userId);
		return ResponseEntity.ok(comments);
	}




}
