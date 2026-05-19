package assignments;

/*
Problem Statement:
A thief wants to loot houses.
He cannot loot two consecutive houses.
Find maximum money that can be looted.
*/

public class LootHouses {
	// O(2^n)
	public static int maxMoneyLootedR1(int[] houses, int index) {
		// base case
		if(index >= houses.length) {
			return 0;
		}

		// loot current house
		int option1 = houses[index] + maxMoneyLootedR1(houses, index + 2);

		// skip current house
		int option2 = maxMoneyLootedR1(houses, index + 1);

		return Math.max(option1, option2);
	}

	// O(n)
	public static int maxMoneyLootedR2(int[] houses, int index, int[] dp) {
		// base case
		if(index >= houses.length) {
			return 0;
		}

		// already calculated
		if(dp[index] != -1) {
			return dp[index];
		}

		// loot current house
		int option1 = houses[index] + maxMoneyLootedR2(houses, index + 2, dp);

		// skip current house
		int option2 = maxMoneyLootedR2(houses, index + 1, dp);

		dp[index] = Math.max(option1, option2);
		return dp[index];
	}

	// O(n)
	public static int maxMoneyLootedI(int[] houses) {
		int n = houses.length;

		// base case
		if(n == 0) {
			return 0;
		}

		if(n == 1) {
			return houses[0];
		}

		int[] dp = new int[n];

		dp[0] = houses[0];
		dp[1] = Math.max(houses[0], houses[1]);

		// iterative optimized approach
		for(int i = 2; i < n; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + houses[i]);
		}
		return dp[n - 1];
	}

	public static void main(String[] args) {
		int arr[] = {10, 2, 30, 20, 3, 50};

		int[] dp = new int[arr.length];

		// initialize dp array
		for(int i = 0; i < dp.length; i++) {
			dp[i] = -1;
		}

		System.out.println("Brute Force Recursive Answer:");
		System.out.println(maxMoneyLootedR1(arr, 0)); // 90

		System.out.println("Recursive Optimized Answer:");
		System.out.println(maxMoneyLootedR2(arr, 0, dp)); // 90

		System.out.println("Iterative Optimized Answer:");
		System.out.println(maxMoneyLootedI(arr)); // 90
	}
}

/*
Time Complexity:
Brute Force Recursive : O(2^n)
Recursive Optimized   : O(n)
Iterative Optimized   : O(n)

Space Complexity:
Brute Force Recursive : O(n)
Recursive Optimized   : O(n)
Iterative Optimized   : O(n)

Explanation:
- Either loot current house or skip it
- Cannot loot two consecutive houses
- Choose maximum profit
- Optimized recursion stores previous answers
- Iterative approach builds answer bottom-up
*/

/*
Sample Input 1:
6
5 5 10 100 10 5

Sample Output 1:
Brute Force Recursive Answer:
110
Recursive Optimized Answer:
110
Iterative Optimized Answer:
110


Sample Input 2:
6
10 2 30 20 3 50

Sample Output 2:
Brute Force Recursive Answer:
90
Recursive Optimized Answer:
90
Iterative Optimized Answer:
90
*/