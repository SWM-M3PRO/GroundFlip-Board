package com.m3pro.groundflip_board.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.m3pro.groundflip_board.entity.dto.PostRequest;
import com.m3pro.groundflip_board.entity.entity.Post;
import com.m3pro.groundflip_board.service.PostService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Tag(name = "post", description = "게시글 API")
public class PostController {

	private final PostService postService;

	@Operation(summary = "사용자 게시글 저장", description = "title, content, id저장")
	@PostMapping("/post")
	public ResponseEntity<Integer> postPost(
		@Parameter(description = "게시글 info", required = true)
		@RequestBody PostRequest postRequest) {
		postService.createPost(postRequest);
		return ResponseEntity.ok(201);
	}

	@Operation(summary = "게시글 수정", description = "title, content 수정")
	@PutMapping("/post/{postId}")
	public ResponseEntity<Integer> putPost(
		@Parameter(description = "게시글 info", required = true)
		@PathVariable Long postId,
		@RequestBody PostRequest postRequest
	) {
		postService.putPost(postId, postRequest);
		return ResponseEntity.ok(200);
	}

	@Operation(summary = "게시글 삭제", description = "게시글 삭제")
	@DeleteMapping("/post/{postId}")
	public ResponseEntity<Integer> deletePost(
		@Parameter(description = "게시글 info", required = true)
		@PathVariable Long postId
	){
		postService.deletePost(postId);
		return ResponseEntity.ok(200);
	}

}
