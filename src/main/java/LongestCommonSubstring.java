
public class LongestCommonSubstring {

	public static void main(String[] args) {
		System.out.println(findLongestCommonSubstring("abdca", "cbda"));
		System.out.println(findLongestCommonSubstring("passport", "ppsspt"));
	}

	public static int findLongestCommonSubstring(String s1, String s2) {

		return findLongestCommonSubstring(s1, s2, 0,0, 0);
	}

	private static int findLongestCommonSubstring(String s1, String s2, int i1, int i2, int count) {

		if (i1 == s1.length() || i2 == s2.length()) {
			return count;
		}

		if (s1.charAt(i1) == s2.charAt(i2)) {
			count = findLongestCommonSubstring(s1, s2, i1 + 1, i2 + 1, count + 1);
		}

		int c1 = findLongestCommonSubstring(s1, s2, i1 + 1, i2, 0);
		int c2 = findLongestCommonSubstring(s1, s2, i1, i2 + 1, 0);

		return Math.max(count, Math.max(c1, c2));
	}

}
