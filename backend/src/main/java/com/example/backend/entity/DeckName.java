package com.example.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class DeckName {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;

    @Column(length = 500, nullable = false)
    private String deckName;

    @Column(length = 100, nullable = false)
    private String mainCategory;

    @Column(length = 100)
    private String sub1Category;

    @Column(length = 100)
    private String sub2Category;

    @Column(length = 200, nullable = false)
    private java.sql.Timestamp createdAt;

}
