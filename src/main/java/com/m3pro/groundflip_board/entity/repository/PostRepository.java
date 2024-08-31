package com.m3pro.groundflip_board.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m3pro.groundflip_board.entity.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
