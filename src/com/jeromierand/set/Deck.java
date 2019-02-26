package com.jeromierand.set;

import java.util.Collections;

public class Deck extends Group {

  public Deck(){
    super();
    for(Card.Shape shape: Card.Shape.values()){
      for(Card.Color color: Card.Color.values()){
        for(Card.Shading shading: Card.Shading.values()){
          for(Card.Number number: Card.Number.values()){
            addCard(new Card(shape, color, shading, number));
          }
        }
      }
    }
  } // end constructor

  public boolean hasCardsRemaining(){
    return cards.size() > 0;
  }

  public Card draw(){
    return cards.remove(cards.size() - 1);
  }

  public void shuffle(){
    Collections.shuffle(cards);
  }

  public static void main(String[] args){
    Deck testDeck = new Deck();
    System.out.println(testDeck.getNumCards());
    testDeck.printSets();
  }
}
