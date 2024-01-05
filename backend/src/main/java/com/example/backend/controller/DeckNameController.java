package com.example.backend.controller;

import java.sql.Timestamp;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.entity.Category;
import com.example.backend.repository.CategoryRepository;

import jakarta.transaction.Transactional;


@RestController
@RequestMapping("/api")
public class DeckNameController {

        @Autowired
        CategoryRepository categoryRepository; 

        @Transactional
        @PutMapping("/deck-name")
	public String registerDeckName(@RequestBody Map<String,String> body)  {
        long timeInMillis = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(timeInMillis);

        //　メインカテゴリの登録
        String main = (String) body.get("main");
        Category mainCategory = new Category();
        mainCategory.setCategory(main);        
        mainCategory.setCreatedAt(timestamp);
        categoryRepository.saveAndFlush(mainCategory);  

        //　サブカテゴリの登録
        String sub1 = (String) body.get("sub1");
        Category sub1Category = new Category();
        sub1Category.setCategory(sub1);        
        sub1Category.setCreatedAt(timestamp);
        categoryRepository.saveAndFlush(sub1Category);  

        //　サブカテゴリ2の登録
        String sub2 = (String) body.get("sub2");
        Category sub2Category = new Category();
        sub2Category.setCategory(sub2);        
        sub2Category.setCreatedAt(timestamp);
        categoryRepository.saveAndFlush(sub2Category);  

        return "OK";
	};

}
