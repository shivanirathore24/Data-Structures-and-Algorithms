package assignments;

/*
Problem Statement:
Given an array of length N, return the sum of all elements using recursion.
*/

public class SumOfArray2 {
	public static int sum(int input[]) {
		int n = input.length;
		// base case
		if (n == 1) {
			return input[0];
		}

		// create smaller array
		int smallArray[] = new int[n - 1];
		for (int i = 0; i < n - 1; i++) {
			smallArray[i] = input[i];
		}

		// recursive call
		int smallOutput = sum(smallArray);
		// calculation
		return smallOutput + input[n - 1];
	}

	public static void main(String[] args) {
		int arr[] = {7, 5, 9, 11, -3};
		System.out.println(sum(arr));
	}
}

/*
Time Complexity:
O(n^2)
- At each recursive call, a new array is created (O(n))
- Total calls = n

Space Complexity:
O(n^2)
- Recursive stack = O(n)
- Extra arrays created at each step

Explanation:
- base case: when array size is 1, return that element
- break problem → take last element + remaining array
- recursively compute sum of smaller array
- add last element to recursive result

Sample Input 1:
3
9 8 9

Sample Output 1:
26

Explanation:
9 + 8 + 9 = 26

Sample Input 2:
3
4 2 1

Sample Output 2:
7
*/