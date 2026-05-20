package assignments;

/*
Problem Statement:
Given an array and a target sum K,
return true if there exists a subset
with sum equal to K, otherwise false.
*/

public class SubsetSum {
    // O(n * sum)
    public static boolean isSubsetPresent(int[] arr, int n, int sum) {
        // dp[i][j] = true if subset sum j
        // can be formed using first i elements
        boolean dp[][] = new boolean[n + 1][sum + 1];

        // sum 0 is always possible
        for(int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // if no elements, non-zero sum not possible
        for(int j = 1; j <= sum; j++) {
            dp[0][j] = false;
        }

        // fill dp table
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= sum; j++) {
                // current element greater than sum
                if(j < arr[i - 1]) {
                    dp[i][j] = dp[i - 1][j];

                } else {
                    // include or exclude current element
                    dp[i][j] = dp[i - 1][j] ||
                            dp[i - 1][j - arr[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        int arr[] = {4, 2, 5, 6, 7};
        int sum = 14;

        boolean ans = isSubsetPresent(arr, arr.length, sum);
        System.out.println(ans); // true
    }
}

/*
Time Complexity:
O(n * sum)
- DP table of size n * sum is filled

Space Complexity:
O(n * sum)
- Extra DP table is used
*/

/*
Explanation:
- Either include current element
  or exclude it
- DP stores whether a subset sum
  is possible or not
*/

/*
Sample Input 1:
4 3 5 2
13

Sample Output 1:
false


Sample Input 2:
4 2 5 6 7
14

Sample Output 2:
true


Sample Input 3:
1 2 3 7
6

Sample Output 3:
true
*/