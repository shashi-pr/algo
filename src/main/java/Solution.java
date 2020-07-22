import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the downToZero function below.
     */
    static int downToZero(int n) {
        /*
         * Write your code here.
         */
         int temp = n;
         int steps = 0;
         while(n != 0) {
             int maxFactor =  findMaxFactor(n);
             if (maxFactor == n) n = n -1;
             else n = maxFactor;
             steps++;
         }
        return steps;
    }

    static int findMaxFactor(int n) {
        int max = 0;
        for (int i = 2; i < n; i++) {
            if(n%i == 0) {
                int temp = n / i;
                System.out.println(" Temp " + temp + " i " + i);
                int temp_max = Math.max(temp, i);
                if((temp_max  < max) || (max == 0)) max = temp_max;
            }
        }
        int returndata = max == 0 ? n : max;
        System.out.println("returndata " + returndata);
        return returndata;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(scanner.nextLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            int n = Integer.parseInt(scanner.nextLine().trim());

            int result = downToZero(n);
            
            System.out.println(result);
        //    bufferedWriter.write(String.valueOf(result));
        //    bufferedWriter.newLine();
            /*
             * 1000
0
512866
             */
        }

       // bufferedWriter.close();
    }
}
