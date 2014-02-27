import java.util.Arrays;

/*
 Sort an array 1, 7, 4, 2, 13, 5, 3, 4 with Heap Sort
 */
public class HeapSort {

	private static int[] array = new int[] { 1, 7, 4, 2, 13, 5, 3, 4 };

	private static void heapify(int array[], int from, int to) {
		for (int i = from + 1; i <= to; i++) {
			int k = i;
			for (int j = (k - 1) / 2; j >= 0; j = (j - 1) / 2) {
				if (array[k] > array[j]) {
					swap(array, k, j);
					k = j;
				} else {
					break;
				}
			}
		}
	}

	private static void swap(int[] array, int indexA, int indexB) {
		int temp = array[indexA];
		array[indexA] = array[indexB];
		array[indexB] = temp;
	}

	private static void sort(int[] array) {
		for (int i = array.length - 1; i >= 0; i--) {
			heapify(array, 0, i);
			swap(array, 0, i);
		}
	}

	public static void main(String[] args) {
		sort(array);
		System.out.println("Sorted array: " + Arrays.toString(array));
	}

}