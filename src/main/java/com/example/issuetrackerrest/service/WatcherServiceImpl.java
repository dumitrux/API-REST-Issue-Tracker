package com.example.issuetrackerrest.service;

import com.example.issuetrackerrest.entity.Issue;
import com.example.issuetrackerrest.entity.User;
import com.example.issuetrackerrest.entity.Watcher;
import com.example.issuetrackerrest.repository.WatcherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatcherServiceImpl implements WatcherService {

    @Autowired
    private final WatcherRepository mWatcherRepository;

    public WatcherServiceImpl(WatcherRepository mWatcherRepository) {
        this.mWatcherRepository = mWatcherRepository;
    }

    @Override
    public Watcher findWatcherById(Long id) {
        return mWatcherRepository.findById(id).get();
    }

    @Override
    public Watcher findWatcherByUserIssue(Issue issue, User user) {
        return mWatcherRepository.findWatcherByWatchedIssueAndWatchingUser(issue, user);
    }

    @Override
    public Watcher watcherSave(Watcher watcher) {
        return mWatcherRepository.save(watcher);
    }

    @Override
    public void watcherDelete(Watcher watcher) {
        mWatcherRepository.delete(watcher);
    }

    @Override
    public Boolean existsWatcherByWatchedIssueAndWatchingUser(Issue issue, User user) {
        return mWatcherRepository.existsWatcherByWatchedIssueAndWatchingUser(issue, user);
    }

    @Override
    public List<Watcher> findAllWatchers() {
        return mWatcherRepository.findAll();
    }

    @Override
    public List<Watcher> findAllByWatchedIssue(Issue issue) {
        return mWatcherRepository.findAllByWatchedIssue(issue);
    }

    @Override
    public List<Watcher> findAllByWatchingUser(User user) {
        return mWatcherRepository.findAllByWatchingUser(user);
    }
}
