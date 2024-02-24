package com.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.entity.Deck;

@Repository
public interface DeckRepository extends JpaRepository<Deck, String> {
}
