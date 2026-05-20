package minimumCostPath;

/*
Problem Statement:
Find minimum cost path from top-left to bottom-right using iterative bottom-up approach.
Allowed moves:
1. Down
2. Right
3. Diagonal
*/

public class MinCostIterative_BottomUp {
    public static int minCostI(int[][] cost) {
        int m = cost.length;
        int n = cost[0].length;

        int[][] dp = new int[m + 1][n + 1];

        // initialize dp array
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        // fill dp array from bottom-right to top-left
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                // destination cell
                if (i == m - 1 && j == n - 1) {
                    dp[i][j] = cost[i][j];
                    continue;
                }

                // right, down and diagonal answers
                int ans1 = dp[i][j + 1];
                int ans2 = dp[i + 1][j];
                int ans3 = dp[i + 1][j + 1];

                // minimum cost for current cell
                dp[i][j] = cost[i][j] + Math.min(ans1, Math.min(ans2, ans3));
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] cost = {{1, 5, 11}, {8, 13, 12}, {2, 3, 7}, {15, 16, 18}};
        int ans = minCostI(cost);
        System.out.println(ans); // 30
    }
}

/*
Time Complexity:
O(m*n)
- Every cell is visited once

Space Complexity:
O(m*n)
- DP array is used to store minimum cost
*/

/*
Explanation:
- Start filling dp array from bottom-right
- Move in reverse order
- Store minimum cost for every cell
- Choose minimum among right, down and diagonal
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