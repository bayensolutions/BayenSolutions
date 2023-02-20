package com.bayensolutions.dao;

import com.bayensolutions.model.Deck;

import java.util.List;

public interface DeckDAO {
    List<Deck> getDecks();

    boolean createDeck(Deck deck);

    boolean updateDeck(Deck deck);
}
