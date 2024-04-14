package com.example.backend.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.example.backend.entity.Deck;
import com.example.backend.repository.DeckRepository;

public class DeckServiceTests {

    @Mock
    private DeckRepository DeckRepository;

    @InjectMocks
    private DeckService DeckService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Mockitoを使用する場合に必要
    }

    @Test
    void getDecksTest() {

        // decksを作る
        Deck deck1 = new Deck();
        deck1.setDeckName("deck1");
        deck1.setCreatedAt(null);

        Deck deck2 = new Deck();
        deck2.setDeckName("deck2");
        deck2.setCreatedAt(null);

        List<Deck> decks = Arrays.asList(deck1, deck2);

        Mockito.when(DeckRepository.findAll()).thenReturn(decks);

        // getCategoriesの処理
        List<String> deckNames = DeckService.getDecks();

        assertNotNull(deckNames);
        assertEquals(Arrays.asList("deck1", "deck2"), deckNames);
    }

    @Test
    void registerDeck() {
        Deck deck = new Deck();
        deck.setMainCategory("MainCategory");
        deck.setSub1Category("Sub1Category");
        deck.setSub2Category("Sub2Category");

        // DBにモックする内容を作る
        Deck dbMockDeck = new Deck();
        dbMockDeck.setMainCategory("MainCategory");
        dbMockDeck.setSub1Category("Sub1Category");
        dbMockDeck.setSub2Category("Sub2Category");
        Mockito.when(DeckRepository.saveAndFlush(any(Deck.class))).thenReturn(dbMockDeck);

        Deck registeredDeck = DeckService.registerDeck("MainCategory", "Sub1Category", "Sub2Category");

        assertEquals(deck, registeredDeck);

    }
}
