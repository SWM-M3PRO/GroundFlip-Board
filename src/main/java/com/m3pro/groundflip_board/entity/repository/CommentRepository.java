package com.m3pro.groundflip_board.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m3pro.groundflip_board.entity.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
