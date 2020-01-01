package com.example.issuetrackerrest.service;

import com.example.issuetrackerrest.entity.Comment;
import com.example.issuetrackerrest.entity.Issue;
import com.example.issuetrackerrest.entity.User;
import com.example.issuetrackerrest.repository.CommentRepository;
import com.example.issuetrackerrest.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository mCommentRepository;

    @Override
    public Comment findCommentById(Long id) {
        return mCommentRepository.findById(id).get();
    }

    @Override
    public Comment saveComment(Comment comment) {
        return mCommentRepository.save(comment);
    }

    @Override
    public List<Comment> findAllComments(Issue issue) {
        return mCommentRepository.findAllByIssue(issue);
    }

    @Override
    public void deleteCommentById(Long id) {
        mCommentRepository.deleteById(id);
    }

}
