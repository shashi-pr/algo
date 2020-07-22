package leetcode.array;

public class NegativeNumberinSortedMatrix {

	public static int countNegatives(int[][] grid) {
		int count = 0;
		for (int i = grid.length - 1; i >= 0; i--) {
			for (int j = grid[i].length - 1; j >= 0; j--) {
				if (grid[i][j] < 0)
					count++;
				else
					break;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 4, 3, 2, -1 }, { 3, 2, 1, -1 }, { 1, 1, -1, -2 }, { -1, -1, -2, -3 } };
		int count = countNegatives(matrix);

		System.out.println(count);
	}

}
