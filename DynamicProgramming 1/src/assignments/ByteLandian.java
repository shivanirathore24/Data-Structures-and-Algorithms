package assignments;
import java.util.HashMap;
import java.util.Scanner;

/*
Problem Statement:
Find maximum American dollars that can be earned from a Bytelandian coin.
*/

public class ByteLandian {
	// O(log n)
	public static long byteLandianR(long n) {
		// base case
		if(n <= 1) {
			return n;
		}

		long breakDownValue = byteLandianR(n / 2) + byteLandianR(n / 3)
				+ byteLandianR(n / 4);

		return Math.max(n, breakDownValue);
	}

	// O(log n)
	public static long byteLandianR2(long n, HashMap<Long, Long> memo) {
		// base case
		if(n <= 1) {
			return n;
		}

		// already calculated
		if(memo.get(n) != null) {
			return memo.get(n);
		}

		long breakDownValue = byteLandianR2(n / 2, memo) + byteLandianR2(n / 3, memo)
				+ byteLandianR2(n / 4, memo);

		memo.put(n, Math.max(n, breakDownValue));
		return memo.get(n);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter coin value:");
		long n = sc.nextLong();

		HashMap<Long, Long> memo = new HashMap<Long, Long>();

		System.out.println("Brute Force Recursive Answer:");
		System.out.println(byteLandianR(n));

		System.out.println("Recursive Optimized Answer:");
		System.out.println(byteLandianR2(n, memo));

		sc.close();
	}
}

/*
Time Complexity:
Brute Force Recursive : Exponential
Recursive Optimized   : O(log n)

Space Complexity:
Brute Force Recursive : O(log n)
Recursive Optimized   : O(log n)

Explanation:
- Either sell coin directly
- Or break it into n/2, n/3 and n/4
- Choose maximum profit
- Optimized recursion stores previous answers
*/

/*
Sample Input 1:
12

Sample Output 1:
Brute Force Recursive Answer:
13
Recursive Optimized Answer:
13


Sample Input 3:
6

Sample Output 3:
Brute Force Recursive Answer:
6
Recursive Optimized Answer:
6


Sample Input 3:
24

Sample Output 3:
Brute Force Recursive Answer:
27
Recursive Optimized Answer:
27
*/