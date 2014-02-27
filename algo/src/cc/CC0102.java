package cc;
/*
1.2 Write code to reverse a C-Style String. (C-String means that “abcd” is represented as
!ve characters, including the null character.)
*/
public class CC0102 {

	private static String reverseCString(String s) {
		StringBuilder sb = new StringBuilder();
		
		sb.append("\0");
		for (int i = s.length() - 2; i >= 0; i--) {
			sb.append(s.charAt(i));
		}
		
		return sb.toString();
	}

	public static void main(String[] args) {
		String s = "This is a C string\0";
		System.out.println("Reversed string '" + s + "': '" + reverseCString(s) + "'");
	}
	
}