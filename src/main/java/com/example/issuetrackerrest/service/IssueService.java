package com.example.issuetrackerrest.service;

import com.example.issuetrackerrest.entity.*;

import java.util.List;

public interface IssueService {

    Issue findIssueById(Long id);

    List<Issue> findAllIssues();

    Issue saveIssue(Issue issue);

    List<Issue> findAllByPriority(priorityEnum priority);

    List<Issue> findAllByStatus(statusEnum status);

    List<Issue> findAllByIssueType(typeEnum issueType);

    void deleteIssue(Long id);

    List<Issue> findAllByOrderByTitleAsc();

    List<Issue> findAllByOrderByTitleDesc();

    List<Issue> findAllByOrderByAssigneeAsc();

    List<Issue> findAllByOrderByAssigneeDesc();

    List<Issue> findAllByOrderByCreatedAtAsc();

    List<Issue> findAllByOrderByCreatedAtDesc();

    List<Issue> findAllByOrderByUpdatedAtAsc();

    List<Issue> findAllByOrderByUpdatedAtDesc();

    List<Issue> findAllByOrderByVotesAsc();

    List<Issue> findAllByOrderByVotesDesc();

    List<Issue> findAllByOrderByWatchersAsc();

    List<Issue> findAllByOrderByWatchersDesc();



    List<Issue> findAllByPriorityOrderByTitleAsc(priorityEnum priority);

    List<Issue> findAllByPriorityOrderByTitleDesc(priorityEnum priority);

    List<Issue> findAllByPriorityOrderByVotesAsc(priorityEnum priority);

    List<Issue> findAllByPriorityOrderByVotesDesc(priorityEnum priority);

    List<Issue> findAllByPriorityOrderByAssigneeAsc(priorityEnum priority);

    List<Issue> findAllByPriorityOrderByAssigneeDesc(priorityEnum priority);

    List<Issue> findAllByPriorityOrderByWatchersAsc(priorityEnum priority);

    List<Issue> findAllByPriorityOrderByWatchersDesc(priorityEnum priority);

    List<Issue> findAllByPriorityOrderByCreatedAtAsc(priorityEnum priority);

    List<Issue> findAllByPriorityOrderByCreatedAtDesc(priorityEnum priority);

    List<Issue> findAllByPriorityOrderByUpdatedAtAsc(priorityEnum priority);

    List<Issue> findAllByPriorityOrderByUpdatedAtDesc(priorityEnum priority);


    List<Issue> findAllByStatusOrderByTitleAsc(statusEnum statusEnum);

    List<Issue> findAllByStatusOrderByTitleDesc(statusEnum statusEnum);

    List<Issue> findAllByStatusOrderByVotesAsc(statusEnum statusEnum);

    List<Issue> findAllByStatusOrderByVotesDesc(statusEnum statusEnum);

    List<Issue> findAllByStatusOrderByAssigneeAsc(statusEnum statusEnum);

    List<Issue> findAllByStatusOrderByAssigneeDesc(statusEnum statusEnum);

    List<Issue> findAllByStatusOrderByWatchersAsc(statusEnum status);

    List<Issue> findAllByStatusOrderByWatchersDesc(statusEnum status);

    List<Issue> findAllByStatusOrderByCreatedAtAsc(statusEnum statusEnum);

    List<Issue> findAllByStatusOrderByCreatedAtDesc(statusEnum statusEnum);

    List<Issue> findAllByStatusOrderByUpdatedAtAsc(statusEnum statusEnum);

    List<Issue> findAllByStatusOrderByUpdatedAtDesc(statusEnum statusEnum);

    List<Issue> findAllByIssueTypeOrderByTitleAsc(typeEnum kind);

    List<Issue> findAllByIssueTypeOrderByTitleDesc(typeEnum kind);

    List<Issue> findAllByIssueTypeOrderByVotesAsc(typeEnum kind);

    List<Issue> findAllByIssueTypeOrderByVotesDesc(typeEnum kind);

    List<Issue> findAllByIssueTypeOrderByAssigneeAsc(typeEnum kind);

    List<Issue> findAllByIssueTypeOrderByAssigneeDesc(typeEnum kind);

    List<Issue> findAllByIssueTypeOrderByWatchersAsc(typeEnum kind);

    List<Issue> findAllByIssueTypeOrderByWatchersDesc(typeEnum kind);

    List<Issue> findAllByIssueTypeOrderByCreatedAtAsc(typeEnum kind);

    List<Issue> findAllByIssueTypeOrderByCreatedAtDesc(typeEnum kind);

    List<Issue> findAllByIssueTypeOrderByUpdatedAtAsc(typeEnum kind);

    List<Issue> findAllByIssueTypeOrderByUpdatedAtDesc(typeEnum kind);





    List<Issue> findAllByAttachmentListContaining(Attachment a);


    List<Issue> findAllByAssignee(User assignee);



}
