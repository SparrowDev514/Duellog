package com.example.backend.service;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.entity.DeckName;
import com.example.backend.repository.DeckNameRepository;

import jakarta.transaction.Transactional;

@Service
public class DeckNameService {

    @Autowired
    DeckNameRepository deckNameRepository;

    @Transactional
    public void registerDeckName(String mainCategory, String sub1Category, String sub2Category, Timestamp timestamp) {
        DeckName deckName = new DeckName();

        deckName.setDeckName(mainCategory + sub1Category + sub2Category);
        deckName.setMainCategory(mainCategory);
        deckName.setSub1Category(sub1Category);
        deckName.setSub2Category(sub2Category);
        deckName.setCreatedAt(timestamp);

        deckNameRepository.saveAndFlush(deckName);
    }
}
