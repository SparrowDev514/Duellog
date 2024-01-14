package com.example.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.service.CategoryService;
import com.example.backend.service.RecordService;
import com.example.backend.entity.Record;

@RestController
@RequestMapping("/api")
public class RecordController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    RecordService recordService;

    @PutMapping("/records")
    public void registerRecord(@RequestBody Record body) {

        // 相手デッキカテゴリの登録
        if (body.getOpponentDeckCategory() != null)
            categoryService.registerCategory(body.getOpponentDeckCategory());

        // 戦績の登録
        recordService.registerRecord(body);
    }

}