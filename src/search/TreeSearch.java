package search;

public class TreeSearch implements Search {
	
	private Frontier frontier;
	private int generatedNodes = 0;
	
	public TreeSearch(Frontier frontier) {
		this.frontier = frontier;
	}

	@Override
	public Node findSolution(State initialConfiguration, GoalTest goalTest) {
		frontier.clear();
		generatedNodes = 0;
		frontier.addNode(new Node(null, null, initialConfiguration));
		while(!frontier.isEmpty()) {
			Node node = frontier.removeNode();
			if (goalTest.isGoal(node.state)) {
				return node;
			} else {
				for (Action action : node.state.getApplicableActions()) {
					State newState = node.state.getActionResult(action);
					frontier.addNode(new Node(node, action, newState));
					generatedNodes++;
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
