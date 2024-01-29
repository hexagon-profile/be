package com.example.hexagon.post.repository;

import com.example.hexagon.post.dto.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostJpaRepository extends JpaRepository<Post, Long> {

}
