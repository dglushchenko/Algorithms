package me.algorythm.sorting;

public class ShellSort implements Sort {

	private static final int[] GAPS = new int[] { 701, 301, 132, 57, 23, 10, 4,
			1 };

	public void sort(int[] array) {
		int length = array.length;
		for (int gapsIndex = 0; gapsIndex < GAPS.length; gapsIndex++) {
			int gap = GAPS[gapsIndex];
			if (gap < length) {
				for (int i = 0; i < length - gap; i++) {
					for (int j = i; j >= 0; j -= gap) {
						int currentIndex = j;
						int nextIndex = j + gap;

						if (array[currentIndex] > array[nextIndex]) {
							swap(array, currentIndex, nextIndex);
						} else {
							break;
						}
					}
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
