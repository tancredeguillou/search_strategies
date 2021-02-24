package npuzzle;

import search.BreadthFirstFrontier;
import search.DepthFirstFrontier;
import search.GoalTest;
import search.GraphSearch;
import search.Node;
import search.TreeSearch;

public class Comparison {
	public static void main(String[] args) {
		//System.out.println("This is a demonstration of breadth-first tree search on 8-puzzle");
		System.out.println();
		
		Tiles initialConfiguration = new Tiles(new int[][] {
			{ 7, 4, 2 },
			{ 8, 1, 3 },
			{ 5, 0, 6 }
		});
		

		GoalTest goalTest = new TilesGoalTest();
		
		
		
		//BreadthFirstFrontier frontier = new BreadthFirstFrontier();
		DepthFirstFrontier frontier = new DepthFirstFrontier();
		
		TreeSearch search = new TreeSearch(frontier);
		//GraphSearch search = new GraphSearch(frontier);
		
		Node solution4 = search.findSolution(initialConfiguration, goalTest);
		
		new NPuzzlePrinting().printSolution(solution4);
		System.out.println("Total number of nodes generated during the search : " + search.generatedNodes());
		System.out.println("Maximum number of nodes stored on the frontier at any point during\n" + 
				"the search : " + frontier.maxNodes());
		
	}
}
