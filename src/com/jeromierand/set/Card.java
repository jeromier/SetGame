package com.jeromierand.set;



public class Card {

  public enum Shape{OVAL, SQUIGGLE, DIAMOND};
  public enum Color{RED, GREEN, PURPLE};
  public enum Shading{SOLID, STRIPED, OUTLINED};
  public enum Number{ONE, TWO, THREE};

  private Shape shape;
  private Color color;
  private Shading shading;
  private Number number;

  public Card(Shape shape, Color color, Shading shading, Number number){
    this.shape = shape;
    this.color = color;
    this.shading = shading;
    this.number = number;
  }

  public Shape getShape(){
    return shape;
  }

  public Color getColor(){
    return color;
  }

  public Shading getShading(){
    return shading;
  }

  public Number getNumber(){
    return number;
  }


  @Override
  public String toString(){
    String cardString = "";
    cardString += "Shape: " + this.shape + "\n";
    cardString += "Color: " + this.color + "\n";
    cardString += "Shading: " + this.shading + "\n";
    cardString += "Number: " + this.number + "\n";
    return cardString;
  }

  public static void main(String[] args){
    Card testCard = new Card(Shape.SQUIGGLE,Color.PURPLE,Shading.STRIPED,Number.THREE);
    System.out.println(testCard);
  }

}
