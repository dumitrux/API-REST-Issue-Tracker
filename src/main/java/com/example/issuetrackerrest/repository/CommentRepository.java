package com.example.issuetrackerrest.repository;

import com.example.issuetrackerrest.entity.Comment;
import com.example.issuetrackerrest.entity.Issue;
import com.example.issuetrackerrest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Transactional
    List<Comment> findAllByIssue(Issue issue);

    @Transactional
    List<Comment> findAllByCreator(User creator);

}
