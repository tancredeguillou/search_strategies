package search;

import java.util.HashSet;
import java.util.Set;

public class GraphSearch implements Search {
	
	private Frontier frontier;
	private int generatedNodes = 0;
	
	public GraphSearch(Frontier frontier) {
		this.frontier = frontier;
	}

	@Override
	public Node findSolution(State initialConfiguration, GoalTest goalTest) {
		frontier.clear();
		generatedNodes = 0;
		Set<State> explored = new HashSet<State>();
		frontier.addNode(new Node(null, null, initialConfiguration));
		while(!frontier.isEmpty()) {
			Node node = frontier.removeNode();
			explored.add(node.state);
			if (goalTest.isGoal(node.state)) {
				return node;
			} else {
				for (Action action : node.state.getApplicableActions()) {
					State newState = node.state.getActionResult(action);
					if (!explored.contains(newState)) {
						frontier.addNode(new Node(node, action, newState));
						generatedNodes++;
					}
				}
			}
		}
		return null;
	}

	@Override
	public int generatedNodes() {
		return generatedNodes;
	}

}
