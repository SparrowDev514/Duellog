package com.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.entity.Record;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
}
