package com.example.issuetrackerrest.repository;

import com.example.issuetrackerrest.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long> {

    @Transactional
    List<Issue> findAllByOrderByTitleAsc();

    @Transactional
    List<Issue> findAllByOrderByTitleDesc();

    @Transactional
    List<Issue> findAllByOrderByAssigneeAsc();

    @Transactional
    List<Issue> findAllByOrderByAssigneeDesc();

    @Transactional
    List<Issue> findAllByOrderByCreatedAtAsc();

    @Transactional
    List<Issue> findAllByOrderByCreatedAtDesc();

    @Transactional
    List<Issue> findAllByOrderByUpdatedAtAsc();

    @Transactional
    List<Issue> findAllByOrderByUpdatedAtDesc();

    @Transactional
    List<Issue> findAllByOrderByVotesAsc();

    @Transactional
    List<Issue> findAllByOrderByVotesDesc();

    @Transactional
    List<Issue> findAllByOrderByWatchersDesc();

    @Transactional
    List<Issue> findAllByOrderByWatchersAsc();



    @Transactional
    List<Issue> findAllByPriorityOrderByTitleAsc(priorityEnum priority);

    @Transactional
    List<Issue> findAllByPriorityOrderByTitleDesc(priorityEnum priority);

    @Transactional
    List<Issue> findAllByPriorityOrderByVotesAsc(priorityEnum priority);

    @Transactional
    List<Issue> findAllByPriorityOrderByVotesDesc(priorityEnum priority);

    @Transactional
    List<Issue> findAllByPriorityOrderByAssigneeAsc(priorityEnum priority);

    @Transactional
    List<Issue> findAllByPriorityOrderByAssigneeDesc(priorityEnum priority);

    @Transactional
    List<Issue> findAllByPriorityOrderByWatchersAsc(priorityEnum priority);

    @Transactional
    List<Issue> findAllByPriorityOrderByWatchersDesc(priorityEnum priority);

    @Transactional
    List<Issue> findAllByPriorityOrderByCreatedAtAsc(priorityEnum priority);

    @Transactional
    List<Issue> findAllByPriorityOrderByCreatedAtDesc(priorityEnum priority);

    @Transactional
    List<Issue> findAllByPriorityOrderByUpdatedAtAsc(priorityEnum priority);

    @Transactional
    List<Issue> findAllByPriorityOrderByUpdatedAtDesc(priorityEnum priority);



    @Transactional
    List<Issue> findAllByStatusOrderByTitleAsc(statusEnum statusEnum);

    @Transactional
    List<Issue> findAllByStatusOrderByTitleDesc(statusEnum statusEnum);

    @Transactional
    List<Issue> findAllByStatusOrderByVotesAsc(statusEnum statusEnum);

    @Transactional
    List<Issue> findAllByStatusOrderByVotesDesc(statusEnum statusEnum);

    @Transactional
    List<Issue> findAllByStatusOrderByAssigneeAsc(statusEnum statusEnum);

    @Transactional
    List<Issue> findAllByStatusOrderByAssigneeDesc(statusEnum statusEnum);

    @Transactional
    List<Issue> findAllByStatusOrderByWatchersAsc(statusEnum status);

    @Transactional
    List<Issue> findAllByStatusOrderByWatchersDesc(statusEnum status);

    @Transactional
    List<Issue> findAllByStatusOrderByCreatedAtAsc(statusEnum statusEnum);

    @Transactional
    List<Issue> findAllByStatusOrderByCreatedAtDesc(statusEnum statusEnum);

    @Transactional
    List<Issue> findAllByStatusOrderByUpdatedAtAsc(statusEnum statusEnum);

    @Transactional
    List<Issue> findAllByStatusOrderByUpdatedAtDesc(statusEnum statusEnum);



    @Transactional
    List<Issue> findAllByIssueTypeOrderByTitleAsc(typeEnum kind);

    @Transactional
    List<Issue> findAllByIssueTypeOrderByTitleDesc(typeEnum kind);

    @Transactional
    List<Issue> findAllByIssueTypeOrderByVotesAsc(typeEnum kind);

    @Transactional
    List<Issue> findAllByIssueTypeOrderByVotesDesc(typeEnum kind);

    @Transactional
    List<Issue> findAllByIssueTypeOrderByAssigneeAsc(typeEnum kind);

    @Transactional
    List<Issue> findAllByIssueTypeOrderByAssigneeDesc(typeEnum kind);

    @Transactional
    List<Issue> findAllByIssueTypeOrderByWatchersAsc(typeEnum kind);

    @Transactional
    List<Issue> findAllByIssueTypeOrderByWatchersDesc(typeEnum kind);

    @Transactional
    List<Issue> findAllByIssueTypeOrderByCreatedAtAsc(typeEnum kind);

    @Transactional
    List<Issue> findAllByIssueTypeOrderByCreatedAtDesc(typeEnum kind);

    @Transactional
    List<Issue> findAllByIssueTypeOrderByUpdatedAtAsc(typeEnum kind);

    @Transactional
    List<Issue> findAllByIssueTypeOrderByUpdatedAtDesc(typeEnum kind);



    @Transactional
    List<Issue> findAllByPriority(priorityEnum priority);

    @Transactional
    List<Issue> findAllByIssueType(typeEnum type);

    @Transactional
    List<Issue> findAllByStatus(statusEnum status);

    @Transactional
    List<Issue> findAllByAttachmentListContaining(Attachment a);

    @Transactional
    List<Issue> findAllByAssignee(User assignee);

}
