/*
Find shortest path in binary tree
*/
public class ShortestPath {

	private class Node {
		private int data;
		private Node left;
		private Node right;
		
		public Node(int data) {
			this.data = data;
		}
		
	}

	public static List<Node> findShortestPath(Node root, Node nodeA, Node nodeB) {
		List<Node> pathA = findPathFromRoot(root, nodeA);
		List<Node> pathB = findPathFromRoot(root, nodeB);
		
		List<Node> result = new ArrayList<Node>();
		
		return result;
	}
	
	public static List<Node> findPathFromRoot(Node root, Node node) {
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		while (!stack.empty()) {
			Node currentNode = stack.pop();

			if (node.data == currentNode.data) {
				return new ArrayList<Node>(stack);
			}
			
			if (currentNode != null) {
				stack.push(currentNode.left);
				stack.push(currentNode.right);
			}
		}
	}
	
}