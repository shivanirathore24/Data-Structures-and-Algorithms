package assignments;

/*
Problem Statement:
Given an array of length N, return the sum of all elements using recursion.
*/

public class SumOfArray3 {
	public static int sumBetter(int input[], int si) {
		// base case
		if (si == input.length) {
			return 0;
		}
		// recursive call
		int smallOutput = sumBetter(input, si + 1);
		// calculation
		return input[si] + smallOutput;
	}

	public static void main(String[] args) {
		int arr[] = {7, 4, 9, 10, -3};
		System.out.println(sumBetter(arr, 0));
	}
}

/*
Time Complexity:
O(n)
- Each element is processed once

Space Complexity:
O(n) → recursion stack
- Stack depth = n
- No extra array created

Explanation:
- base case: when index reaches end of array, return 0
- break problem → take current element + sum of remaining array
- move forward using index (si + 1)
- add current element during backtracking
- optimal approach (no extra array)
*/

/*
Sample Input 1:
7 4 9 11 -3

Sample Output 1:
28

Sample Input 2:
1 2 3 4

Sample Output 2:
10
*/