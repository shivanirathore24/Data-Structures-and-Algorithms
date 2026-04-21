package assignments;

/*
Problem Statement:
You have been given an integer array/list(ARR) of size N which contains numbers from 0 to (N - 2).
One number is present twice. Find and return that duplicate number.
*/

public class FindDuplicate {
    public static int findDuplicate(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    return arr[i];
                }
            }
        }
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        int arr[] = {4, 2, 3, 1, 4, 0};
        System.out.println(findDuplicate(arr));
    }
}

/*
Sample Input 1:
0 7 2 5 4 7 1 3 6

Sample Output 1:
7

Sample Input 2:
0 2 1 3 1

Sample Output 2:
1
*/