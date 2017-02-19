package org.zeroturnaround.jf.homework3.task1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.zeroturnaround.jf.homework3.task1.Rank.ACE;
import static org.zeroturnaround.jf.homework3.task1.Suit.SPADES;

public class CardDeckTest {

  private CardDeck deck;

  @Before
  public void setUp() {
    deck = new CardDeck();
  }

  @Test
  public void cardDeckCreates52Cards() {
    assertThat(deck.size(), is(52));
  }

  @Test
  public void take1CardFromDeckAndSizeIs51() {
    Card card = deck.take();
    assertThat(deck.size(), is(51));
  }

  @Test
  public void takeReturnsNullWhenDeckIsEmpty() {
    removeNCardsFromDeck(52);
    assertThat(deck.take(), is(nullValue()));
  }

  @Test(expected = CardAlreadyExistsException.class)
  public void addDoesNotAllowToAddExistingCard() {
    deck.add(new Card(ACE, SPADES));
  }

  @Test
  public void canTakeACardAndAddItBack() {
    Card card = deck.take();
    deck.add(card);
    removeNCardsFromDeck(51);
    assertThat(deck.take(), is(card));
  }

  @Test
  public void canTakeTwoCardsAndAddThemBack() {
    Card card1 = deck.take();
    Card card2 = deck.take();
    deck.add(card1);
    deck.add(card2);
    removeNCardsFromDeck(50);
    assertThat(deck.take(), is(card1));
    assertThat(deck.take(), is(card2));
  }

  @Test
  public void cardDeckContainsNoDuplicateCards() {
    List<Card> duplicates = new ArrayList<>();
    int size = deck.size();
    for (int i = 0; i < size; i++) {
      Card card = deck.take();
      assertThat(duplicates.contains(card), is(false));
      duplicates.add(card);
    }
  }

  private void removeNCardsFromDeck(int number) {
    for (int i = 0; i < number; i++) {
      deck.take();
    }
  }



}
