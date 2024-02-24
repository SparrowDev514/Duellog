package com.example.backend.entity;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Deck {

    @Id
    @Column(length = 500)
    private String DeckName;

    @Column(length = 100, nullable = false)
    private String mainCategory;

    @Column(length = 100)
    private String sub1Category;

    @Column(length = 100)
    private String sub2Category;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

}
