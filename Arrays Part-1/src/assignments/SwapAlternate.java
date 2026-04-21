package assignments;

/*
Problem Statement:
Given an array, swap every pair of alternate elements.
Modify the array in-place.
*/

public class SwapAlternate {
	public static void swapAlternate(int arr[]) {
		int len = arr.length;

		for (int i = 0; i < len - 1; i += 2) {
			int temp = arr[i];
			arr[i] = arr[i + 1];
			arr[i + 1] = temp;
		}
	}

	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void main(String[] args) {
		int arr[] = {2, 4, 7, 1, 8, 5};
		swapAlternate(arr);
		printArray(arr);
	}
}

/*
Sample Input 1:
9 3 6 12 4 32

Sample Output 1:
3 9 12 6 32 4

Sample Input 2:
1 2 3 4

Sample Output 2:
2 1 4 3
*/