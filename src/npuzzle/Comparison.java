package npuzzle;

import search.BreadthFirstFrontier;
import search.DepthFirstFrontier;
import search.GoalTest;
import search.GraphSearch;
import search.Node;
import search.TreeSearch;

public class Comparison {
	public static void main(String[] args) {
		System.out.println("This is a demonstration of breadth-first tree search on 8-puzzle");
		System.out.println();
		
		Tiles initialConfiguration = new Tiles(new int[][] {
			{ 7, 4, 2 },
			{ 8, 1, 3 },
			{ 5, 0, 6 }
		});
		

		GoalTest goalTest = new TilesGoalTest();
		
		System.out.println("First try : Breadth First Tree Search");
		
		BreadthFirstFrontier BFfrontier1 = new BreadthFirstFrontier();
		TreeSearch Tsearch1 = new TreeSearch(BFfrontier1);
		
		Node solution1 = Tsearch1.findSolution(initialConfiguration, goalTest);
		
		new NPuzzlePrinting().printSolution(solution1);
		System.out.println("Total number of nodes generated during the search : " + Tsearch1.generatedNodes());
		System.out.println("Maximum number of nodes stored on the frontier at any point during\n" + 
				"the search : " + BFfrontier1.maxNodes());
		
		System.out.println();
		
		
		
		
		
		
		System.out.println("Second try : Breadth First Graph Search");
		
		BreadthFirstFrontier BFfrontier2 = new BreadthFirstFrontier();
		GraphSearch Gsearch2 = new GraphSearch(BFfrontier2);
		
		Node solution2 = Gsearch2.findSolution(initialConfiguration, goalTest);
		
		new NPuzzlePrinting().printSolution(solution2);
		System.out.println("Total number of nodes generated during the search : " + Gsearch2.generatedNodes());
		System.out.println("Maximum number of nodes stored on the frontier at any point during\n" + 
				"the search : " + BFfrontier2.maxNodes());
		
		System.out.println();
		
		
		
		
		
		
		
		
		
		System.out.println("Third try : Depth First Tree Search");
		
		DepthFirstFrontier DFfrontier3 = new DepthFirstFrontier();
		TreeSearch Tsearch3 = new TreeSearch(DFfrontier3);
		
		Node solution3 = Tsearch3.findSolution(initialConfiguration, goalTest);
		
		new NPuzzlePrinting().printSolution(solution3);
		System.out.println("Total number of nodes generated during the search : " + Tsearch3.generatedNodes());
		System.out.println("Maximum number of nodes stored on the frontier at any point during\n" + 
				"the search : " + DFfrontier3.maxNodes());
		
		System.out.println();
		
		
		
		
		
		
		
		
		System.out.println("Fourth try : Depth First Graph Search");
		
		DepthFirstFrontier DFfrontier4 = new DepthFirstFrontier();
		TreeSearch Gsearch4 = new TreeSearch(DFfrontier4);
		
		Node solution4 = Gsearch4.findSolution(initialConfiguration, goalTest);
		
		new NPuzzlePrinting().printSolution(solution4);
		System.out.println("Total number of nodes generated during the search : " + Gsearch4.generatedNodes());
		System.out.println("Maximum number of nodes stored on the frontier at any point during\n" + 
				"the search : " + DFfrontier4.maxNodes());
	}
}
