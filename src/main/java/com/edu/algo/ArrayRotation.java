package com.edu.algo;

public class ArrayRotation {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] response = leftRotation(arr, 2);
		
		for(int i = 0; i < response.length; i++) {
			System.out.print(response[i] + " ");
		}
		
		int[] response2 = rightRotation(arr, 2);
		System.out.println(" ");
		for(int i = 0; i < response2.length; i++) {
			System.out.print(response2[i] + " ");
		}
	}

	private static int[] leftRotation(int arr[], int d) {
		
		int tempArray[] = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++) {
			tempArray[(i + arr.length - d) % arr.length] = arr[i];
		}
		return tempArray;
	}

	private static int[] rightRotation(int arr[], int d) {
		int tempArray[] = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++) {
			tempArray[(i + d) % arr.length] = arr[i];
		}
		return tempArray;
	}

}
