package com.example.backend.service;

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
            categoryNames.add(category.getCategoryName());
        }

        return categoryNames;
    }

    @Transactional
    public Category registerCategory(String categoryName) {
        // categoryNameがない場合は処理を行わない
        if (categoryName == null)
            return new Category();

        Category category = new Category();
        category.setCategoryName(categoryName);
        Category savedCategory = categoryRepository.saveAndFlush(category);
        return savedCategory;

    }
}
