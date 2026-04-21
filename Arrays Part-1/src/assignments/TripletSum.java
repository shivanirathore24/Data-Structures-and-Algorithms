package assignments;

/*
Problem Statement:
You are given an array and a number X.
Find and return the number of triplets in the array whose sum is equal to X.
*/

public class TripletSum {
	public static int findTriplet(int[] arr, int x) {
		int n = arr.length;
		int count = 0;

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					if (x == arr[i] + arr[j] + arr[k]) {
						count++;
					}
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int arr[] = {1, 5, 4, 7, 9, 6, 2, 1, 4, 5};
		int x = 10;
		System.out.println(findTriplet(arr, x));
	}
}

/*
Sample Input 1:
arr = 1 2 3 4 5 6 7
x = 12

Sample Output 1:
5

Sample Input 2:
arr = 2 -5 8 -6 0 5 10 11 -3
x = 10

Sample Output 2:
5
*/