package com.example.backend.service;

import java.util.ArrayList;
import java.util.List;

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
    public List<String> getDeckNames() {
        List<DeckName> deckNames = deckNameRepository.findAll();
        List<String> DeckNameList = new ArrayList<>();

        for (DeckName deckName : deckNames) {
            DeckNameList.add(deckName.getDeckName());
        }

        return DeckNameList;
    }

    @Transactional
    public void registerDeckName(String mainCategory, String sub1Category, String sub2Category) {
        DeckName deckName = new DeckName();

        // sub1Category、sub2Categoryがnullの時は空文字とする
        String sub1CategoryOrEnpty = (sub1Category != null) ? sub1Category : "";
        String sub2CategoryOrEnpty = (sub2Category != null) ? sub2Category : "";

        deckName.setDeckName(mainCategory + sub1CategoryOrEnpty + sub2CategoryOrEnpty);
        deckName.setMainCategory(mainCategory);
        deckName.setSub1Category(sub1CategoryOrEnpty);
        deckName.setSub2Category(sub2CategoryOrEnpty);

        deckNameRepository.saveAndFlush(deckName);
    }
}
