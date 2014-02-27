/*
Find element in sorted array. Assume array contains positive elements.
*/
public class BinarySearch {

	public static int find(int[] array, int data) {
		return find(array, 0, array.length - 1, data);
	}

	private static int find(int[] array, int data, int left, int right) {
		if (left >= right) {
			return -1; // Not found
		}
	
		int mid = (right + left) / 2;
		int midData = array[mid];
		if (data == midData) {
			return midData;
		} else if (data > midData) {
			find(array, data, mid, right);
		} else {
			find(array, data, left, mid);
		}
	}

}