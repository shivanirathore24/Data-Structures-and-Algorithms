package zeroOneKnapsack;

/*
Problem Statement:
Given weights and values of N items, put items in a knapsack of capacity W
to get the maximum total value.

Each item can either be included or excluded.
*/

public class KnapsackIterative {
    public static int knapsackI(int W, int[] val, int[] wt) {
        int n = val.length;

        int[][] dp = new int[n + 1][W + 1];

        // fill dp array bottom-up
        for(int i = n - 1; i >= 0; i--) {
            for(int w = 0; w <= W; w++) {

                int ans;

                // current item can be included
                if(wt[i] <= w) {
                    // include current item
                    int ans1 = val[i] + dp[i + 1][w - wt[i]];

                    // exclude current item
                    int ans2 = dp[i + 1][w];

                    ans = Math.max(ans1, ans2);
                }
                // current item cannot be included
                else {
                    ans = dp[i + 1][w];
                }
                dp[i][w] = ans;
            }
        }

        return dp[0][W];
    }

    public static void main(String[] args) {
        int[] val = {200, 300, 100};
        int[] wt = {20, 25, 30};
        int W = 50;

        int ans = knapsackI(W, val, wt);
        System.out.println(ans); // 500
    }
}

/*
Time Complexity:
O(n*W)
- Every state is visited once

Space Complexity:
O(n*W)
- DP array is used
*/

/*
Explanation:
- Build answer using bottom-up DP
- For every item choose include or exclude
- Include only when weight is within capacity
- Store maximum value for every state
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