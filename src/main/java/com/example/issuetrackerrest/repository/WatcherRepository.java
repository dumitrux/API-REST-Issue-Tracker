package com.example.issuetrackerrest.repository;

import com.example.issuetrackerrest.entity.Issue;
import com.example.issuetrackerrest.entity.User;
import com.example.issuetrackerrest.entity.Watcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface WatcherRepository extends JpaRepository<Watcher, Long> {

    @Transactional
    Watcher findWatcherByWatchedIssueAndWatchingUser(Issue issue, User user);

    @Transactional
    Boolean existsWatcherByWatchedIssueAndWatchingUser(Issue issue, User user);

    @Transactional
    List<Watcher> findAllByWatchedIssue(Issue issue);

    @Transactional
    List<Watcher> findAllByWatchingUser(User user);
}
