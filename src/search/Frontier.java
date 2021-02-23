package search;

import java.util.LinkedList;

// frontier is the list of nodes, queue for BFS and stack for DFS.
public abstract class Frontier {
	
	public LinkedList<Node> frontier;
	
	abstract void addNode(Node node);
	abstract void clear();
	abstract boolean isEmpty();
	abstract Node removeNode();
	
	abstract int maxNodes();
}
