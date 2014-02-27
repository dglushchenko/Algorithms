import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

/*
 Merge a list of sorted lists
 */
public class MergeSortedLists {

	private static final Integer[] arrayA = new Integer[] { 1, 2, 3, 7, 8, 9, 10 };
	private static final Integer[] arrayB = new Integer[] { 0, 4, 5, 6 };

	private static List<Integer> merge(List<Integer> listA, List<Integer> listB) {
		List<Integer> result = new ArrayList<Integer>();

		if (listA != null && listB != null) {
			Iterator<Integer> itA = listA.iterator();
			Iterator<Integer> itB = listB.iterator();
			Integer a = null;
			Integer b = null;
			while (itA.hasNext() || itB.hasNext()) {
				if (a == null && itA.hasNext()) {
					a = itA.next();
				}
				if (b == null && itB.hasNext()) {
					b = itB.next();
				}
				if (a != null) {
					if (b != null) {
						if (a < b) {
							result.add(a);
							a = null;
						} else {
							result.add(b);
							b = null;
						}
					} else {
						result.add(a);
						a = null;
					}
				} else if (b != null) {
					result.add(b);
					b = null;
				} else {
					break;
				}
			}
		}

		if (listA == null) {
			if (listB == null) {
				result = null;
			}
			result.addAll(listB);
		} else if (listB == null) {
			result.addAll(listA);
		}

		return result;
	}

	public static void main(String[] args) {
		List<Integer> listA = Arrays.asList(arrayA);
		List<Integer> listB = Arrays.asList(arrayB);
		List<Integer> result = merge(listA, listB);

		System.out.println(result);
	}
}