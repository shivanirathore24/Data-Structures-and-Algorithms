package assignments;

/*
Problem Statement:
You are given an array. Find and return the second largest element present in the array.
*/

public class SecondLargestInArray {
	public static int secondLargestElement(int[] arr) {
		int largest = Integer.MIN_VALUE;
		int secondLargest = Integer.MIN_VALUE;

		if (arr.length == 0) {
			return Integer.MIN_VALUE;
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > largest) {
				secondLargest = largest;
				largest = arr[i];
			} else if (arr[i] < largest && arr[i] > secondLargest) {
				secondLargest = arr[i];
			}
		}
		return secondLargest;
	}

	public static void main(String[] args) {
		int arr[] = {3, 5, 6, 1, 10, 7, 24, 25, 18};
		int secondLargest = secondLargestElement(arr);
		System.out.println(secondLargest);
	}
}

/*
Sample Input 1:
4 3 10 9 2

Sample Output 1:
9

Sample Input 2:
13 6 31 14 29 44 3

Sample Output 2:
31
*/