package assignments;

/*
Problem Statement:
Given an array of size N containing numbers from 0 to (N-2),
one number is repeated twice.
Find and return the duplicate number.

Note:
Duplicate is always present.
*/

public class DuplicateInArray {

    public static int findDuplicate(int[] arr) {

        int n = arr.length;
        int sumOfArray = 0;

        // sum of array
        for (int i = 0; i < n; i++) {
            sumOfArray += arr[i];
        }

        // expected sum from 0 to (n-2)
        int expectedSum = (n - 2) * (n - 1) / 2;

        // alternate way (same logic)
        // int expectedSum = 0;
        // for (int i = 0; i < n - 1; i++) {
        //     expectedSum += i;
        // }

        return sumOfArray - expectedSum;
    }

    public static void main(String[] args) {
        int arr[] = {0, 7, 2, 5, 4, 7, 1, 3, 6};
        System.out.println(findDuplicate(arr)); // 7
    }
}

/*
Time Complexity:
Single loop → O(n)
Overall → O(n)

Space Complexity:
O(1) → no extra memory used

Explanation:
- calculate sum of array elements
- subtract expected sum from 0 to (n-2)
- remaining value is the duplicate
*/

/*
Sample Input 1:
0 7 2 5 4 7 1 3 6

Sample Output 1:
7

Sample Input 2:
0 2 1 3 1

Sample Output 2:
1

Sample Input 3:
0 3 1 5 4 3 2

Sample Output 3:
3
*/