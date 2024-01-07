package com.example.backend.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.entity.Category;
import com.example.backend.repository.CategoryRepository;

import jakarta.transaction.Transactional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Transactional
    public List<String> getCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<String> categoryNames = new ArrayList<>();

        for (Category category : categories) {
            categoryNames.add(category.getCategory());
        }

        return categoryNames;
    }

    @Transactional
    public void registerCategory(String categoryName, Timestamp timestamp) {
        Category category = new Category();
        category.setCategory(categoryName);
        category.setCreatedAt(timestamp);
        categoryRepository.saveAndFlush(category);
    }
}
