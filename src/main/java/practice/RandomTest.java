package practice;

public class RandomTest {

	public static int divide(int dividend, int divisor) {

		if (divisor == 0)
			return Integer.MAX_VALUE;
		if (divisor == -1 && dividend == Integer.MIN_VALUE)
			return Integer.MAX_VALUE;

		// get positive values
		long pDividend = Math.abs((long) dividend);
		long pDivisor = Math.abs((long) divisor);
		int result = 0;

		while (pDividend >= pDivisor) {
			pDividend -= pDivisor;
			result++;
		}

		if((dividend>0 && divisor>0) || (dividend<0 && divisor<0)){
	        return result;
	    }else{
	        return -result;
	    }

	}

	public static void main(String[] args) {
		int result = divide(-2147483648, -1);

		System.out.println(result);

	}

}
