package me.algorythm.sorting;

public class MergeSort implements Sort {

	public void sort(int[] array) {
		int[] sortedArray = internalSort(array, 1);
		System.arraycopy(sortedArray, 0, array, 0, array.length);
	}

	private int[] internalSort(int[] array, int chunkLength) {
		int[] newArray = new int[array.length];

		for (int i = 0, k = 0; i < array.length; i += 2 * chunkLength) {
			int leftIndex = i;
			int rightIndex = i + chunkLength;

			for (int j = 0; j < 2 * chunkLength; j++) {
				boolean leftIndexInBounds = (leftIndex < array.length) && (leftIndex < i + chunkLength);
				boolean rightIndexInBounds = (rightIndex < array.length) && (rightIndex < i + 2 * chunkLength);
				
				if (!leftIndexInBounds && !rightIndexInBounds) {
					break;
				}
				
				if (!rightIndexInBounds || (leftIndexInBounds && (array[leftIndex] < array[rightIndex]))) {
					newArray[k++] = array[leftIndex++];
				} else {
					newArray[k++] = array[rightIndex++];
				}
			}

		}

		int newChunkLength = chunkLength * 2;
		if (newChunkLength >= array.length) {
			return newArray;
		} else {
			return internalSort(newArray, newChunkLength);
		}
	}

}
