/*
Iterator
*/
public class Iterator {
	private int index;
	
	public boolean hasNext() {
		return index < size() - 1;
	}

	public int next() {
		return get(index++);
	}
	
}