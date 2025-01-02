package com.example.writeonthewall.repository;

import com.example.writeonthewall.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}