package com.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.entity.Record;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
    Long countByMyDeckName(String myDeckName);

    Long countByIsWon(Boolean isWon);

    Long countByIsFirst(Boolean isFirst);

    Long countByMyDeckNameAndIsWon(String myDeckName, Boolean isWon);

    Long countByMyDeckNameAndIsFirst(String myDeckName, Boolean isFirst);

}
