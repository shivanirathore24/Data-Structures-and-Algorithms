package minimumCostPath;

/*
Problem Statement:
Find minimum cost path from top-left to bottom-right.
Allowed moves:
1. Down
2. Right
3. Diagonal
*/

public class MinCostRecursive {
    public static int minCostR1(int[][] cost, int i, int j) {
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

        // down, right and diagonal answers
        int ans1 = minCostR1(cost, i + 1, j);
        int ans2 = minCostR1(cost, i, j + 1);
        int ans3 = minCostR1(cost, i + 1, j + 1);

        // minimum cost for current cell
        int myAns = cost[i][j] + Math.min(ans1, Math.min(ans2, ans3));

        return myAns;
    }

    public static void main(String[] args) {
        int[][] cost = {{1, 5, 11}, {8, 13, 12}, {2, 3, 7}, {15, 16, 18}};
        int ans = minCostR1(cost, 0, 0);
        System.out.println(ans); // 30
    }
}

/*
Time Complexity:
O(3^(m+n))
- Three recursive calls are made at each cell

Space Complexity:
O(m+n)
- Recursive stack space
*/

/*
Explanation:
- Move down, right or diagonal
- Choose minimum among all possible paths
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