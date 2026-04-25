package assignments;

/*
Problem Statement:
Given an array of length N and an integer x, return the last index of x using recursion, or -1 if not present.
*/

public class LastIndexOfNumberInArray1 {
	public static int lastIndex(int a[], int x) {
		// base case
		if (a.length == 0) {
			return -1;
		}

		// create smaller array
		int smallArray[] = new int[a.length - 1];
		for (int i = 1; i < a.length; i++) {
			smallArray[i - 1] = a[i];
		}

		// recursive call
		int k = lastIndex(smallArray, x);

		// calculation
		if (k != -1) {
			return k + 1;
		} else {
			if (a[0] == x) {
				return 0;
			} else {
				return -1;
			}
		}
	}

	public static void main(String[] args) {
		int arr[] = {3, 4, 7, 5, 9, 7, 6, 5};
		int x = 5;
		System.out.println(lastIndex(arr, x)); // 7
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
- recursively find last index in smaller array
- if found → shift index by +1
- else check current element
*/

/*
Sample Input 1:
9 8 10 8 , x = 8

Sample Output 1:
3

Sample Input 2:
9 8 10 8 , x = 2

Sample Output 2:
-1
*/