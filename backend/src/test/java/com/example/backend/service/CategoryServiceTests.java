package com.example.backend.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.example.backend.entity.Category;
import com.example.backend.repository.CategoryRepository;

public class CategoryServiceTests {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Mockitoを使用する場合に必要
    }

    @Test
    void getCategoriesTest() {
        // categoriesを作る
        Category category1 = new Category();
        category1.setCategoryName("category1");
        category1.setCreatedAt(null);

        Category category2 = new Category();
        category2.setCategoryName("category2");
        category2.setCreatedAt(null);

        List<Category> categories = Arrays.asList(category1, category2);

        Mockito.when(categoryRepository.findAll()).thenReturn(categories);

        // getCategoriesの処理
        List<String> categoryNames = categoryService.getCategories();

        assertNotNull(categoryNames);
        assertEquals(Arrays.asList("category1", "category2"), categoryNames);
    }

    @Test
    void registerCategoryTest1() {
        assertEquals(new Category(), categoryService.registerCategory(null));
    }

    @Test
    void registerCategoryTest2() {

        Category category = new Category();
        category.setCategoryName("categoryNameForTest");

        // DBにモックする内容を作る
        Category dbMockCategories = new Category();
        dbMockCategories.setCategoryName("categoryNameForTest");

        Mockito.when(categoryRepository.saveAndFlush(any(Category.class))).thenReturn(dbMockCategories);

        Category registeredCategory = categoryService.registerCategory("categoryNameForTest");

        assertEquals(category, registeredCategory);

    }
}
