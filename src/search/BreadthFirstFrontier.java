package search;

import java.util.LinkedList;

public class BreadthFirstFrontier extends Frontier {
	
	private int maxNodes = 0;
	
	public BreadthFirstFrontier() {
		this.frontier = new LinkedList<Node>();
	}
	
	// For BFS the frontier is a queue.
	@Override
	public void addNode(Node node) {
		frontier.add(node);
		if (frontier.size() > maxNodes) {
			maxNodes = frontier.size();
		}
	}

	@Override
	public void clear() {
		frontier.clear();
		maxNodes = 0;
	}

	@Override
	public boolean isEmpty() {
		return frontier.isEmpty();
	}

	@Override
	public Node removeNode() {
		return frontier.remove();
	}

	@Override
	public int maxNodes() {
		return maxNodes;
	}

}
