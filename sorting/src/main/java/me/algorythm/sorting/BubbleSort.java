package me.algorythm.sorting;

public class BubbleSort implements Sort {

	public void sort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			boolean swapped = false;
			
			for (int j = 0; j < array.length - i - 1; j++) {
				int currentIndex = j;
				int nextIndex = j + 1;

				if (array[currentIndex] > array[nextIndex]) {
					swap(array, currentIndex, nextIndex);
					swapped = true;
				}
			}
			
			if (!swapped) {
				break;
			}
		}
	}

	private void swap(int[] array, int indexA, int indexB) {
		int temp = array[indexA];
		array[indexA] = array[indexB];
		array[indexB] = temp;
	}

}
