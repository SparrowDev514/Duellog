package com.example.backend.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.backend.entity.Record;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
    Long countByMyDeckName(String myDeckName);

    Long countByIsWon(Boolean isWon);

    Long countByIsFirst(Boolean isFirst);

    Long countByMyDeckNameAndIsWon(String myDeckName, Boolean isWon);

    Long countByMyDeckNameAndIsFirst(String myDeckName, Boolean isFirst);

    @Query("SELECT DISTINCT r.opponentDeckCategory FROM Record r ")
    List<String> getOpponentDecks();

    @Query("SELECT DISTINCT r.opponentDeckCategory FROM Record r WHERE r.myDeckName = :deckName")
    List<String> getOpponentDecksByMyDeckName(@Param("deckName") String deckName);

    Long countByMyDeckNameAndOpponentDeckCategory(String myDeckName, String opponentDeckCategory);

    Long countByOpponentDeckCategory(String opponentDeckCategory);

    Long countByOpponentDeckCategoryAndIsWon(String opponentDeckCategory, Boolean ture);

    Long countByMyDeckNameAndOpponentDeckCategoryAndIsWon(String myDeckName, String opponentDeckCategory, Boolean ture);

    Long countByOpponentDeckCategoryAndIsFirst(String opponentDeckCategory, Boolean ture);

    Long countByMyDeckNameAndOpponentDeckCategoryAndIsFirst(String myDeckName, String opponentDeckCategory,
            Boolean ture);
}
