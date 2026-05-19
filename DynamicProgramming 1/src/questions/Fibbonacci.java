package questions;
import java.util.Scanner;

/*
Problem Statement:
Find nth Fibonacci number.
*/

public class Fibbonacci {
    // O(2^n)
    public static int fibbR1(int n) {
        // base case
        if(n == 0 || n == 1) {
            return n;
        }

        // recursive calls
        return fibbR1(n - 1) + fibbR1(n - 2);
    }

    // O(n)
    public static int fibbR2(int n, int[] dp) {
        // base case
        if(n == 0 || n == 1) {
            return n;
        }

        int ans1, ans2;

        // recursive optimized for n-1
        if(dp[n - 1] == -1) {
            ans1 = fibbR2(n - 1, dp);
            dp[n - 1] = ans1;
        }

        else {
            ans1 = dp[n - 1];
        }

        // recursive optimized for n-2
        if(dp[n - 2] == -1) {
            ans2 = fibbR2(n - 2, dp);
            dp[n - 2] = ans2;
        }

        else {
            ans2 = dp[n - 2];
        }

        int myAns = ans1 + ans2;

        return myAns;
    }

    // O(n)
    public static int fibbI(int n) {
        // base case
        if(n == 0 || n == 1) {
            return n;
        }

        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;

        // iterative approach
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n:");
        int n = sc.nextInt();

        int[] dp = new int[n + 1];

        // initialize dp array
        for(int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }

        int ans = fibbR2(n, dp);
        dp[n] = ans;

        System.out.println("Brute Force Recursive Answer:");
        System.out.println(fibbR1(n));

        System.out.println("Recursive Optimized Answer:");
        System.out.println(ans);

        System.out.println("Iterative Optimized Answer:");
        System.out.println(fibbI(n));

        sc.close();
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
- Brute force recursion recalculates Fibonacci values
- Optimized recursion stores previous answers
- Iterative approach builds answer bottom-up
- Avoid repeated calculations
*/

/*
Sample Input 1:
6

Sample Output 1:
Brute Force Recursive Answer:
8
Recursive Optimized Answer:
8
Iterative Optimized Answer:
8


Sample Input 2:
10

Sample Output 2:
Brute Force Recursive Answer:
55
Recursive Optimized Answer:
55
Iterative Optimized Answer:
55
*/