package org.zeroturnaround.jf.homework3.task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeck {

  /* I used an ArrayList as the underlying data structure because:
   * 1. It can only ever hold up to 52 values which means that O(n) lookup and O(n) removal time-complexity is fine
   * (since in the worst case, n=52=const., i.e. it's essentially O(1) complexity)
   * 2. Collections.shuffle() works with Lists
   */
  private List<Card> deck = new ArrayList<>(52);

  /**
   * Creates a new shuffled card deck with 52 cards
   */
  public CardDeck() {
    initializeDeck();
    shuffle();
  }

  private void initializeDeck() {
    for (Rank rank : Rank.values()) {
      for (Suit suit : Suit.values()) {
        deck.add(new Card(rank, suit));
      }
    }
  }

  /**
   * Shuffles the remaining cards in the deck.
   */
  public void shuffle() {
    Collections.shuffle(deck);
  }

  /**
   * Returns the topmost card in the pile or NULL if none remaining
   */
  public Card take() {
    if(deck.isEmpty()) {
      return null;
    }
    return deck.remove(0);
  }

  /**
   * Adds the card to the bottom of the pile.
   */
  public void add(Card... cards) {
    for (Card card : cards) {
      if(deck.contains(card)) {
        throw new CardAlreadyExistsException();
      }
      deck.add(card);
    }
  }

  /**
   * Returns the number of cards remaining in the deck (0...52)
   */
  public int size() {
    return deck.size();
  }

}
