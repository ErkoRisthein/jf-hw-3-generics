package org.zeroturnaround.jf.homework3.task1;

import static java.util.Objects.hash;

public final class Card {

  public final Rank rank;
  public final Suit suit;

  public Card(Rank rank, Suit suit) {
    this.rank = rank;
    this.suit = suit;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Card card = (Card) o;
    return rank == card.rank &&
            suit == card.suit;
  }

  @Override
  public int hashCode() {
    return hash(rank, suit);
  }

  @Override
  public String toString() {
    return rank + " of " + suit;
  }
}
