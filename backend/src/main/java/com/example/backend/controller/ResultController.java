package com.example.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.entity.Result;
import com.example.backend.service.ResultService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api")
public class ResultController {
    @Autowired
    ResultService resultService;

    @GetMapping("/result")
    public Result getMethodName(@RequestParam(name = "deckName", defaultValue = "") String deckName) {
        Result result = resultService.getResult(deckName);
        return result;
    }

}
