package me.algorythm.sorting;

public class QuickSort implements Sort {

	public void sort(int[] array) {
		internalSort(array, 0, array.length - 1);
	}

	private void internalSort(int[] array, int leftIndex, int rightIndex) {
		if (rightIndex > leftIndex) {
			int pivot = array[rightIndex];
			int storeIndex = leftIndex;
			for (int i = leftIndex; i < rightIndex; i++) {
				if (array[i] <= pivot) {
					swap(array, i, storeIndex);
					storeIndex++;
				}
			}
			swap(array, storeIndex, rightIndex);
			internalSort(array, leftIndex, storeIndex - 1);
			internalSort(array, storeIndex + 1, rightIndex);
		}
	}

	private void swap(int[] array, int indexA, int indexB) {
		int temp = array[indexA];
		array[indexA] = array[indexB];
		array[indexB] = temp;
	}

}
