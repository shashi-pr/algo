package practice;

public class LongestPalindromicSequence {

	private static int findLPSLength(final String string) {
		Integer[][] dp = new Integer[string.length()][string.length()];

		return findLPSLength(dp, string, 0, string.length() - 1);
	}

	private static int findLPSLength(Integer[][] dp, String string, int startIndex, int endIndex) {

		if (startIndex > endIndex) {
			return 0;
		}

		if (startIndex == endIndex)
			return 1;

		if (dp[startIndex][endIndex] == null) {

			if (string.charAt(startIndex) == string.charAt(endIndex)) {
				dp[startIndex][endIndex] = 2 + findLPSLength(dp, string, startIndex + 1, endIndex - 1);
			} else {
				int length1 = findLPSLength(dp, string, startIndex + 1, endIndex);
				int length2 = findLPSLength(dp, string, startIndex, endIndex - 1);

				dp[startIndex][endIndex] = Math.max(length1, length2);

			}

		}

		return dp[startIndex][endIndex];
	}

	public static void main(String[] args) {
		System.out.println(findLPSLength("abdbca"));

	}

}
