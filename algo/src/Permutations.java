/*
Print all permutations of array [1, 2, 3]
*/
public class Permutations {

	private static final int[] array = new array[] {1, 2, 3};

	private static void printAllPermutations(int[] array) {
		List<Integer> elements = new ArrayList<Integer>();
		for (int i = 0; i < array.length; i++) {
			elements.add(array[i]);
		}
		List<Integer> permutation = new ArrayList<Integer>();
		printAllPermutationsInternal(permutations, elements);
	}
	
	private static void printAllPermutationsInternal(List<Integer> permutations, List<Integer> elements) {
		if (elemets.size == 0) {
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			for (int i = 0; i < permutations.size(); i++) {
				sb.append(permuations.get(i));
				if (i + 1 < permutations.size()) {
					sb.append(", ");
				}
			}
			sb.append("]");
			System.out.println(sb.toString());
			return;
		}
	
		for (int number : elements) {
			permutations.add(number);
			elements.remove(number);
			printAllPermutationsInternal(permutations, elements);
		}
	}
	
	public static void main(String[] args) {
		printAllPermutations(array);
	}

}