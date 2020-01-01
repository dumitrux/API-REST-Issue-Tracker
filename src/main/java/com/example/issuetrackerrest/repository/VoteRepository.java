package com.example.issuetrackerrest.repository;

import com.example.issuetrackerrest.entity.Issue;
import com.example.issuetrackerrest.entity.User;
import com.example.issuetrackerrest.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {

    @Transactional
    Vote findVoteByVotedIssueAndVotingUser(Issue issue, User user);

    @Transactional
    Boolean existsVoteByVotedIssueAndVotingUser(Issue issue, User user);



    @Transactional
    List<Vote> findAllByVotedIssue(Issue issue);
}
