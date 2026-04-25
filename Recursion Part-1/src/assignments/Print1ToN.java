package assignments;
import java.util.Scanner;

/*
Problem Statement:
Given a number n, print numbers from 1 to n in increasing order using recursion.
*/

public class Print1ToN {
    public static void print1ToN(int n) {
        // base case
        if (n == 0) {
            return;
        }
        // System.out.print(n + " ");  // decreasing order
        // recursive call
        print1ToN(n - 1);
        System.out.print(n + " ");   // increasing order
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        print1ToN(n);
    }
}

/*
Time Complexity:
O(n)
- Function is called n times

Space Complexity:
O(n) → recursion stack
- Stack depth = n

Explanation:
- base case: when n == 0, stop recursion
- if print is before recursive call → decreasing order
- if print is after recursive call → increasing order
- here we print after call, so output is 1 to n

Sample Input 1:
6

Sample Output 1:
1 2 3 4 5 6

Sample Input 2:
4

Sample Output 2:
1 2 3 4
*/