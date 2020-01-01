package com.example.issuetrackerrest.service;

import com.example.issuetrackerrest.entity.*;
import com.example.issuetrackerrest.repository.IssueRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueServiceImpl implements IssueService {

    @Autowired
    private final IssueRepository mIssueRepository;

    public IssueServiceImpl(IssueRepository mIssueRepository) {
        this.mIssueRepository = mIssueRepository;
    }

    @Override
    public Issue findIssueById(Long id) {
        return mIssueRepository.findById(id).get();
    }

    @Override
    public List<Issue> findAllIssues() {
       /* List<Issue> issues = new ArrayList<Issue>();
        mIssueRepository.findAll().forEach(issue -> issues.add(issue));
        return issues;*/
        return mIssueRepository.findAll();
    }

    @Override
    public List<Issue> findAllByPriority(priorityEnum priority) {
        return mIssueRepository.findAllByPriority(priority);
    }

    @Override
    public Issue saveIssue(Issue issue) {
        return mIssueRepository.save(issue);
    }

    @Override
    public List<Issue> findAllByStatus(statusEnum status) {
        return mIssueRepository.findAllByStatus(status);
    }

    @Override
    public List<Issue> findAllByIssueType(typeEnum issueType) {
        return mIssueRepository.findAllByIssueType(issueType);
    }


    @Override
    public List<Issue> findAllByOrderByTitleAsc() {
        return mIssueRepository.findAllByOrderByTitleAsc();
    }

    @Override
    public List<Issue> findAllByOrderByTitleDesc() {
        return mIssueRepository.findAllByOrderByTitleDesc();
    }

    @Override
    public List<Issue> findAllByOrderByAssigneeAsc() {
        return mIssueRepository.findAllByOrderByAssigneeAsc();
    }

    @Override
    public List<Issue> findAllByOrderByAssigneeDesc() {
        return mIssueRepository.findAllByOrderByAssigneeDesc();
    }

    @Override
    public List<Issue> findAllByOrderByCreatedAtAsc() {
        return mIssueRepository.findAllByOrderByCreatedAtAsc();
    }

    @Override
    public List<Issue> findAllByOrderByCreatedAtDesc() {
        return mIssueRepository.findAllByOrderByCreatedAtDesc();
    }

    @Override
    public List<Issue> findAllByOrderByUpdatedAtAsc() {
        return mIssueRepository.findAllByOrderByUpdatedAtAsc();
    }

    @Override
    public List<Issue> findAllByOrderByUpdatedAtDesc() {
        return mIssueRepository.findAllByOrderByUpdatedAtDesc();
    }

    @Override
    public List<Issue> findAllByOrderByVotesAsc() {
        return mIssueRepository.findAllByOrderByVotesAsc();
    }

    @Override
    public List<Issue> findAllByOrderByVotesDesc() {
        return mIssueRepository.findAllByOrderByVotesDesc();
    }

    @Override
    public List<Issue> findAllByOrderByWatchersAsc() {
        return mIssueRepository.findAllByOrderByWatchersAsc();
    }

    @Override
    public List<Issue> findAllByOrderByWatchersDesc() {
        return mIssueRepository.findAllByOrderByWatchersDesc();
    }

    @Override
    public void deleteIssue(Long id) {
        //FALTA BORRAR COMENTARIS

        mIssueRepository.deleteById(id);
    }


    @Override
    public List<Issue> findAllByPriorityOrderByTitleAsc(priorityEnum priority) {
        return mIssueRepository.findAllByPriorityOrderByTitleAsc(priority);
    }

    @Override
    public List<Issue> findAllByPriorityOrderByTitleDesc(priorityEnum priority) {
        return mIssueRepository.findAllByPriorityOrderByTitleDesc(priority);
    }

    @Override
    public List<Issue> findAllByPriorityOrderByVotesAsc(priorityEnum priority) {
        return mIssueRepository.findAllByPriorityOrderByVotesAsc(priority);
    }

    @Override
    public List<Issue> findAllByPriorityOrderByVotesDesc(priorityEnum priority) {
        return mIssueRepository.findAllByPriorityOrderByVotesDesc(priority);
    }

    @Override
    public List<Issue> findAllByPriorityOrderByAssigneeAsc(priorityEnum priority) {
        return mIssueRepository.findAllByPriorityOrderByAssigneeAsc(priority);
    }

    @Override
    public List<Issue> findAllByPriorityOrderByAssigneeDesc(priorityEnum priority) {
        return mIssueRepository.findAllByPriorityOrderByAssigneeDesc(priority);
    }

    @Override
    public List<Issue> findAllByPriorityOrderByWatchersAsc(priorityEnum priority) {
        return mIssueRepository.findAllByPriorityOrderByWatchersAsc(priority);
    }

    @Override
    public List<Issue> findAllByPriorityOrderByWatchersDesc(priorityEnum priority) {
        return mIssueRepository.findAllByPriorityOrderByWatchersDesc(priority);
    }

    @Override
    public List<Issue> findAllByPriorityOrderByCreatedAtAsc(priorityEnum priority) {
        return mIssueRepository.findAllByPriorityOrderByCreatedAtAsc(priority);
    }

    @Override
    public List<Issue> findAllByPriorityOrderByCreatedAtDesc(priorityEnum priority) {
        return mIssueRepository.findAllByPriorityOrderByCreatedAtDesc(priority);
    }

    @Override
    public List<Issue> findAllByPriorityOrderByUpdatedAtAsc(priorityEnum priority) {
        return mIssueRepository.findAllByPriorityOrderByUpdatedAtAsc(priority);
    }

    @Override
    public List<Issue> findAllByPriorityOrderByUpdatedAtDesc(priorityEnum priority) {
        return mIssueRepository.findAllByPriorityOrderByUpdatedAtDesc(priority);
    }

    @Override
    public List<Issue> findAllByStatusOrderByTitleAsc(statusEnum statusEnum) {
        return mIssueRepository.findAllByStatusOrderByTitleAsc(statusEnum);
    }

    @Override
    public List<Issue> findAllByStatusOrderByTitleDesc(statusEnum statusEnum) {
        return mIssueRepository.findAllByStatusOrderByTitleDesc(statusEnum);
    }

    @Override
    public List<Issue> findAllByStatusOrderByVotesAsc(statusEnum statusEnum) {
        return mIssueRepository.findAllByStatusOrderByVotesAsc(statusEnum);
    }

    @Override
    public List<Issue> findAllByStatusOrderByVotesDesc(statusEnum statusEnum) {
        return mIssueRepository.findAllByStatusOrderByVotesDesc(statusEnum);
    }

    @Override
    public List<Issue> findAllByStatusOrderByAssigneeAsc(statusEnum statusEnum) {
        return mIssueRepository.findAllByStatusOrderByAssigneeAsc(statusEnum);
    }

    @Override
    public List<Issue> findAllByStatusOrderByAssigneeDesc(statusEnum statusEnum) {
        return mIssueRepository.findAllByStatusOrderByAssigneeDesc(statusEnum);
    }

    @Override
    public List<Issue> findAllByStatusOrderByWatchersAsc(statusEnum status) {
        return mIssueRepository.findAllByStatusOrderByWatchersAsc(status);
    }

    @Override
    public List<Issue> findAllByStatusOrderByWatchersDesc(statusEnum status) {
        return mIssueRepository.findAllByStatusOrderByWatchersDesc(status);
    }

    @Override
    public List<Issue> findAllByStatusOrderByCreatedAtAsc(statusEnum statusEnum) {
        return mIssueRepository.findAllByStatusOrderByCreatedAtAsc(statusEnum);
    }

    @Override
    public List<Issue> findAllByStatusOrderByCreatedAtDesc(statusEnum statusEnum) {
        return mIssueRepository.findAllByStatusOrderByCreatedAtDesc(statusEnum);
    }

    @Override
    public List<Issue> findAllByStatusOrderByUpdatedAtAsc(statusEnum statusEnum) {
        return mIssueRepository.findAllByStatusOrderByUpdatedAtAsc(statusEnum);
    }

    @Override
    public List<Issue> findAllByStatusOrderByUpdatedAtDesc(statusEnum statusEnum) {
        return mIssueRepository.findAllByStatusOrderByUpdatedAtDesc(statusEnum);
    }

    @Override
    public List<Issue> findAllByIssueTypeOrderByTitleAsc(typeEnum kind) {
        return mIssueRepository.findAllByIssueTypeOrderByTitleAsc(kind);
    }

    @Override
    public List<Issue> findAllByIssueTypeOrderByTitleDesc(typeEnum kind) {
        return mIssueRepository.findAllByIssueTypeOrderByTitleDesc(kind);
    }

    @Override
    public List<Issue> findAllByIssueTypeOrderByVotesAsc(typeEnum kind) {
        return mIssueRepository.findAllByIssueTypeOrderByVotesAsc(kind);
    }

    @Override
    public List<Issue> findAllByIssueTypeOrderByVotesDesc(typeEnum kind) {
        return mIssueRepository.findAllByIssueTypeOrderByVotesDesc(kind);
    }

    @Override
    public List<Issue> findAllByIssueTypeOrderByAssigneeAsc(typeEnum kind) {
        return mIssueRepository.findAllByIssueTypeOrderByAssigneeAsc(kind);
    }

    @Override
    public List<Issue> findAllByIssueTypeOrderByAssigneeDesc(typeEnum kind) {
        return mIssueRepository.findAllByIssueTypeOrderByAssigneeDesc(kind);
    }

    @Override
    public List<Issue> findAllByIssueTypeOrderByWatchersAsc(typeEnum kind) {
        return mIssueRepository.findAllByIssueTypeOrderByWatchersAsc(kind);
    }

    @Override
    public List<Issue> findAllByIssueTypeOrderByWatchersDesc(typeEnum kind) {
        return mIssueRepository.findAllByIssueTypeOrderByWatchersDesc(kind);
    }

    @Override
    public List<Issue> findAllByIssueTypeOrderByCreatedAtAsc(typeEnum kind) {
        return mIssueRepository.findAllByIssueTypeOrderByCreatedAtAsc(kind);
    }

    @Override
    public List<Issue> findAllByIssueTypeOrderByCreatedAtDesc(typeEnum kind) {
        return mIssueRepository.findAllByIssueTypeOrderByCreatedAtDesc(kind);
    }

    @Override
    public List<Issue> findAllByIssueTypeOrderByUpdatedAtAsc(typeEnum kind) {
        return mIssueRepository.findAllByIssueTypeOrderByUpdatedAtAsc(kind);
    }

    @Override
    public List<Issue> findAllByIssueTypeOrderByUpdatedAtDesc(typeEnum kind) {
        return mIssueRepository.findAllByIssueTypeOrderByUpdatedAtDesc(kind);
    }

    @Override
    public List<Issue> findAllByAttachmentListContaining(Attachment a) {
        return mIssueRepository.findAllByAttachmentListContaining(a);
    }

    @Override
    public List<Issue> findAllByAssignee(User assignee) {
        return mIssueRepository.findAllByAssignee(assignee);
    }
}
