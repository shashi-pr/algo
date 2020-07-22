package functional.tailcall;

public class FactorialRec {
	
	public static void main(String [] args) {
		
		int output = factorialRec(20000);
		
		System.out.println("Result is " + output);
		
	}

	
	public static int factorialRec(final int number) {
		if (number == 1) {
			return 1;
		} else {
			return number * factorialRec( number -1 );
		}
	}
}
