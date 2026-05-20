package assignments;

/*
Problem Statement:
A teacher wants to distribute chocolates to students.

Rules:
1. Every student gets at least one chocolate
2. Student with higher score than adjacent student
   must get more chocolates

Find minimum chocolates required.
*/

public class MinimumChocolates {
    public static int getMin(int arr[], int N) {
        int dp[] = new int[N];

        // first student gets 1 chocolate
        dp[0] = 1;

        // left to right traversal
        for(int i = 1; i < N; i++) {
            if(arr[i] > arr[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
        }

        // right to left traversal
        for(int i = N - 2; i >= 0; i--) {
            if(arr[i] > arr[i + 1] && dp[i] <= dp[i + 1]) {
                dp[i] = dp[i + 1] + 1;
            }
        }

        int sum = 0;
        // calculate total chocolates
        for(int i = 0; i < N; i++) {
            sum += dp[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        int arr[] = {1, 4, 4, 6};
        int ans = getMin(arr, arr.length);
        System.out.println(ans); // 6
    }
}

/*
Time Complexity:
O(n)
- Array is traversed twice

Space Complexity:
O(n)
- Extra dp array is used
*/

/*
Explanation:
- First traversal handles increasing order
- Second traversal handles decreasing order
- Sum of all chocolates gives final answer
*/

/*
Sample Input 1:
1 4 4 6

Sample Output 1:
6


Sample Input 2:
8 7 5

Sample Output 2:
6


Sample Input 3:
1 2 3 2 1

Sample Output 3:
9
*/