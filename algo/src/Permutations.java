/*
 Print all permutations of array [1, 2, 3]
 */
public class Permutations {

	private static final int[] array = new int[] { 1, 2, 3, 4, 5 };

	public static void printAllPermutations(int[] array) {
		printAllPermutations(new int[0], array);
	}

	private static void printAllPermutations(int[] prefix, int[] array) {
		int length = array.length;
		if (length == 0) {
			print(prefix);
		} else {
			for (int i = 0; i < length; i++) {
				int[] newPrefix = new int[prefix.length + 1];
				System.arraycopy(prefix, 0, newPrefix, 0, prefix.length);
				newPrefix[prefix.length] = array[i];

				int[] newArray = new int[array.length - 1];
				System.arraycopy(array, 0, newArray, 0, i);
				System.arraycopy(array, i + 1, newArray, i, length - i - 1);

				printAllPermutations(newPrefix, newArray);
			}
		}

	}

	private static void print(int[] array) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < array.length; i++) {
			sb.append(array[i]);
			if (i + 1 < array.length) {
				sb.append(", ");
			}
		}
		sb.append("]");
		System.out.println(sb.toString());
	}

	public static void main(String[] args) {
		printAllPermutations(array);
	}

}