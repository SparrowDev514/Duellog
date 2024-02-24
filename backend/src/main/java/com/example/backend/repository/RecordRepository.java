package com.example.backend.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.backend.entity.Record;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
    Long countByMyDeck(String myDeck);

    Long countByIsWon(Boolean isWon);

    Long countByIsFirst(Boolean isFirst);

    Long countByMyDeckAndIsWon(String myDeck, Boolean isWon);

    Long countByMyDeckAndIsFirst(String myDeck, Boolean isFirst);

    @Query("SELECT DISTINCT r.opponentDeckCategory FROM Record r")
    List<String> getOpponentDecks();

    @Query("SELECT DISTINCT r.opponentDeckCategory FROM Record r WHERE r.myDeck = :Deck")
    List<String> getOpponentDecksByMyDeck(@Param("Deck") String Deck);

    Long countByMyDeckAndOpponentDeckCategory(String myDeck, String opponentDeckCategory);

    Long countByOpponentDeckCategory(String opponentDeckCategory);

    Long countByOpponentDeckCategoryAndIsWon(String opponentDeckCategory, Boolean ture);

    Long countByMyDeckAndOpponentDeckCategoryAndIsWon(String myDeck, String opponentDeckCategory, Boolean ture);

    Long countByOpponentDeckCategoryAndIsFirst(String opponentDeckCategory, Boolean ture);

    Long countByMyDeckAndOpponentDeckCategoryAndIsFirst(String myDeck, String opponentDeckCategory,
            Boolean ture);
}
