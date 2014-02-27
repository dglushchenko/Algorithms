/*
Find lowest common ancestor in BST
*/
public class LowestCommonAncestor {
	private class Node {
		private int data;
		private Node left;
		private Node right;
	}

	public static Node findLowestCommonAncestor(Node root, Node nodeA, Node nodeB) {
		if (root.equals(nodeA) || root.equals(nodeB)) {
			return root;
		}
		
		Node leftNode = findLowestCommonAncestor(root.left, nodeA, nodeB);
		Node rightNode = findLowestCommonAncestor(root.right, nodeA, nodeB);
		
		
	}
}