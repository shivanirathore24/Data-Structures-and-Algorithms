package questions;

/*
Problem Statement:
Count total ways to climb staircase using 1, 2 or 3 steps.
*/

public class StairCase {
	// O(3^n)
	public static int staircaseR1(int n) {
		// base cases
		if(n == 0 || n == 1) {
			return 1;
		}

		if(n == 2) {
			return 2;
		}

		// recursive calls
		return staircaseR1(n - 1) + staircaseR1(n - 2) + staircaseR1(n - 3);
	}

	// O(n)
	public static long staircaseR2(int n, long[] dp) {
		// base cases
		if(n == 0 || n == 1) {
			return 1;
		}

		if(n == 2) {
			return 2;
		}

		// already calculated
		if(dp[n] != -1) {
			return dp[n];
		}

		// recursive optimized approach
		dp[n] = staircaseR2(n - 1, dp) + staircaseR2(n - 2, dp) + staircaseR2(n - 3, dp);

		return dp[n];
	}

	// O(n)
	public static long staircaseI(int n) {
		long dp[] = new long[n + 1];

		// base cases
		if(n == 0) {
			return 1;
		}

		if(n == 1 || n == 2) {
			return n;
		}

		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;

		// iterative optimized approach
		for(int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}

		return dp[n];
	}

	public static void main(String[] args) {
		int n = 5;
		long[] dp = new long[n + 1];

		// initialize dp array
		for(int i = 0; i < dp.length; i++) {
			dp[i] = -1;
		}

		System.out.println("Brute Force Recursive Answer:");
		System.out.println(staircaseR1(n)); // 13

		System.out.println("Recursive Optimized Answer:");
		System.out.println(staircaseR2(n, dp)); // 13

		System.out.println("Iterative Optimized Answer:");
		System.out.println(staircaseI(n)); // 13
	}
}

/*
Time Complexity:
Brute Force Recursive : O(3^n)
Recursive Optimized   : O(n)
Iterative Optimized   : O(n)

Space Complexity:
Brute Force Recursive : O(n)
Recursive Optimized   : O(n)
Iterative Optimized   : O(n)

Explanation:
- Brute force recursion recalculates answers
- Optimized recursion stores previous answers
- Iterative approach builds answer bottom-up
- Avoid repeated calculations
*/

/*
Sample Input 1:
4

Sample Output 1:
Brute Force Recursive Answer:
7
Recursive Optimized Answer:
7
Iterative Optimized Answer:
7


Sample Input 2:
10

Sample Output 2:
Brute Force Recursive Answer:
274
Recursive Optimized Answer:
274
Iterative Optimized Answer:
274
*/