package me.algorythm.sorting;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;

public class SortTest {

	public static final int[] SMALL_ARRAY = new int[] { 8, 4, 3, 7, 9, 10, 1, 6, 2, 5 };
	public static final int[] SORTED_SMALL_ARRAY = new int[] { 1, 2, 3, 4, 5,
			6, 7, 8, 9, 10 };

	private static final Sort[] SLOW_SORTS = new Sort[] { new BubbleSort(),
			new GnomeSort(), new CocktailSort(), new InsertionSort(),
			new SelectionSort() };

	private static final Sort[] QUICK_SORTS = new Sort[] { /*new ShellSort(),*/
			new QuickSort(), new MergeSort(), new OptimizedMergeSort() };

	private static final Sort[] SORTS = ArrayUtils.addAll(/*SLOW_SORTS, */QUICK_SORTS);
	
	@Test
	public void testBubbleSort() {
		doSortOnSmallArray(new BubbleSort());
	}

	@Test
	public void testGnomeSort() {
		doSortOnSmallArray(new GnomeSort());
	}

	@Test
	public void testCocktailSort() {
		doSortOnSmallArray(new CocktailSort());
	}

	@Test
	public void testInsertionSort() {
		doSortOnSmallArray(new InsertionSort());
	}

	@Test
	public void testShellSort() {
		doSortOnSmallArray(new ShellSort());
	}

	@Test
	public void testSelectionSort() {
		doSortOnSmallArray(new SelectionSort());
	}

	@Test
	public void testQuickSort() {
		doSortOnSmallArray(new QuickSort());
	}

	@Test
	public void testMergeSort() {
		doSortOnSmallArray(new MergeSort());
	}

	@Test
	public void testOptimizedMergeSort() {
		doSortOnSmallArray(new OptimizedMergeSort());
	}

	private void doSortOnSmallArray(Sort sort) {
		int[] array = new int[SMALL_ARRAY.length];
		System.arraycopy(SMALL_ARRAY, 0, array, 0, SMALL_ARRAY.length);

		sort.sort(array);

		Assert.assertArrayEquals(SORTED_SMALL_ARRAY, array);
	}

	@Test
	public void testSortOnBigArray() {
		final int SLOW_SORTS_THRESHOLD = 100000;

		for (int length = 10; length <= 100000000; length *= 10) {
			int[] bigArray = generateBigArray(length);
			int[] sortedBigArray = new int[length];
			System.arraycopy(bigArray, 0, sortedBigArray, 0, length);
			Arrays.sort(sortedBigArray);

			System.out.println("length = " + length);
			if (length <= SLOW_SORTS_THRESHOLD) {
				for (Sort sort : SORTS) {
					System.out.println(sort.getClass().getSimpleName()
							+ ": "
							+ doSortOnBigArray(sort, length, bigArray,
									sortedBigArray));
				}
			} else {
				for (Sort sort : QUICK_SORTS) {
					System.out.println(sort.getClass().getSimpleName()
							+ ": "
							+ doSortOnBigArray(sort, length, bigArray,
									sortedBigArray));
				}
			}
			System.out.println();
		}
	}

	private long doSortOnBigArray(Sort sort, int length,
			int[] originalBigArray, int[] sortedBigArray) {
		int[] bigArray = new int[length];
		System.arraycopy(originalBigArray, 0, bigArray, 0, length);

		long startTime = System.currentTimeMillis();
		sort.sort(bigArray);
		long finishTime = System.currentTimeMillis();

		Assert.assertArrayEquals(sortedBigArray, bigArray);

		return finishTime - startTime;
	}

	private int[] generateBigArray(int length) {
		int[] array = new int[length];

		for (int i = 0; i < length; i++) {
			int value = (int) (length * Math.random());
			array[i] = value;
		}

		return array;
	}

}
