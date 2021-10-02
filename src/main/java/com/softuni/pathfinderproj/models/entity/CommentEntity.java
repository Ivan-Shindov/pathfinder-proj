package com.softuni.pathfinderproj.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class CommentEntity extends BaseEntity {

    @Column(nullable = false)
    private boolean approved;

    @Column(nullable = false)
    private LocalDateTime created;

    @Column(name = "text_content",nullable = false, columnDefinition = "TEXT")
    private String textContent;

    @ManyToOne
    private UserEntity author;

    @ManyToOne
    private RouteEntity route;

    public boolean isApproved() {
        return approved;
    }

    public CommentEntity setApproved(boolean approved) {
        this.approved = approved;
        return this;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public CommentEntity setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    public String getTextContent() {
        return textContent;
    }

    public CommentEntity setTextContent(String textContent) {
        this.textContent = textContent;
        return this;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public CommentEntity setAuthor(UserEntity author) {
        this.author = author;
        return this;
    }

    public RouteEntity getRoute() {
        return route;
    }

    public CommentEntity setRoute(RouteEntity route) {
        this.route = route;
        return this;
    }
}
