package com.example.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.service.RecordService;
import com.example.backend.entity.Record;

@RestController
@RequestMapping("/api")
public class RecordController {
    @Autowired
    RecordService recordService;

    @PutMapping("/records")
    public void registerRecord(@RequestBody Record body) {

        // 戦績の登録
        recordService.registerRecord(body);
    }

}