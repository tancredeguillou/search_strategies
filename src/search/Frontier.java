package search;

// frontier is the list of nodes, queue for BFS and stack for DFS.
public interface Frontier {
	
	void addNode(Node node);
	void clear();
	boolean isEmpty();
	Node removeNode();
}
