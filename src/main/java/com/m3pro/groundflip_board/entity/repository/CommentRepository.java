package com.m3pro.groundflip_board.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m3pro.groundflip_board.entity.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	List<Comment> findByPostId(Long postId);

	List<Comment> findByUserId(Long userId);
}
