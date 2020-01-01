package com.example.issuetrackerrest.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Set;

// EJEMPLO3 para detallar los modelos
@ApiModel(description = "Detalls sobre els issues")
@Data
@Entity
public class Issue {

    // EJEMPLO4  para detallar los atributos de los modelos
    @ApiModelProperty(notes = "L'identificador dels issues")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String title;

    @ManyToOne
    private User assignee;

    @NotNull
    private typeEnum issueType;

    @NotNull
    private priorityEnum priority;

    @NotNull
    private statusEnum status;

    private String description;

    private int votes;

    private int watchers;

    private Date createdAt;

    private Date updatedAt;

    @OneToMany
    private Set<Attachment> attachmentList;

    @ManyToOne
    private User creator;

    public Issue() {
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User user) {
        this.assignee = user;
    }

    public typeEnum getIssueType() {
        return issueType;
    }

    public void setIssueType(typeEnum issueType) {
        this.issueType = issueType;
    }

    public priorityEnum getPriority() {
        return priority;
    }

    public void setPriority(priorityEnum priority) {
        this.priority = priority;
    }

    public statusEnum getStatus() {
        return status;
    }

    public void setStatus(statusEnum status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public int getWatchers() {
        return watchers;
    }

    public void setWatchers(int watchers) {
        this.watchers = watchers;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Set<Attachment> getAttachmentList() {
        return attachmentList;
    }

    public void setAttachmentList(Set<Attachment> attachmentList) {
        this.attachmentList = attachmentList;
    }
}
