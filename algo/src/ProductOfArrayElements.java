import java.util.Arrays;

/*
Find product of all elements in array without current one. Do not use division.
*/
public class ProductOfArrayElements {

	private static final int[] array = new int[] {1, 2, 4, 5, 3};

	public static int[] findProductImproved(final int[] array) {
		int[] result = new int[array.length];
		
		result[0] = 1;
		for (int i = 1; i < array.length; i++) {
			result[i] = result[i - 1] * array[i - 1];
		}

		int currentValue = 1;
		for (int i = array.length - 2; i >= 0; i--) {
			currentValue = currentValue * array[i + 1];
			result[i] = result[i] * currentValue;
		}
		
		return result;
	}

	public static int[] findProduct(final int[] array) {
		int[] result = new int[array.length];
	
		int[] left = new int[array.length];
		int[] right = new int[array.length];
	
		for (int i = 0; i < array.length; i++) {
			if (i - 1 < 0) {
				left[i] = 1;
				continue;
			}
			left[i] = left[i - 1] * array[i - 1];
		}
		
		for (int i = array.length - 1; i >= 0; i--) {
			if (i >= array.length - 1) {
				right[i] = 1;
				continue;
			}
			right[i] = right[i + 1] * array[i + 1];
		}
		
		for (int i = 0; i < array.length; i++) {
			result[i] = left[i] * right[i];
		}
	
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println("The product array: " + Arrays.toString(findProduct(array)));
		System.out.println("The product array: " + Arrays.toString(findProductImproved(array)));
	}
}