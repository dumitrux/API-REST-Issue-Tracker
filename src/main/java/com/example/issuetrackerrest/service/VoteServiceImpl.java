package com.example.issuetrackerrest.service;

import com.example.issuetrackerrest.entity.Issue;
import com.example.issuetrackerrest.entity.User;
import com.example.issuetrackerrest.entity.Vote;
import com.example.issuetrackerrest.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteServiceImpl implements VoteService {

    @Autowired
    private final VoteRepository mVoteRepository;

    public VoteServiceImpl(VoteRepository mVoteRepository) {
        this.mVoteRepository = mVoteRepository;
    }

    @Override
    public Vote findVoteById(Long id) {
        return mVoteRepository.findById(id).get();
    }

    @Override
    public Vote findVoteByUserIssue(Issue issue, User user) {
        return mVoteRepository.findVoteByVotedIssueAndVotingUser(issue, user);
    }

    @Override
    public Vote voteSave(Vote vote) {
        return mVoteRepository.save(vote);
    }

    public void voteDelete(Vote vote) { mVoteRepository.delete(vote); }

    @Override
    public Boolean existsVoteByVotedIssueAndVotingUser(Issue issue, User votingUser) {
        return mVoteRepository.existsVoteByVotedIssueAndVotingUser(issue, votingUser);
    }

    @Override
    public List<Vote> findAllVotes() {
        return mVoteRepository.findAll();
    }

    @Override
    public List<Vote> findAllByVotedIssue(Issue issue) {
        return mVoteRepository.findAllByVotedIssue(issue);
    }
}
