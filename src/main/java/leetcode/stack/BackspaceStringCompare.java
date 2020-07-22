package leetcode.stack;

public class BackspaceStringCompare {

	public static boolean backspaceCompare(String S, String T) {
		String s1 = backSpaceFormatted(S);
		String s2 = backSpaceFormatted(T);
		System.out.println(s1);
		System.out.println(s2);
		return s1.equals(s2);
	}

	private static String backSpaceFormatted(String string) {
		StringBuilder sb = new StringBuilder();

		for (char c : string.toCharArray()) {

			if (c == '#' && sb.length() > 0) {
				sb.deleteCharAt(sb.length() - 1);
			} else if (c != '#') {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		boolean result = backspaceCompare("y#fo##f", "y#f#o##f");

		System.out.println(result);
	}

}
