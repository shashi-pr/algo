
public class MaximumSubArray {

	public static void main(String[] args) {
		int [] array = {-2, -3, 4, -1, -2, 1, 5, -3}; 
		
		int max = kadane(array);
		
		System.out.println(max);

	}
	
	private static int kadane(int[] array) {
		
		int max_current= array[0], max_global = array[0];
		
		for (int i = 0; i < array.length; i++) {
			max_current = Math.max(max_current + array[i], array[i]);
			if(max_current > max_global) max_global = max_current;
		}
		
		return max_global;
	}

}
