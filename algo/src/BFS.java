import java.util.LinkedList;
import java.util.Queue;

/*
Find value on BST using Breadth-First Search
*/

public class BFS {

	private static class Node {
		private int data;
		private Node left;
		private Node right;
		
		public Node(int data) {
			this.data = data;
		}
		
		public Node(final int[] array) {
			this(array[0]);
			for (int i = 1; i < array.length; i++) {
				add(new Node(array[i]));
			}
		}
		
		public int getData() {
			return data;
		}
		
		public void add(Node node) {
			if (node.getData() > data) {
				if (right == null) {
					right = node;
				} else {
					right.add(node);
				}
			} else {
				if (left == null) {
					left = node;
				} else {
					left.add(node);
				}
			}
		}
		
		public Node find(int data) {
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(this);
			
			while (!queue.isEmpty()) {
				Node node = queue.remove();
				
				if (node.data == data) {
					return node;
				}
				
				if (node.left != null) {
					queue.add(node.left);
				}
				
				if (node.right != null) {
					queue.add(node.right);
				}
			}
			
			return null;
		}
		
		public String toString() {
			return String.valueOf(data);
		}
	}
	
	private static final int[] array = new int[] {4, 3, 1, 7, 9, 11, 2, 4, 13, 2};

	public static void main(String[] args) {
		Node root = new Node(array);
		Node result = root.find(7);
		System.out.println("Result: " + result);
	}

}