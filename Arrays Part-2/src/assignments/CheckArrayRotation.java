package assignments;

/*
Problem Statement:
You are given a sorted array that has been rotated.
Find and return the index from which the array has been rotated.
*/

public class CheckArrayRotation {
	public static int rotateArray(int [] arr) {
		for(int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				return i + 1;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6};
		int rotarr[] = {5,6,1,2,3,4};
		int rotatedBy = rotateArray(rotarr);
		System.out.println(rotatedBy);
	}
}

/*
Sample Input 1:
5 6 1 2 3 4

Sample Output 1:
2

Sample Input 2:
3 6 8 9 10

Sample Output 2:
0
*/