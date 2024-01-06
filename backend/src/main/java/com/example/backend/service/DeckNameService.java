package com.example.backend.service;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.entity.Category;
import com.example.backend.repository.CategoryRepository;

import jakarta.transaction.Transactional;

@Service
public class DeckNameService {

    @Autowired
    CategoryRepository categoryRepository;

    @Transactional
    public void registerDeckName(String categoryName, Timestamp timestamp) {
        Category category = new Category();
        category.setCategory(categoryName);
        category.setCreatedAt(timestamp);
        categoryRepository.saveAndFlush(category);
    }
}
