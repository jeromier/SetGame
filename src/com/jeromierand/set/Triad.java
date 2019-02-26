package com.jeromierand.set;

public class Triad{
	  private Card[] cards = new Card[3];


	  public Triad(Card cardOne, Card cardTwo, Card cardThree){
	    cards[0] = cardOne;
	    cards[1] = cardTwo;
	    cards[2] = cardThree;
	   }


	  private boolean allSameOrDifferent(Enum<?> a, Enum<?> b, Enum<?> c){
	    if (a == b && b == c)
	      return true;
	    else if (a != b && a != c && b != c)
	      return true;
	    else
	      return false;
	  }

	  public boolean isSet(){
	    if (allSameOrDifferent(cards[0].getShape(),cards[1].getShape(),cards[2].getShape()) &&
	        allSameOrDifferent(cards[0].getColor(),cards[1].getColor(),cards[2].getColor()) &&
	        allSameOrDifferent(cards[0].getShading(),cards[1].getShading(),cards[2].getShading()) &&
	        allSameOrDifferent(cards[0].getNumber(),cards[1].getNumber(),cards[2].getNumber()))
	        return true;
	    else
	      return false;
	  }

	  @Override
	  public String toString(){
	    String triadString = "";
	    String[] triadCards = new String[0];
	    for (Card card: cards){
	      if (triadCards.length == 0){
	        triadCards = card.toString().split("\n");
	        for (int i = 0; i < triadCards.length; i ++){
	          triadCards[i] = String.format("%-20s",triadCards[i]);
	        }
	      } else{
	        String [] cardStrings = card.toString().split("\n");
	        for (int i = 0; i < cardStrings.length; i++){
	          triadCards[i] += " | " + String.format("%-20s",cardStrings[i]);
	        }
	      }
	    }
	    triadString += String.join("\n",triadCards);
	    return triadString;
	  }

	  public static void main(String[] args){
	    Card testCard = new Card(Card.Shape.SQUIGGLE,Card.Color.PURPLE,Card.Shading.STRIPED,Card.Number.THREE);
	    Card testCard2 = new Card(Card.Shape.DIAMOND,Card.Color.PURPLE,Card.Shading.STRIPED,Card.Number.THREE);
	    Card testCard3 = new Card(Card.Shape.DIAMOND,Card.Color.PURPLE,Card.Shading.STRIPED,Card.Number.THREE);
	    Triad testTriad = new Triad(testCard, testCard2, testCard3);
	    System.out.println(testTriad);
	    System.out.println(testTriad.isSet());


	  }
	}
