package assignments;

/*
Problem Statement:
You are given an array. Move all zeros to the end while maintaining the order of non-zero elements.
Do it in-place in one scan.
*/

public class ZerosAtEnd {
	public static void pushZerosAtEnd(int[] arr) {
		int nonZero = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				int temp = arr[i];
				arr[i] = arr[nonZero];
				arr[nonZero] = temp;
				nonZero++;
			}
		}
	}

	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void main(String[] args) {
		int arr[] = {1, 0, 4, 5, 6, 0, 0, 4, 0, 1};
		pushZerosAtEnd(arr);
		printArray(arr);
	}
}

/*
Sample Input 1:
2 0 0 1 3 0 0

Sample Output 1:
2 1 3 0 0 0 0

Sample Input 2:
0 3 0 2 0

Sample Output 2:
3 2 0 0 0
*/