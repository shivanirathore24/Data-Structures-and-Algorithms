package assignments;
import java.util.Scanner;

/*
Problem Statement:
Given a number n, return the number of digits in n using recursion.
*/

public class NumberOfDigit {
	public static int count(int n) {
		// base case
		if (n == 0) {
			return 0;
		}
		// recursive call
		int smallOutput = count(n / 10);
		// calculation
		return 1 + smallOutput;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(count(n));
	}
}

/*
Time Complexity:
O(log n)
- Each step divides n by 10

Space Complexity:
O(log n) → recursion stack

Explanation:
- base case: when n == 0, stop recursion
- break problem → remove last digit using n/10
- count each recursive step
 */

/*
Sample Input 1:
121

Sample Output 1:
3

Explanation:
Digits are 1, 2, 1 → total = 3

Sample Input 2:
38

Sample Output 2:
2
*/