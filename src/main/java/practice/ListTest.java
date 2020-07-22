package practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		String s1 = "testString";
		String s2 = "testString";
		if(s1 == s2) System.out.println("equals!");
		
		String s3 = new String("testString");
		
		if(s1 == s3) System.out.println("equals!");
		else System.out.println("not equals!");
	}

}
