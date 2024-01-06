package com.example.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Category {

    @Id
    @Column(length = 10)
    private String category;

    @Column(length = 20)
    private java.sql.Timestamp createdAt;

}
