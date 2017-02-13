package org.zeroturnaround.jf.homework3;

import org.junit.Assert;
import org.junit.Test;
import org.zeroturnaround.jf.homework3.task1.CardDeck;

public class CardDeckTest {

  @Test
  public void testCardDeckCreates52Cards() {
    Assert.assertEquals(52, new CardDeck().size());
  }

  @Test
  public void testCardDeckContainsNoDuplicateCards() {
    // TODO: implement me
  }



}
