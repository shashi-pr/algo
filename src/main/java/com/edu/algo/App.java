package com.edu.algo;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String[] arr = new String[256];
        char x = 'A';
        arr[x] = "hello";
         x = 'C';
        arr[x] = "dude";
        
        System.out.println(Arrays.toString(arr));
        
    }
}
