/*
Create a HashMap
*/
public class HashMap {

	private class Entry {
		private int key;
		private int value;
		private Entry next;
		
		public Entry(int key, int value, Entry next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}

	private Entry[] table;
	
	public HashMap() {
		table = new Entry[16];
	}
	
	private int hashcode(int value) {
		return value;
	}
	
	public void put(int key, int value) {
		int index = hashcode(key) % table.length;
		for (Entry e = table[index]; e != null; e = e.next) {
			if (e.key == key) {
				e.value = value;
				return;
			}
		}
		
		Entry e = table[index];
		table[index] = new Entry(key, value, e);
	}
	
	public int get(int key) {
		int index = hashcode(key) % table.length;
		for (Entry e = table[index]; e != null; e = e.next) {
			if (e.key == key) {
				return e.value;
			}
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put(1, 1);
		map.put(2, 2);
		map.put(3, 3);
		System.out.println(map.get(1) + ", " + map.get(2) + ", " + map.get(3));
		map.put(2, 4);
		System.out.println(map.get(1) + ", " + map.get(2) + ", " + map.get(3));
	}
}