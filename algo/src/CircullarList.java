public class CircullarList {

	private static int[] array = new int[] {38, 40, 55, 89, 6, 13, 20, 23, 36};

	//private static final int NOT_FOUND_INDEX = -1;
	
	private static int findMin(int[] array, int low, int high) {
		if (low == high) {
			return low;
		}
		
		int mid = (high + low) / 2;
		
		if (array[mid] < array[high]) {
			if (array[mid - 1] > array[mid]) {
				return mid;
			} else {
				return findMin(array, low, mid - 1);
			}
		}
		
		return findMin(array, mid + 1, high);
	}
	
	public static void main(String[] args) {
	
		System.out.println("Min: " + findMin());
	
	}
}