package search;

import java.util.LinkedList;

public class DepthFirstFrontier extends Frontier {
	
	private int maxNodes = 0;
	
	public DepthFirstFrontier() {
		this.frontier = new LinkedList<Node>();
	}
	
	// For DFS the frontier is a stack.
	@Override
	public void addNode(Node node) {
		frontier.push(node);
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
		return frontier.pop();
	}

	@Override
	public int maxNodes() {
		return maxNodes;
	}
	
}
