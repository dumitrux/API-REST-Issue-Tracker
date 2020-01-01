package com.example.issuetrackerrest.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Watcher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private User watchingUser;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Issue watchedIssue;
}
