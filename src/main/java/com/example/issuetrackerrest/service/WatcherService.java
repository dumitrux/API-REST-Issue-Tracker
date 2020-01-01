package com.example.issuetrackerrest.service;

import com.example.issuetrackerrest.entity.Issue;
import com.example.issuetrackerrest.entity.User;
import com.example.issuetrackerrest.entity.Watcher;

import java.util.List;

public interface WatcherService {

    Watcher findWatcherById(Long id);

    Watcher findWatcherByUserIssue(Issue issue, User user);

    Watcher watcherSave(Watcher watcher);

    void watcherDelete(Watcher watcher);

    Boolean existsWatcherByWatchedIssueAndWatchingUser(Issue issue, User user);

    List<Watcher> findAllWatchers();

    List<Watcher> findAllByWatchedIssue(Issue issue);

    List<Watcher> findAllByWatchingUser(User user);

}
