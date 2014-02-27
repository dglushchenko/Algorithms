import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 Find two elements in array such that their sum is equal to some sum
 */
public class Sum {

	private static final int[] array = new int[] { 1, 3, 3, 2, 1, 7, 9, 5 };

	private static int[] findSum(int[] array, int sum) {
		int[] result;
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				int calculatedSum = array[i] + array[j];
				if (sum == calculatedSum) {
					result = new int[2];
					result[0] = array[i];
					result[1] = array[j];
					return result;
				}
			}
		}

		return new int[0];
	}

	private static int[] findSumImproved(int[] array, int sum) {
		return new int[0];
	}

	private static Map<Integer, Set<Integer>> init(int[] array) {
		Map<Integer, Set<Integer>> sumToElementsMap = new HashMap<Integer, Set<Integer>>();

		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				int sum = array[i] + array[j];
				Set<Integer> values = sumToElementsMap.get(sum);
				if (values == null) {
					values = new HashSet<Integer>();
				}
				values.add(array[i]);
				values.add(array[j]);
				sumToElementsMap.put(sum, values);
			}
		}

		return sumToElementsMap;
	}

	private static int[] findSumWithHashMap(int[] array, int sum) {
		Map<Integer, Set<Integer>> sumToElementsMap = init(array);
		Set<Integer> values = sumToElementsMap.get(sum);
		if (values != null) {
			// Simple case - only one pair
			for (int value : values) {
				return new int[] { value, sum - value };
			}
		}
		return new int[0];
	}

	public static void main(String[] args) {
		int sum = 9;
		int[] result = findSumWithHashMap(array, sum);
		if (result.length == 2) {
			System.out.println(result[0] + ", " + result[1]);
		} else {
			System.out.println("Not found");
		}
	}

}