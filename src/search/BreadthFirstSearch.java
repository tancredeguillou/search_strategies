package search;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch implements Frontier {
	
	//For BFS the frontier is a queue.
	private Queue<Node> frontier;
	
	public BreadthFirstSearch() {
		this.frontier = new LinkedList<Node>();
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
		return frontier.remove();
	}

}
