package assignments;

/*
Problem Statement:
Given an NxM matrix containing only 0s and 1s,
find the size of the largest square sub-matrix with all 0s.
*/

public class MaximumSquareMatrix {
    public static int findMaxSquareWithAllZeros(int[][] input) {
        int m = input.length;

        // empty matrix
        if(m == 0) {
            return 0;
        }

        int n = input[0].length;
        int[][] dp = new int[m][n];

        int maxSize = 0;
        // fill last row
        for(int j = 0; j < n; j++) {

            if(input[m - 1][j] == 0) {
                dp[m - 1][j] = 1;
                maxSize = 1;
            }
        }

        // fill last column
        for(int i = 0; i < m; i++) {
            if(input[i][n - 1] == 0) {
                dp[i][n - 1] = 1;
                maxSize = 1;
            }
        }

        // fill remaining cells
        for(int i = m - 2; i >= 0; i--) {
            for(int j = n - 2; j >= 0; j--) {
                // current cell contains 1
                if(input[i][j] == 1) {
                    dp[i][j] = 0;
                }
                // current cell contains 0
                else {
                    int ans1 = dp[i + 1][j];
                    int ans2 = dp[i][j + 1];
                    int ans3 = dp[i + 1][j + 1];

                    dp[i][j] = 1 + Math.min(ans1, Math.min(ans2, ans3));
                    maxSize = Math.max(maxSize, dp[i][j]);
                }
            }
        }
        return maxSize;
    }

    public static void main(String[] args) {
        int[][] input = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        int ans = findMaxSquareWithAllZeros(input);
        System.out.println(ans); // 4
    }
}

/*
Time Complexity:
O(m*n)
- Every cell is visited once

Space Complexity:
O(m*n)
- DP array is used
*/

/*
Explanation:
- Store maximum square size possible from every cell
- If current cell is 1, answer becomes 0
- If current cell is 0, take minimum of right, down and diagonal
- Add 1 for current cell
*/

/*
Sample Input 1:
1 1 0
1 1 1
1 1 1

Sample Output 1:
1


Sample Input 2:
0 0 0 0
0 0 0 0
0 0 0 0
0 0 0 0

Sample Output 2:
4


Sample Input 3:
0 1 0 0
0 0 0 0
0 0 0 0
1 0 0 0

Sample Output 3:
3
*/