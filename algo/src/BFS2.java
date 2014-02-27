/*
BFS
*/
public class BFS {

	private class Node {
		int data;
		Node left;
		Node right;
	}
	
	public static Node find(Node node, int data) {
		if (node == null) {
			return null;
		}
		Stack<Node> stack = new LinkedList<Node>();
		stack.push(node);
		while (!stack.empty()) {
			Node currentNode = stack.pop();
			if (currentNode.data == data) {
				return currentNode;
			}
			stack.push(currentNode.left);
			stack.push(currentNode.right);
		}
		return null;
	}

}