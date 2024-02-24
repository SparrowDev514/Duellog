package com.example.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.entity.Deck;
import com.example.backend.repository.DeckRepository;

import jakarta.transaction.Transactional;

@Service
public class DeckService {

    @Autowired
    DeckRepository DeckRepository;

    @Transactional
    public List<String> getDecks() {
        List<Deck> Decks = DeckRepository.findAll();
        List<String> DeckList = new ArrayList<>();

        for (Deck Deck : Decks) {
            DeckList.add(Deck.getDeckName());
        }

        return DeckList;
    }

    @Transactional
    public void registerDeck(String mainCategory, String sub1Category, String sub2Category) {
        Deck Deck = new Deck();

        // sub1Category、sub2Categoryがnullの時は空文字とする
        String sub1CategoryOrEmpty = (sub1Category != null) ? sub1Category : "";
        String sub2CategoryOrEmpty = (sub2Category != null) ? sub2Category : "";

        Deck.setDeckName(mainCategory + sub1CategoryOrEmpty + sub2CategoryOrEmpty);
        Deck.setMainCategory(mainCategory);
        Deck.setSub1Category(sub1CategoryOrEmpty);
        Deck.setSub2Category(sub2CategoryOrEmpty);

        DeckRepository.saveAndFlush(Deck);
    }
}
