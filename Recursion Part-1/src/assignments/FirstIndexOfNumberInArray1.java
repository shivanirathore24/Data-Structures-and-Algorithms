package assignments;

/*
Problem Statement:
Given an array of length N and an integer x, return the first index of x using recursion, or -1 if not present.
*/

public class FirstIndexOfNumberInArray1 {
	public static int firstIndex(int a[], int x) {
		// base case
		if (a.length == 0) {
			return -1;
		}
		// check first element
		if (a[0] == x) {
			return 0;
		}

		// create smaller array
		int smallArray[] = new int[a.length - 1];
		for (int i = 1; i < a.length; i++) {
			smallArray[i - 1] = a[i];
		}

		// recursive call
		int fi = firstIndex(smallArray, x);
		// calculation
		if (fi == -1) {
			return -1;
		} else {
			return 1 + fi;
		}
	}

	public static void main(String[] args) {
		int arr[] = {3, 4, 7, 5, 9, 7, 6, 5};
		int x = 5;
		System.out.println(firstIndex(arr, x)); // 3
	}
}

/*
Time Complexity:
O(n^2)

- New array created at each call → O(n)
- Total calls = n

Space Complexity:
O(n^2)

- Recursive stack + extra arrays

Explanation:
- base case: empty array → return -1
- check first element
- recursively find index in smaller array
- if found → add 1 to adjust index
*/

/*
Sample Input 1:
9 8 10 8 , x = 8

Sample Output 1:
1

Sample Input 2:
9 8 10 8 , x = 2

Sample Output 2:
-1
*/