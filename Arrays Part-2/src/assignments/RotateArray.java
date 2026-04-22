package assignments;

/*
Problem Statement:
You are given an array and a number d.
Rotate the array towards left by d elements.
Modify the array in-place.
*/

public class RotateArray {
	public static void printArray(int [] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void rotateArray(int [] arr, int d) {
		int temp[] = new int[d];

		for(int i = 0; i < d; i++) {
			temp[i] = arr[i];
		}
		for(int i = d; i < arr.length; i++) {
			arr[i - d] = arr[i];
		}
		for(int i = 0; i < d; i++) {
			arr[arr.length - d + i] = temp[i];
		}
	}

	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6,7};
		int d = 2;
		rotateArray(arr, d);
		printArray(arr);
	}
}

/*
Sample Input 1:
arr = 1 2 3 4 5 6 7
d = 2

Sample Output 1:
3 4 5 6 7 1 2

Sample Input 2:
arr = 1 2 3 4
d = 2

Sample Output 2:
3 4 1 2
*/