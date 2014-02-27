package cc;
/*
1.1 Implement an algorithm to determine if a string has all unique characters. What if you
can not use additional data structures?
*/
public class CC0101 {

	private static boolean containsUnique(String s) {
		boolean[] charRegistry = new boolean[256];
		for (int i = 0; i < s.length(); i++) {
			int charAt = s.charAt(i);
			if (charRegistry[charAt]) {
				return false;
			}
			charRegistry[charAt] = true;
		}
		return true;
	}

	public static void main(String[] args) {
		String s1 = "This string contains only unique characters";
		String s2 = "String";
		System.out.println("String '" + s1 + "' contains only unique characters: " + containsUnique(s1));
		System.out.println("String '" + s2 + "' contains only unique characters: " + containsUnique(s2));
	}
}