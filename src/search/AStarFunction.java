package search;

public class AStarFunction implements NodeFunction {
	
	private NodeFunction heuristicFunction;
	
	public AStarFunction(NodeFunction heuristicFunction) {
		this.heuristicFunction = heuristicFunction;
	}

	@Override
	public int nodeFunction(Node node) {
		return node.pathCost + heuristicFunction.nodeFunction(node);
	}

}