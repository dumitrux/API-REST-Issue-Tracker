package com.example.issuetrackerrest.service;

import com.example.issuetrackerrest.entity.Issue;
import com.example.issuetrackerrest.entity.User;
import com.example.issuetrackerrest.entity.Vote;

import java.util.List;

public interface VoteService {

    Vote findVoteById (Long id);

    Vote findVoteByUserIssue(Issue issue, User votingUser);

    Vote voteSave(Vote vote);

    void voteDelete(Vote vote);

    Boolean existsVoteByVotedIssueAndVotingUser(Issue issue, User votingUser);

    List<Vote> findAllVotes();

    List<Vote> findAllByVotedIssue(Issue issue);

}
