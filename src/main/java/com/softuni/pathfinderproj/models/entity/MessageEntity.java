package com.softuni.pathfinderproj.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class MessageEntity extends BaseEntity {

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @Column(name = "text_content",columnDefinition = "TEXT")
    private String textContent;

    @ManyToOne
    private UserEntity author;

    @ManyToOne
    private UserEntity recipient;
}
