package com.example.backend.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.service.CategoryService;
import com.example.backend.service.DeckService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api")
public class DeckController {
        @Autowired
        CategoryService categoryService;
        @Autowired
        DeckService DeckService;

        @GetMapping("/deck-name")
        public List<String> getMethodName() {

                // デッキ名の取得
                List<String> Decks = DeckService.getDecks();

                return Decks;
        }

        @PutMapping("/deck-name")
        public void registerDeck(@RequestBody Map<String, String> body) {
                // メインカテゴリの登録
                categoryService.registerCategory(body.get("main"));

                // サブカテゴリ1の登録
                categoryService.registerCategory(body.get("sub1"));

                // サブカテゴリ2の登録
                categoryService.registerCategory(body.get("sub2"));

                // デッキ名の登録
                DeckService.registerDeck(body.get("main"), body.get("sub1"), body.get("sub2"));
        }

}
