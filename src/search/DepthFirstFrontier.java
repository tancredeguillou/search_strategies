package search;

import java.util.Stack;

public class DepthFirstFrontier implements Frontier {
	
	// For DFS the frontier is a stack.
	private Stack<Node> frontier;
	
	public DepthFirstFrontier() {
		this.frontier = new Stack<Node>();
	}

	@Override
	public void addNode(Node node) {
		frontier.add(node);
	}

	@Override
	public void clear() {
		frontier.clear();
	}

	@Override
	public boolean isEmpty() {
		return frontier.isEmpty();
	}

	@Override
	public Node removeNode() {
		return frontier.pop();
	}
	
}
