package com.m3pro.groundflip_board.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.m3pro.groundflip_board.entity.dto.CommentRequest;
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
	@PostMapping("/comment")
	public ResponseEntity<Integer> postComment(
		@Parameter(description = "댓글 post", required = true)
		@RequestBody CommentRequest commentRequest
	){
		commentService.postComment(commentRequest);
		return ResponseEntity.ok(201);
	}

	@Operation(summary = "댓글 수정", description = "content 수정")
	@PutMapping("/comment")
	public ResponseEntity<Integer> putComment(
		@Parameter(description = "댓글 put", required = true)
		@RequestBody CommentRequest commentRequest,
		@RequestParam Long id
	){
		commentService.putComment(id, commentRequest);
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
}
