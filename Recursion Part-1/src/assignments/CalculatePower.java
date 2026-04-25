package assignments;
import java.util.Scanner;

/*
Problem Statement:
Given two integers x and n, find x^n using recursion.
*/

public class CalculatePower {
	public static int power(int x, int n) {
		// base case
		if (n == 0) {
			return 1;
		}
		// recursive call
		int smallOutput = power(x, n - 1);
		// calculate result
		return x * smallOutput;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int n = sc.nextInt();
		int output = power(x, n);
		System.out.println(output);
	}
}

/*
Time Complexity:
O(n)

Space Complexity:
O(n) → recursion stack

Explanation:
- base case: x^0 = 1
- break problem → x * x^(n-1)
- solve recursively until n becomes 0
*/

/*
Sample Input 1:
x = 3, n = 4

Sample Output 1:
81

Sample Input 2:
x = 2, n = 5

Sample Output 2:
32
*/