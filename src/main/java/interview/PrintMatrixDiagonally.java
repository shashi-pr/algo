package interview;

public class PrintMatrixDiagonally {

	public static void main(String[] args) {
		
		char[][] matrix = new char[][]{{'a', 'b', 'c', 'd', 'e'}, {'f', 'g', 'h', 'i', 'j' }, {'k', 'l', 'm' , 'n', 'o'} , {'p', 'q', 'r', 's', 't'} };
		
		//printNormal(matrix);
		printDiagonally(matrix);
	}
	
	private static void printNormal(char[][] matrix) {
		int rows = matrix.length;
		int columns = matrix[0].length;
		
		for (int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("");		
		}
	}
	/**
	 * 
	 * 
	 
	 
	 * @param matrix
	 */
	private static void printDiagonally(char[][] matrix) {
		int rows = matrix.length;
		int columns = matrix[0].length;
		
		for (int k = 0; k < rows; k++) {
			int i = k;
			int j = 0;			
			while(i >= 0) {
				System.out.print(matrix[i][j]);
				i--;
				j++;				
			}	
			System.out.println("");		
		}
		
		for (int k = 1; k < columns; k++) {
			int i = rows -1;
			int j = k;		
			while(j < columns) {
				System.out.print(matrix[i][j]);
				i--;
				j++;
			}
			System.out.println("");	
		}	
	}
}
