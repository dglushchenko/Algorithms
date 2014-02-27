/*
Find 13 in 6, 13, 20, 23, 36, 38, 40, 55, 89
*/
public class FindArrayElement {

	private static final int[] array = new int[] {6, 13, 20, 23, 36, 38, 40, 55, 89};
	
	public static final int NOT_FOUND_INDEX = -1;

	private static int find(int[] array, int low, int high, int value) {
		if (high < low) {
			return NOT_FOUND_INDEX;
		}
	
		int mid = low + (high - low) / 2;
		
		if (value == array[mid]) {
			return mid;
		}
		
		if (value > array[mid]) {
			return find(array, mid + 1, high, value);
		} else {
			return find(array, low, mid - 1, value);
		}
	}
	
	public static void main(String[] args) {
		System.out.println("find(13): " + find(array, 0, array.length - 1, 13));
	}

}