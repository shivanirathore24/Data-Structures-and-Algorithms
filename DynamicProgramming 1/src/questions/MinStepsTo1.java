package questions;

/*
Problem Statement:
Given a positive integer n, find minimum steps to reduce it to 1.
Allowed operations:
1. n = n - 1
2. n = n / 2  (if divisible by 2)
3. n = n / 3  (if divisible by 3)
*/

public class MinStepsTo1 {
	// O(3^n)
	public static int minStepsTo1R1(int n) {
		// base case
		if(n == 1) {
			return 0;
		}

		int ans1 = minStepsTo1R1(n - 1);

		int ans2 = Integer.MAX_VALUE;
		if(n % 2 == 0) {
			ans2 = minStepsTo1R1(n / 2);
		}

		int ans3 = Integer.MAX_VALUE;
		if(n % 3 == 0) {
			ans3 = minStepsTo1R1(n / 3);
		}

		int myAns = Math.min(ans1, Math.min(ans2, ans3)) + 1;
		return myAns;
	}

	// O(n)
	public static int minStepsTo1R2(int n, int[] dp) {
		// base case
		if(n == 1) {
			return 0;
		}

		int ans1;
		// recursive optimized for n-1
		if(dp[n - 1] == -1) {
			ans1 = minStepsTo1R2(n - 1, dp);
			dp[n - 1] = ans1;
		}
		else {
			ans1 = dp[n - 1];
		}

		int ans2 = Integer.MAX_VALUE;
		// recursive optimized for n/2
		if(n % 2 == 0) {
			if(dp[n / 2] == -1) {
				ans2 = minStepsTo1R2(n / 2, dp);
				dp[n / 2] = ans2;
			}
			else {
				ans2 = dp[n / 2];
			}
		}

		int ans3 = Integer.MAX_VALUE;
		// recursive optimized for n/3
		if(n % 3 == 0) {
			if(dp[n / 3] == -1) {
				ans3 = minStepsTo1R2(n / 3, dp);
				dp[n / 3] = ans3;
			}
			else {
				ans3 = dp[n / 3];
			}
		}

		int myAns = Math.min(ans1, Math.min(ans2, ans3)) + 1;
		return myAns;
	}

	// O(n)
	public static int minStepsTo1I(int n) {
		// base case
		if(n == 1) {
			return 0;
		}

		int[] dp = new int[n + 1];
		dp[1] = 0;

		// iterative optimized approach
		for(int i = 2; i <= n; i++) {
			int ans1 = dp[i - 1];
			int ans2 = Integer.MAX_VALUE;
			int ans3 = Integer.MAX_VALUE;

			if(i % 2 == 0) {
				ans2 = dp[i / 2];
			}

			if(i % 3 == 0) {
				ans3 = dp[i / 3];
			}

			dp[i] = 1 + Math.min(ans1, Math.min(ans2, ans3));
		}
		return dp[n];
	}

	public static void main(String[] args) {
		int n = 10;
		int[] dp = new int[n + 1];

		// initialize dp array
		for(int i = 0; i < dp.length; i++) {
			dp[i] = -1;
		}

		System.out.println("Brute Force Recursive Answer:");
		System.out.println(minStepsTo1R1(n)); // 3

		System.out.println("Recursive Optimized Answer:");
		System.out.println(minStepsTo1R2(n, dp)); // 3

		System.out.println("Iterative Optimized Answer:");
		System.out.println(minStepsTo1I(n)); // 3
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
- Reduce number using allowed operations
- Brute force recursion recalculates answers
- Optimized recursion stores previous answers
- Iterative approach builds answer bottom-up
- Choose minimum among all possible operations
*/

/*
Sample Input 1:
10

Sample Output 1:
Brute Force Recursive Answer:
3
Recursive Optimized Answer:
3
Iterative Optimized Answer:
3


Sample Input 2:
6

Sample Output 2:
Brute Force Recursive Answer:
2
Recursive Optimized Answer:
2
Iterative Optimized Answer:
2
*/