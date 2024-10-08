package com.m3pro.groundflip_board.entity.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Schema(title = "게시글 정보")
public class PostRequest {

	@Schema(description = "게시글 내용", example = "안녕하세요")
	private String content;

	@Schema(description = "게시글 제목", example = "제목")
	private String title;

	@Schema(description = "유저 id", example = "622")
	private Long userId;

}
