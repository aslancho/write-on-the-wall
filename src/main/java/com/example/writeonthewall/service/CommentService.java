package com.example.writeonthewall.service;

import com.example.writeonthewall.model.Comment;
import com.example.writeonthewall.model.User;
import com.example.writeonthewall.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public void addComment(String content, User user) {
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setUser(user);
        commentRepository.save(comment);
    }
}