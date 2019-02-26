package com.jeromierand.set;

import java.util.ArrayList;
import java.util.Iterator;

public class Group implements Iterable<Card>{

  protected ArrayList<Card> cards = new ArrayList<>();
  protected ArrayList<Triad> sets = new ArrayList<>();
  protected boolean dirty = false;

  public void addCard(Card card){
    dirty = true;
    cards.add(card);
  }

  public int getNumCards(){
    return cards.size();
  }

  private void updateSets(){
    for (int i=0; i< cards.size(); i++){
      for(int j=i+1; j < cards.size(); j++){
        for(int k=j+1; k< cards.size(); k++){
          Triad possibleSet = new Triad(cards.get(i),cards.get(j),cards.get(k));
          if (possibleSet.isSet()){
            sets.add(possibleSet);
          }
        }
      }
    }

    dirty = false;
  }

  public int getNumSets(){
    if (dirty)
      updateSets();
    return sets.size();
  }

  public ArrayList<Triad> getSets(){
    if (dirty)
      updateSets();
    return sets;
  }

  public void printSets(){
    if (dirty)
      updateSets();
    System.out.println("There are " + sets.size() + " sets in this group.");
    for (Triad set:sets){
      System.out.println(set);
      System.out.println();
    }
  }

  @Override
  public Iterator<Card> iterator(){
    return cards.iterator();
  }

  @Override
  public String toString(){
    String outputString = "";
    outputString += "There are " + cards.size() + " cards in this group:\n";
    for(Card card: cards){
      outputString += "------------\n";
      outputString += card;
    }
    return outputString;
  }

}
