package com.example.backend.controller;

import java.sql.Timestamp;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.service.CategoryService;
import com.example.backend.service.DeckNameService;

@RestController
@RequestMapping("/api")
public class DeckNameController {
        @Autowired
        CategoryService categoryService;
        @Autowired
        DeckNameService deckNameService;

        @PutMapping("/deck-name")
        public void registerDeckName(@RequestBody Map<String, String> body) {
                long timeInMillis = System.currentTimeMillis();
                Timestamp timestamp = new Timestamp(timeInMillis);

                // メインカテゴリの登録
                categoryService.registerCategory(body.get("main"), timestamp);

                // サブカテゴリ1の登録
                if (body.get("sub1") != null) {
                        categoryService.registerCategory(body.get("sub1"), timestamp);
                }

                // サブカテゴリ2の登録
                if (body.get("sub2") != null) {
                        categoryService.registerCategory(body.get("sub2"), timestamp);
                }

                // デッキ名の登録
                deckNameService.registerDeckName(body.get("main"), body.get("sub1"), body.get("sub2"), timestamp);
        }

}
