package assignments;

/*
Problem Statement:
Find minimum edit distance between two strings using memoization.

Operations allowed:
1. Insert
2. Delete
3. Replace
*/

public class EditDistance {
    public static int editDistanceR(String s, String t, int[][] dp) {
        // base cases
        if(s.length() == 0) {
            return t.length();
        }

        if(t.length() == 0) {
            return s.length();
        }

        int m = s.length();
        int n = t.length();

        // already calculated
        if(dp[m][n] != -1) {
            return dp[m][n];
        }

        int myAns;

        // characters match
        if(s.charAt(0) == t.charAt(0)) {
            int smallAns;

            if(dp[m - 1][n - 1] == -1) {
                smallAns = editDistanceR(s.substring(1), t.substring(1), dp);
                dp[m - 1][n - 1] = smallAns;
            }
            else {
                smallAns = dp[m - 1][n - 1];
            }

            myAns = smallAns;
        }
        else {
            int remove, insert, replace;

            // remove operation
            if(dp[m - 1][n] == -1) {
                remove = editDistanceR(s.substring(1), t, dp);
                dp[m - 1][n] = remove;
            }
            else {
                remove = dp[m - 1][n];
            }

            // insert operation
            if(dp[m][n - 1] == -1) {
                insert = editDistanceR(s, t.substring(1), dp);
                dp[m][n - 1] = insert;
            }
            else {
                insert = dp[m][n - 1];
            }

            // replace operation
            if(dp[m - 1][n - 1] == -1) {
                replace = editDistanceR(s.substring(1), t.substring(1), dp);
                dp[m - 1][n - 1] = replace;
            }
            else {
                replace = dp[m - 1][n - 1];
            }

            myAns = 1 + Math.min(remove, Math.min(insert, replace));
        }
        dp[m][n] = myAns;
        return myAns;
    }

    public static void main(String[] args) {
        String s = "abcdef";
        String t = "azced";

        int[][] dp = new int[s.length() + 1][t.length() + 1];

        // initialize dp array
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        int ans = editDistanceR(s, t, dp);
        System.out.println(ans); // 3
    }
}

/*
Time Complexity:
O(m*n)
- Every state is calculated only once

Space Complexity:
O(m*n)
- DP array and recursive stack space
*/

/*
Explanation:
- If characters match, move forward
- Otherwise perform insert, delete or replace
- Store answers in dp array
- Avoid repeated recursive calculations
*/

/*
Sample Input 1:
abc
dc

Sample Output 1:
2


Sample Input 2:
whgtdwhgtdg
aswcfg

Sample Output 2:
9


Sample Input 3:
abcdef
azced

Sample Output 3:
3
*/