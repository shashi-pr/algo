
class Indentation {

	public static void main(String args[]) {
		System.out.println("Hello World");
		String input = "public class PrettyPrint { public static void main(String args[]) { System.out.println(\"Hello World\"); String input = \"This is a sample code\"; System.out.println(Indent(input)); } public static String Indent(String input) { return \"Indented: \" + input; } }";
		System.out.println(Indent(input));

	}

	public static String Indent(String input) {
		String indentedOutput = "";
		// Code goes here
		String[] tokens = input.split(" ");
		int spaces = 0;

		for (String token : tokens) {

			if (token != null) {
				if (token.endsWith("{")) {
					System.out.println("");
					spaces = spaces + 4;
					for (int i = 0; i < spaces; i++) {
						System.out.print(" ");
					}
					System.out.print("{");

				} else if (token.endsWith("}")) {
					System.out.print(token + " ");
					System.out.println("");
					
					spaces = spaces - 4;
					
					for (int i = 0; i < spaces; i++) {
						System.out.print(" ");
					}
				} else if (token.endsWith(";")) {
					System.out.print(token);
					System.out.println("");
					for (int i = 0; i < spaces; i++) {
						System.out.print(" ");
					}
				} else {
					
					System.out.print(token + " ");
				}
			}
		}

		return indentedOutput;
	}
}
