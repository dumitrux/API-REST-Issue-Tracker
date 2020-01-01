package com.example.issuetrackerrest.service;

import com.example.issuetrackerrest.entity.Comment;
import com.example.issuetrackerrest.entity.Issue;
import com.example.issuetrackerrest.entity.User;

import java.util.List;

public interface CommentService {

    Comment findCommentById(Long id);

    Comment saveComment(Comment comment);

    List<Comment> findAllComments(Issue issue);

    void deleteCommentById(Long id);
}
