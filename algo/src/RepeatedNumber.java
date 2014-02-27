
public class RepeatedNumber {

	private static final int[] array = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 7};
	
	public static void main(String[] args) {
		/*int result = 0;
		for (int i : array) {
			result ^= i;
		}*/
		int min = 0;
		int max = 0;
		int sum = 0;
		for (int i : array) {
			if (i < min) {
				min = i;
			}
			if (i > max) {
				max = i;
			}
			sum += i;
		}
		
		int expectedSum = 0;
		for (int i = min; i <= max; i++) {
			expectedSum += i;
		}
		
		System.out.println("" + (sum - expectedSum));
	}
}
