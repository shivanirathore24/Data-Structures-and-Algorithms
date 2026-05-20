package commonSubsequence;

/*
Problem Statement:
Find length of Longest Common Subsequence using memoization.
*/

public class LCSMemoization {
    public static int lcsR2(String str1, String str2, int i, int j, int[][] dp) {
        // base case
        if (i == str1.length() || j == str2.length()) {
            return 0;
        }

        int myAns;

        // characters match
        if (str1.charAt(i) == str2.charAt(j)) {
            int smallAns;

            if (dp[i + 1][j + 1] == -1) {
                smallAns = lcsR2(str1, str2, i + 1, j + 1, dp);
                dp[i + 1][j + 1] = smallAns;
            } else {
                smallAns = dp[i + 1][j + 1];
            }
            myAns = 1 + smallAns;
        } else {
            int ans1, ans2;

            if (dp[i + 1][j] == -1) {
                ans1 = lcsR2(str1, str2, i + 1, j, dp);
                dp[i + 1][j] = ans1;
            } else {
                ans1 = dp[i + 1][j];
            }

            if (dp[i][j + 1] == -1) {
                ans2 = lcsR2(str1, str2, i, j + 1, dp);
                dp[i][j + 1] = ans2;
            } else {
                ans2 = dp[i][j + 1];
            }

            myAns = Math.max(ans1, ans2);
        }
        return myAns;
    }

    public static void main(String[] args) {
        String str1 = "adebc";
        String str2 = "dcadb";

        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        // initialize dp array
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        int ans = lcsR2(str1, str2, 0, 0, dp);
        System.out.println(ans); // 3
    }
}

/*
Time Complexity:
O(m*n)
- Each state is calculated only once

Space Complexity:
O(m*n)
- DP array and recursive stack space
*/

/*
Explanation:
- Store already calculated answers in dp array
- If characters match, include them
- Otherwise try both possibilities
- Avoid repeated recursive calculations
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