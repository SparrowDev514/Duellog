package com.example.backend.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;

    @Column(length=10, nullable = false)
    private String category;

    @Column(length=20, nullable = false)
    private  java.sql.Timestamp createdAt;

    public long getId(){
        return id;
    }

    public String getCategory(){
        return category;
    }

    public Timestamp getCreatedAt(){
        return createdAt;
    }

    public void setId(long id){
        this.id = id;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public void setCreatedAt(java.sql.Timestamp createdAt){
        this.createdAt = createdAt;
    }
}
