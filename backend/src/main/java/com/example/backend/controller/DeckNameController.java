package com.example.backend.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.service.CategoryService;
import com.example.backend.service.DeckNameService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api")
public class DeckNameController {
        @Autowired
        CategoryService categoryService;
        @Autowired
        DeckNameService deckNameService;

        @GetMapping("/deck-name")
        public List<String> getMethodName() {

                // デッキ名の取得
                List<String> deckNames = deckNameService.getDeckNames();

                return deckNames;
        }

        @PutMapping("/deck-name")
        public void registerDeckName(@RequestBody Map<String, String> body) {

                // メインカテゴリの登録
                categoryService.registerCategory(body.get("main"));

                // サブカテゴリ1の登録
                if (body.get("sub1") != null) {
                        categoryService.registerCategory(body.get("sub1"));
                }

                // サブカテゴリ2の登録
                if (body.get("sub2") != null) {
                        categoryService.registerCategory(body.get("sub2"));
                }

                // デッキ名の登録
                deckNameService.registerDeckName(body.get("main"), body.get("sub1"), body.get("sub2"));
        }

}
