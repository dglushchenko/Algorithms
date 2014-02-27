import java.util.Arrays;

/*
Sort an array 1, 7, 4, 2, 13, 5, 3, 4 with Insertion Sort
*/
public class InsertionSort {

	private static int[] array = new int[] {1, 7, 4, 2, 13, 5, 3, 4};
	
	private static int[] sort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			for (int j = i; j > 0; j--) {
				if (array[j] < array[j - 1]) {
					swap(array, j, j - 1);
				} else {
					break;
				}
			}
		}
		
		return array;
	}
	
	private static void swap(int[] array, int indexA, int indexB) {
		int temp = array[indexA];
		array[indexA] = array[indexB];
		array[indexB] = temp;
	}

	public static void main(String[] args) {
		System.out.println("Sorted with InsertionSort: " + Arrays.toString(sort(array)));
	}
	
}