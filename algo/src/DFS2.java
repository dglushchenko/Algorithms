/*
DFS
*/
public class DFS {

	private class Node {
		int data;
		Node left;
		Node right;
	}

	public Node find(Node node, int data) {
		if (node.data == data) {
			return node;
		}
		if (node.left != null) {
			find(node.left, data);
		}
		if (node.right != null) {
			find(node.right, data);
		}
		return null;
	}

	public static void main(String[] args) {
		DFS dfs = new DFS();
		Node root = ...;
		int data = ...;
		dfs.find(root, data);
	}
}