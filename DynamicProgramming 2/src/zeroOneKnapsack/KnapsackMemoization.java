package zeroOneKnapsack;

/*
Problem Statement:
Given weights and values of N items, put items in a knapsack of capacity W
to get the maximum total value.

Each item can either be included or excluded.
*/

public class KnapsackMemoization {
    public static int knapsackR2(int W, int[] val, int[] wt, int i, int[][] dp) {
        // all items processed
        if(i == val.length) {
            return 0;
        }

        // already calculated
        if(dp[i][W] != -1) {
            return dp[i][W];
        }

        int ans;

        // current item can be included
        if(wt[i] <= W) {
            int ans1, ans2;

            // include current item
            if(dp[i + 1][W - wt[i]] == -1) {
                ans1 = val[i] + knapsackR2(W - wt[i], val, wt, i + 1, dp);
                dp[i + 1][W - wt[i]] = ans1 - val[i];
            }
            else {
                ans1 = val[i] + dp[i + 1][W - wt[i]];
            }

            // exclude current item
            if(dp[i + 1][W] == -1) {
                ans2 = knapsackR2(W, val, wt, i + 1, dp);
                dp[i + 1][W] = ans2;
            }
            else {
                ans2 = dp[i + 1][W];
            }

            ans = Math.max(ans1, ans2);
        }

        // current item cannot be included
        else {
            if(dp[i + 1][W] == -1) {
                ans = knapsackR2(W, val, wt, i + 1, dp);
                dp[i + 1][W] = ans;
            }
            else {
                ans = dp[i + 1][W];
            }
        }

        dp[i][W] = ans;
        return ans;
    }

    public static void main(String[] args) {
        int[] val = {200, 300, 100};
        int[] wt = {20, 25, 30};

        int W = 50;

        int[][] dp = new int[val.length + 1][W + 1];

        // initialize dp array
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        int ans = knapsackR2(W, val, wt, 0, dp);
        System.out.println(ans); // 500
    }
}

/*
Time Complexity:
O(n*W)
- Every state is calculated only once

Space Complexity:
O(n*W)
- DP array and recursive stack space
*/

/*
Explanation:
- Store already calculated states in dp array
- For every item choose include or exclude
- Include only when weight is within capacity
- Avoid repeated recursive calculations
*/

/*
Sample Input 1:
Values = 200 300 100
Weights = 20 25 30
W = 50

Sample Output 1:
500


Sample Input 2:
Values = 60 100 120
Weights = 10 20 30
W = 50

Sample Output 2:
220


Sample Input 3:
Values = 10 40 30 50
Weights = 5 4 6 3
W = 10

Sample Output 3:
90
*/