package commonSubsequence;

/*
Problem Statement:
Find length of Longest Common Subsequence using iterative approach.
*/

public class LCSIterative {
    public static int lcsI(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int[][] dp = new int[m + 1][n + 1];

        // fill dp array from bottom-right
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int ans;

                // characters match
                if (str1.charAt(i) == str2.charAt(j)) {
                    ans = 1 + dp[i + 1][j + 1];
                } else {
                    int ans1 = dp[i][j + 1];
                    int ans2 = dp[i + 1][j];

                    ans = Math.max(ans1, ans2);
                }
                dp[i][j] = ans;
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        String str1 = "adebc";
        String str2 = "dcadb";

        int ans = lcsI(str1, str2);
        System.out.println(ans); // 3
    }
}

/*
Time Complexity:
O(m*n)
- Every state is calculated once

Space Complexity:
O(m*n)
- DP array is used
*/

/*
Explanation:
- Fill dp array from bottom-right
- If characters match, include them
- Otherwise take maximum of two possibilities
- Store answer for every state
*/

/*
Sample Input 1:
adebc
dcadb

Sample Output 1:
3


Sample Input 2:
ab
defg

Sample Output 2:
0
*/