/*
Create a single linked linked list
*/
public class LinkedList {

	private class Node {
		private int data;
		private Node next;
		
		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}

		public int getData() {
			return data;
		}
	}
	
	private Node head;
	private int size = 0;
	
	// Add to the head
	public void add(int data) {
		Node node = new Node(data, head);
		head = node;
		size++;
	}
	
	// Remove from the head
	public Node remove() {
		Node temp = head;
		head = head.next;
		size--;
		return temp;
	}

	// Get node at index
	public Node get(int index) {
		Node current = head;
		for (int i = 0; i < size; i++) {
			if (i == index) {
				return current;
			}
			current = current.next;
		}
		return null;
	}
	
	// Get linked list size
	public int size() {
		return size;
	}
}