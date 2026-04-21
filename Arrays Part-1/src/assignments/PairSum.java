package assignments;

/*
Problem Statement:
You are given an array and a number X.
Find and return the total number of pairs in the array whose sum is equal to X.
*/

public class PairSum {
    public static int pairSum(int arr[], int x) {
        int count = 0;
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == x) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {2, 8, 10, 5, -2, 5};
        int x = 10;
        System.out.println(pairSum(arr, x));
    }
}

/*
Sample Input 1:
arr = 1 3 6 2 5 4 3 2 4
x = 7

Sample Output 1:
7

Sample Input 2:
arr = 2 8 10 5 -2 5
x = 10

Sample Output 2:
2
*/