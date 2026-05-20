package zeroOneKnapsack;

/*
Problem Statement:
Given weights and values of N items, put items in a knapsack of capacity W
to get the maximum total value.

Each item can either be included or excluded.
*/

public class KnapsackRecursive {
    public static int knapsackR1(int W, int[] val, int[] wt, int i) {
        // all items processed
        if(i == val.length) {
            return 0;
        }

        int ans;

        // current item can be included
        if(wt[i] <= W) {
            // include current item
            int ans1 = val[i] + knapsackR1(W - wt[i], val, wt, i + 1);

            // exclude current item
            int ans2 = knapsackR1(W, val, wt, i + 1);

            ans = Math.max(ans1, ans2);
        }
        // current item cannot be included
        else {
            ans = knapsackR1(W, val, wt, i + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] val = {200, 300, 100};
        int[] wt = {20, 25, 30};
        int W = 50;

        int ans = knapsackR1(W, val, wt, 0);
        System.out.println(ans); // 500
    }
}

/*
Time Complexity:
O(2^n)
- Every item has two choices include or exclude

Space Complexity:
O(n)
- Recursive stack space
*/

/*
Explanation:
- For every item choose include or exclude
- Include only when weight is within capacity
- Return maximum possible value
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