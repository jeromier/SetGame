package com.jeromierand.set;

public class Simulation{

	  private int groupSize;

	  public Simulation(int groupSize){
	    this.groupSize = groupSize;
	  }

	  public void simulate(int iterations){
	    int numContainingSet = 0;
	    int totalSetsFound = 0;

	    for(int i=0; i < iterations; i++){
	      Deck deck = new Deck();
	      Group group = new Group();
	      deck.shuffle();
	      for (int j = 0; j < groupSize; j++){
	        group.addCard(deck.draw());
	      }

	      int setsFound = group.getNumSets();
	      if (setsFound > 0)
	        numContainingSet++;
	      totalSetsFound += setsFound;
	    }

	    double percentContaingSet = 100.0 * numContainingSet / iterations;
	    double averageSets = (double) totalSetsFound / iterations;
	    System.out.println("Group size: " + groupSize);
	    System.out.println("Iterations: " + iterations);
	    System.out.printf("%d contained a set (%.2f%%)%n",numContainingSet,percentContaingSet);
	    System.out.printf("%.2f sets per group on average%n" ,averageSets);

	  }

	  public static void main(String[] args){
	    Simulation testSim = new Simulation(16);
	    testSim.simulate(10000);
	  }
	}
