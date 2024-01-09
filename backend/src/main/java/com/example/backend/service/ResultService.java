package com.example.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.entity.Result;
import com.example.backend.repository.RecordRepository;

import jakarta.transaction.Transactional;

@Service
public class ResultService {
    @Autowired
    RecordRepository recordRepository;

    @Transactional
    public Result getResult(String deckName) {
        Result result = new Result();
        Long numOfButtle = deckName.isEmpty() ? recordRepository.count() : recordRepository.countByMyDeckName(deckName);

        // 分母がゼロの時は早めに抜ける
        if (numOfButtle == 0) {
            result.setNumOfButtle((long) 0);
            return result;
        }

        Long numOfwin = deckName.isEmpty() ? recordRepository.countByIsWon(true)
                : recordRepository.countByMyDeckNameAndIsWon(deckName, true);
        Long numOfFirst = deckName.isEmpty() ? recordRepository.countByIsFirst(true)
                : recordRepository.countByMyDeckNameAndIsFirst(deckName, true);

        // 各種値をset
        result.setNumOfButtle(numOfButtle);
        result.setWinRatio(Math.floor(((double) numOfwin / numOfButtle) * 100) / 100.0);
        result.setFirstRatio(Math.floor(((double) numOfFirst / numOfButtle) * 100) / 100.0);

        return result;
    }
}