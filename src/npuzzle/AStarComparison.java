package npuzzle;

import search.AStarFunction;
import search.BestFirstFrontier;
import search.GoalTest;
import search.GraphSearch;
import search.MisplacedTilesHeuristicFunction;
import search.Node;
import search.TreeSearch;

public class AStarComparison {
	public static void main(String[] args) {
		
		Tiles initialConfiguration = new Tiles(new int[][] {
			{ 7, 4, 2 },
			{ 8, 1, 3 },
			{ 5, 0, 6 }
		});
		

		GoalTest goalTest = new TilesGoalTest();
		
		MisplacedTilesHeuristicFunction heuristicFunction = new MisplacedTilesHeuristicFunction();
		
		AStarFunction AStarFunction = new AStarFunction(heuristicFunction);
		
		BestFirstFrontier frontier = new BestFirstFrontier(AStarFunction);
		//DepthFirstFrontier frontier = new DepthFirstFrontier();
		
		TreeSearch search = new TreeSearch(frontier);
		//GraphSearch search = new GraphSearch(frontier);
		
		Node solution4 = search.findSolution(initialConfiguration, goalTest);
		
		new NPuzzlePrinting().printSolution(solution4);
		System.out.println("Total number of nodes generated during the search : " + search.generatedNodes());
		System.out.println("Maximum number of nodes stored on the frontier at any point during\n" + 
				"the search : " + frontier.maxNodes());
		
	}
}
