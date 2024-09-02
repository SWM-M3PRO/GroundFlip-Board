package com.m3pro.groundflip_board.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m3pro.groundflip_board.entity.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

	List<Post> findByUserId(Long UserId);
}
