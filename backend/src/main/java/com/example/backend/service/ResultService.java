package com.example.backend.service;

import java.util.ArrayList;
import java.util.List;

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
        Long numOfButtle = deckName.isEmpty() ? recordRepository.count() : recordRepository.countByMyDeck(deckName);

        // 分母がゼロの時は早めに抜ける
        if (numOfButtle == 0) {
            result.setNumOfButtle((long) 0);
            return result;
        }

        Long numOfwin = deckName.isEmpty() ? recordRepository.countByIsWon(true)
                : recordRepository.countByMyDeckAndIsWon(deckName, true);
        Long numOfFirst = deckName.isEmpty() ? recordRepository.countByIsFirst(true)
                : recordRepository.countByMyDeckAndIsFirst(deckName, true);

        // 各種値をset
        result.setNumOfButtle(numOfButtle);
        result.setWinRatio(Math.floor(((double) numOfwin / numOfButtle) * 100) / 100.0);
        result.setFirstRatio(Math.floor(((double) numOfFirst / numOfButtle) * 100) / 100.0);

        return result;
    }

    @Transactional
    public List<Result> getResultDetail(String deckName) {
        // 対戦したデッキをリストで取得
        List<String> opponentDecks = deckName.isEmpty() ? recordRepository.getOpponentDecks()
                : recordRepository.getOpponentDecksByMyDeck(deckName);
        List<Result> Results = new ArrayList<>();

        // 対戦したデッキをもとに戦績を取得
        for (String opponentDeck : opponentDecks) {
            Result result = new Result();
            Long numOfButtle = deckName.isEmpty() ? recordRepository.countByOpponentDeckCategory(opponentDeck)
                    : recordRepository.countByMyDeckAndOpponentDeckCategory(deckName, opponentDeck);

            // 分母がゼロの時は早めに抜ける
            if (numOfButtle == 0) {
                continue;
            }

            Long numOfwin = deckName.isEmpty()
                    ? recordRepository.countByOpponentDeckCategoryAndIsWon(opponentDeck, true)
                    : recordRepository.countByMyDeckAndOpponentDeckCategoryAndIsWon(deckName, opponentDeck,
                            true);
            Long numOfFirst = deckName.isEmpty()
                    ? recordRepository.countByOpponentDeckCategoryAndIsFirst(opponentDeck, true)
                    : recordRepository.countByMyDeckAndOpponentDeckCategoryAndIsFirst(deckName,
                            opponentDeck, true);

            // 各種値をset
            result.setNumOfButtle(numOfButtle);
            result.setOpponentDeck(opponentDeck);
            result.setWinRatio(Math.floor(((double) numOfwin / numOfButtle) * 100) / 100.0);
            result.setFirstRatio(Math.floor(((double) numOfFirst / numOfButtle) * 100) / 100.0);

            // 配列に追加
            Results.add(result);
        }

        return Results;

    }
}