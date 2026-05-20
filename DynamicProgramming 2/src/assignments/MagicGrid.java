package assignments;

/*
Problem Statement:
You are given a magic grid.
Each cell contains either positive or negative value.

Positive value increases strength.
Negative value decreases strength.

Find minimum initial strength required to
reach bottom-right cell safely.

Allowed moves:
1. Right
2. Down
*/

public class MagicGrid {
    public static int getMinimumStrength(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n + 1][m + 1];

        // initialize dp with infinity
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= m; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        // destination boundaries
        dp[n][m - 1] = 1;
        dp[n - 1][m] = 1;

        for(int i = n - 1; i >= 0; i--) {
            for(int j = m - 1; j >= 0; j--) {
                // minimum strength needed from next cell
                int neededStrength = Math.min(dp[i + 1][j], dp[i][j + 1]) - grid[i][j];

                // strength should always be at least 1
                dp[i][j] = (neededStrength <= 0) ? 1 : neededStrength;
            }
        }
        int ans = dp[0][0];
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, -3},
                {1, -2, 0}
        };

        int ans = getMinimumStrength(grid);
        System.out.println(ans); // 2
    }
}

/*
Time Complexity:
O(n*m)
- Every cell is processed once

Space Complexity:
O(n*m)
- DP array is used
*/

/*
Explanation:
- Start filling dp array from bottom-right
- Store minimum strength needed to survive
- Choose minimum from right or down cell
- Strength should never become less than 1
*/

/*
Sample Input 1:
0 1 -3
1 -2 0

Sample Output 1:
2


Sample Input 2:
0 1
2 0

Sample Output 2:
1


Sample Input 3:
0 -2 -3 1
-1 4 0 -2
1 -2 -3 0

Sample Output 3:
2
*/