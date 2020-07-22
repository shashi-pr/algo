package leetcode.array;

public class FindPeakElement {

	public static void main(String[] args) {
		int [] nums = new int[]{1,2,1,3,5,6,4};
		
		System.out.println(findPeak(nums));

	}
	
	
	private static int findPeak(int[] nums) {
		
		int left =0, right = nums.length - 1;
		
		while (left < right) {
			int mid = left + (right - left) / 2;
			
			if(nums[mid] < nums[mid + 1]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		
		
		return left;
	}

}
