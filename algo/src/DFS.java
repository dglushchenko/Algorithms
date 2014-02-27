/*
Find value on BST using Breadth-First Search
*/

public class BFS {

	private class Node {
		private int data;
		private Node left;
		private Node right;
		
		public Node(int data) {
			this.data = data;
		}
		
		public int getData() {
			return data;
		}
		
		public Node getLeft() {
			return left;
		}
	
		public Node getRight() {
			return right;
		}
	
		public Node add(Node node) {
			if (node.getData > data) {
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
			if (this.data == data) {
				return this;
			}
		
			Queue queue = new LinkedList();
			queue.add(left);
			queue.add(right);
			
			while (Node node = queue.remove()) {
				node.find();
			} 
		}
		
		public String toString() {
			return String.valueOf(data);
		}
	}
	
	private static final int[] array = new int[] {4, 3, 1, 7, 9, 11, 2, 4, 13, 2};

	private Node fill(final int[] array) {
	
	}
	
	public static void main(String[] args) {
		Node root = fill(array);
		Node result = root.find(13);
		System.out.println("Result: " + result);
	}

}