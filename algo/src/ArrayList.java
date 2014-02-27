/*
Create dynamic array (linked list) data structure
*/
public class ArrayList {

	private static final int DEFAULT_SIZE = 16;

	private int[] array;
	private int size = 0;
	
	public ArrayList() {
		this(DEFAULT_SIZE);
	}
	
	public ArrayList(int size) {
		array = new int[size];
	}

	private void resize() {
		if (size + 1 >= array.length) {
			int[] tempArray = new int[array.length * 2];
			System.arraycopy(array, 0, tempArray, 0, array.length - 1);
			array = tempArray;
			tempArray = null;
		}
	}
	
	public void add(int value) {
		resize();
		array[size++] = value;
	}
	
	public int get(int index) {
		return array[index];
	}
	
	public void remove(int index) {
		System.arraycopy(array, index + 1, array, index, size - index + 1);
		size--;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("[");
		for (int i = 0; i < size; i++) {
			sb.append(array[i]);
			if (i + 1 < size) {
				sb.append(", ");
			}
		}
		sb.append("]");
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		ArrayList list = new ArrayList(1);
		list.add(1);
		list.add(2);
		System.out.println(list);
		list.remove(0);
		System.out.println(list);
		list.add(3);
		System.out.println(list);
	}
}