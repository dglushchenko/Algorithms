package me.algorythm.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * 1024
 * 
 * length = 100000000 QuickSort: 12022 MergeSort: 23557 OptimizedMergeSort:
 * 22054
 * 
 * 2048
 * 
 * length = 100000000 QuickSort: 11998 MergeSort: 23326 OptimizedMergeSort:
 * 21917
 * 
 * 
 * 4096
 * 
 * length = 100000000 QuickSort: 11501 MergeSort: 23276 OptimizedMergeSort:
 * 21785
 * 
 * 
 * 8192
 * 
 * length = 100000000 QuickSort: 11928 MergeSort: 23307 OptimizedMergeSort:
 * 21746
 * 
 * 
 * 16384
 * 
 * length = 100000000 QuickSort: 12047 MergeSort: 23758 OptimizedMergeSort:
 * 21652
 * 
 * 
 * 32768
 * 
 * length = 100000000 QuickSort: 11640 MergeSort: 23283 OptimizedMergeSort:
 * 21591
 * 
 * 262144
 * 
 * length = 100000000 QuickSort: 11606 MergeSort: 23218 OptimizedMergeSort:
 * 21464
 * 
 * 
 * 524288
 * 
 * length = 100000000 QuickSort: 11534 MergeSort: 23305 OptimizedMergeSort:
 * 21712
 * 
 * 
 * 1048576
 * 
 * length = 100000000 QuickSort: 12017 MergeSort: 23245 OptimizedMergeSort:
 * 21539
 * 
 * @author yc14dg1
 * 
 */
public class OptimizedMergeSort implements Sort {

	private static final int CPU_NUMBER = 4;

	private static final int PARTIAL_SORT_THRESHOLD = 262144;

	private ExecutorService executor = Executors.newFixedThreadPool(CPU_NUMBER);

	private List<FutureTask<Result>> tasks = new ArrayList<FutureTask<Result>>();

	private class Result {
		private int[] partialArray;
		private int startIndex;

		public Result(int[] partialArray, int startIndex) {
			this.partialArray = partialArray;
			this.startIndex = startIndex;
		}

		public int[] getPartialArray() {
			return partialArray;
		}

		public int getStartIndex() {
			return startIndex;
		}
	}

	private class PartialSortCallable implements Callable<Result> {

		private int[] partialArray;
		private int startIndex;

		public PartialSortCallable(int[] partialArray, int startIndex) {
			this.partialArray = partialArray;
			this.startIndex = startIndex;
		}

		public Result call() throws Exception {
			int[] partialArraySortResult = internalSort(partialArray, 1);
			return new Result(partialArraySortResult, startIndex);
		}

	}

	public void sort(int[] array) {

		int[] arrayAfterPartialSort = new int[array.length];

		int partialSortThreshold = array.length / CPU_NUMBER;

		for (int i = 0; i < array.length;) {

			int partialArrayLength = (i + partialSortThreshold > array.length ? array.length - i : partialSortThreshold);

			int[] partialArray = new int[partialArrayLength];

			System.arraycopy(array, i, partialArray, 0, partialArrayLength);

			PartialSortCallable callable = new PartialSortCallable(partialArray, i);
			FutureTask<Result> task = new FutureTask<Result>(callable);
			executor.execute(task);
			tasks.add(task);

			i += partialArrayLength;
		}

		List<FutureTask<Result>> tasksToRemove = new ArrayList<FutureTask<Result>>();

		while (tasks.size() > 0) {
			for (FutureTask<Result> task : tasks) {
				try {
					Result result = task.get();
					System.arraycopy(result.getPartialArray(), 0, arrayAfterPartialSort, result.getStartIndex(), result.getPartialArray().length);
					tasksToRemove.add(task);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
			}
			tasks.removeAll(tasksToRemove);
			tasksToRemove.clear();
		}

		int[] sortedArray = array.length > partialSortThreshold ? internalSort(arrayAfterPartialSort, partialSortThreshold) : arrayAfterPartialSort;
		System.arraycopy(sortedArray, 0, array, 0, array.length);
	}

	private int[] internalSort(int[] array, int chunkLength) {
		int[] newArray = new int[array.length];

		int nextChunkLength = 2 * chunkLength;
		for (int i = 0, k = 0; i < array.length; i += nextChunkLength) {
			int leftIndex = i;
			int rightIndex = i + chunkLength;

			int leftIndexBounds = i + chunkLength;
			boolean leftIndexInBounds = (leftIndex < array.length) && (leftIndex < leftIndexBounds);
			int rightIndexBounds = i + nextChunkLength;
			boolean rightIndexInBounds = (rightIndex < array.length) && (rightIndex < rightIndexBounds);
			
			for (int j = 0; j < nextChunkLength; j++) {

				if (!leftIndexInBounds && !rightIndexInBounds) {
					break;
				}

				if (!rightIndexInBounds || (leftIndexInBounds && (array[leftIndex] < array[rightIndex]))) {
					newArray[k++] = array[leftIndex++];
					leftIndexInBounds = (leftIndex < array.length) && (leftIndex < leftIndexBounds);
				} else {
					newArray[k++] = array[rightIndex++];
					rightIndexInBounds = (rightIndex < array.length) && (rightIndex < rightIndexBounds);
				}
			}

		}

		if (nextChunkLength >= array.length) {
			return newArray;
		} else {
			return internalSort(newArray, nextChunkLength);
		}
	}

}
