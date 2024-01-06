package com.example.backend.controller;

import java.sql.Timestamp;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.backend.service.DeckNameService;

@RestController
@RequestMapping("/api")
public class DeckNameController {
        @Autowired
        DeckNameService DeckNameService;

        @PutMapping("/deck-name")
        public String registerDeckName(@RequestBody Map<String, String> body) {
                long timeInMillis = System.currentTimeMillis();
                Timestamp timestamp = new Timestamp(timeInMillis);

                // メインカテゴリの登録
                DeckNameService.registerDeckName(body.get("main"), timestamp);

                // サブカテゴリ1の登録
                DeckNameService.registerDeckName(body.get("sub1"), timestamp);

                // サブカテゴリ2の登録
                DeckNameService.registerDeckName(body.get("sub2"), timestamp);

                return "OK";
        };

}
