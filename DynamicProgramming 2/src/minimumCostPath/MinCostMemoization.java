package minimumCostPath;

/*
Problem Statement:
Find minimum cost path from top-left to bottom-right using memoization.
Allowed moves:
1. Down
2. Right
3. Diagonal
*/

public class MinCostMemoization {
    public static int minCostR(int[][] cost, int i, int j, int[][] dp) {
        int m = cost.length;
        int n = cost[0].length;

        // destination cell
        if (i == m - 1 && j == n - 1) {
            return cost[i][j];
        }

        // out of bounds
        if (i >= m || j >= n) {
            return Integer.MAX_VALUE;
        }

        int ans1, ans2, ans3;

        // down answer
        if (dp[i + 1][j] == Integer.MIN_VALUE) {
            ans1 = minCostR(cost, i + 1, j, dp);
            dp[i + 1][j] = ans1;
        } else {
            ans1 = dp[i + 1][j];
        }

        // right answer
        if (dp[i][j + 1] == Integer.MIN_VALUE) {
            ans2 = minCostR(cost, i, j + 1, dp);
            dp[i][j + 1] = ans2;
        } else {
            ans2 = dp[i][j + 1];
        }

        // diagonal answer
        if (dp[i + 1][j + 1] == Integer.MIN_VALUE) {
            ans3 = minCostR(cost, i + 1, j + 1, dp);
            dp[i + 1][j + 1] = ans3;
        } else {
            ans3 = dp[i + 1][j + 1];
        }

        // minimum cost for current cell
        int myAns = cost[i][j] + Math.min(ans1, Math.min(ans2, ans3));
        return myAns;
    }

    public static void main(String[] args) {
        int[][] cost = {{1, 5, 11}, {8, 13, 12}, {2, 3, 7}, {15, 16, 18}};
        int[][] dp = new int[cost.length + 1][cost[0].length + 1];

        // initialize dp array
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }

        int ans = minCostR(cost, 0, 0, dp);
        System.out.println(ans); // 30
    }
}

/*
Time Complexity:
O(m*n)
- Each cell value is calculated only once

Space Complexity:
O(m*n)
- DP array and recursive stack space
*/

/*
Explanation:
- Move down, right or diagonal
- Store already calculated answers in dp array
- Avoid repeated recursive calculations
- Add current cell cost to minimum answer
*/

/*
Sample Input 1:
1 5 11
8 13 12
2 3 7
15 16 18

Sample Output 1:
30


Sample Input 2:
1 2 3
4 8 2
1 5 3

Sample Output 2:
8
*/