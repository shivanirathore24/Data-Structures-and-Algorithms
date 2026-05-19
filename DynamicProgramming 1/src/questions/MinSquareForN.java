package questions;

/*
Problem Statement:
Find minimum count of numbers required to represent N as sum of squares.
*/

public class MinSquareForN {
	// O(n^(sqrt(n)))
	public static int minSquaresR1(int n) {
		// base case
		if(n == 0) {
			return 0;
		}

		int minAns = Integer.MAX_VALUE;

		// try every perfect square
		for(int i = 1; i * i <= n; i++) {
			int currAns = minSquaresR1(n - (i * i));
			if(minAns > currAns) {
				minAns = currAns;
			}
		}

		int myAns = 1 + minAns;
		return myAns;
	}

	// O(n * sqrt(n))
	public static int minSquaresR2(int n, int[] dp) {
		// base case
		if(n == 0) {
			return 0;
		}

		int minAns = Integer.MAX_VALUE;

		// recursive optimized approach
		for(int i = 1; i * i <= n; i++) {
			int currAns;
			if(dp[n - (i * i)] == -1) {
				currAns = minSquaresR2(n - (i * i), dp);
				dp[n - (i * i)] = currAns;
			}
			else {
				currAns = dp[n - (i * i)];
			}

			if(minAns > currAns) {
				minAns = currAns;
			}
		}

		int myAns = 1 + minAns;
		return myAns;
	}

	// O(n * sqrt(n))
	public static int minSquaresI(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 0;

		// iterative optimized approach
		for(int i = 1; i <= n; i++) {
			int minAns = Integer.MAX_VALUE;
			for(int j = 1; j * j <= i; j++) {
				int currAns = dp[i - (j * j)];
				if(minAns > currAns) {
					minAns = currAns;
				}
			}
			dp[i] = 1 + minAns;
		}
		return dp[n];
	}

	public static void main(String[] args) {
		int n = 12;
		int[] dp = new int[n + 1];

		// initialize dp array
		for(int i = 0; i < dp.length; i++) {
			dp[i] = -1;
		}

		System.out.println("Brute Force Recursive Answer:");
		System.out.println(minSquaresR1(n)); // 3

		System.out.println("Recursive Optimized Answer:");
		System.out.println(minSquaresR2(n, dp)); // 3

		System.out.println("Iterative Optimized Answer:");
		System.out.println(minSquaresI(n)); // 3
	}
}

/*
Time Complexity:
Brute Force Recursive : Exponential
Recursive Optimized   : O(n * sqrt(n))
Iterative Optimized   : O(n * sqrt(n))

Space Complexity:
Brute Force Recursive : O(n)
Recursive Optimized   : O(n)
Iterative Optimized   : O(n)

Explanation:
- Try every perfect square smaller than N
- Choose minimum among all possible answers
- Brute force recursion recalculates answers
- Optimized recursion stores previous answers
- Iterative approach builds answer bottom-up
*/

/*
Sample Input 1:
12

Sample Output 1:
Brute Force Recursive Answer:
3
Recursive Optimized Answer:
3
Iterative Optimized Answer:
3


Sample Input 2:
9

Sample Output 2:
Brute Force Recursive Answer:
1
Recursive Optimized Answer:
1
Iterative Optimized Answer:
1
*/