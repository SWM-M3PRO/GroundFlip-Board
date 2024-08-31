package com.m3pro.groundflip_board.entity.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Schema(title = "댓글 정보")
public class CommentRequest {

	@Schema(description = "댓글 내용", example = "안녕하세요")
	private String content;

	@Schema(description = "유저 id", example = "622")
	private Long userId;

	@Schema(description = "게시글 id", example = "1")
	private Long postId;

}
