package java8.lambda;

public class LambdaTest {

	public static void main(String[] args) {
		process(() -> System.out.print("Wonderful"));

	}

	public static void process(Runnable r) {
		r.run();
	}
}


