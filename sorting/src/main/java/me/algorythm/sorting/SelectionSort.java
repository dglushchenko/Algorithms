package me.algorythm.sorting;

public class SelectionSort implements Sort {

	public void sort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int minIndex = i;
			for (int j = i + 1; j < array.length; j++) {
				int currentIndex = j;

				if (array[minIndex] > array[currentIndex]) {
					minIndex = currentIndex;
				}
			}
			swap(array, i, minIndex);
		}
	}

	private void swap(int[] array, int indexA, int indexB) {
		int temp = array[indexA];
		array[indexA] = array[indexB];
		array[indexB] = temp;
	}

}
