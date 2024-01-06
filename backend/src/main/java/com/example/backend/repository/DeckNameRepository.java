package com.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.entity.DeckName;

@Repository
public interface DeckNameRepository extends JpaRepository<DeckName, Long> {
}
