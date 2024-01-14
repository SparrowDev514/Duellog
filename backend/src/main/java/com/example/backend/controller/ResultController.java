package com.example.backend.controller;

import java.util.List;

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
    public Result getResult(@RequestParam(name = "deckName", defaultValue = "") String deckName) {
        Result result = resultService.getResult(deckName);
        return result;
    }

    @GetMapping("/result/detail")
    public List<Result> getResultDetail(@RequestParam(name = "deckName", defaultValue = "") String deckName) {
        List<Result> result = resultService.getResultDetail(deckName);
        return result;
    }

}
