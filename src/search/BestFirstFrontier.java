package search;

import java.util.Comparator;
import java.util.PriorityQueue;

public class BestFirstFrontier extends Frontier {
	
	public int maxNodes = 0;
	private NodeFunction function;
	public PriorityQueue<Node> frontier;
	
	public BestFirstFrontier(NodeFunction function) {
		this.frontier = new PriorityQueue<Node>(new NodeComparator());
		this.function = function;
	}

	@Override
	void addNode(Node node) {
		node.nodeValue = this.function.nodeFunction(node);
		frontier.add(node);
		if (frontier.size() > maxNodes) {
			maxNodes = frontier.size();
		}
	}

	@Override
	void clear() {
		frontier.clear();
		maxNodes = 0;
	}

	@Override
	boolean isEmpty() {
		return frontier.isEmpty();
	}

	@Override
	Node removeNode() {
		return frontier.poll();
	}

	@Override
	public int maxNodes() {
		return maxNodes;
	}

}

class NodeComparator implements Comparator<Node> {

	@Override
	public int compare(Node o1, Node o2) {
		if(o1.nodeValue < o2.nodeValue) return -1;
		else if(o1.nodeValue > o2.nodeValue) return 1;
		return 0;
	}
	
}
