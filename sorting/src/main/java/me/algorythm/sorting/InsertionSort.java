package me.algorythm.sorting;

public class InsertionSort implements Sort {

	public void sort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i; j >= 0; j--) {
				int currentIndex = j;
				int nextIndex = j + 1;

				if (array[currentIndex] > array[nextIndex]) {
					swap(array, currentIndex, nextIndex);
				} else {
					break;
				}
			}
		}
	}

	private void swap(int[] array, int indexA, int indexB) {
		int temp = array[indexA];
		array[indexA] = array[indexB];
		array[indexB] = temp;
	}

}
