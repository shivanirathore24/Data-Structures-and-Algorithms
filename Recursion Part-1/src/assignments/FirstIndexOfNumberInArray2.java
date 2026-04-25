package assignments;

/*
Problem Statement:
Given an array of length N and an integer x, return the first index of x using recursion, or -1 if not present.
*/

public class FirstIndexOfNumberInArray2 {
    public static int firstIndexBetter(int a[], int x, int si) {
        // base case
        if (si == a.length) {
            return -1;
        }
        // check current element
        if (a[si] == x) {
            return si;
        }
        // recursive call
        return firstIndexBetter(a, x, si + 1);
    }

    public static void main(String[] args) {
        int arr[] = {3, 4, 7, 5, 9, 7, 6, 5};
        int x = 5;
        System.out.println(firstIndexBetter(arr, x, 0)); // 3
    }
}

/*
Time Complexity:
O(n)
- Each element is checked once

Space Complexity:
O(n)
- Recursion stack

Explanation:
- base case: when index reaches end → return -1
- check current element
- if found → return index immediately
- else move forward
*/

/*
Sample Input 1:
9 8 10 8 , x = 8

Sample Output 1:
1

Sample Input 2:
9 8 10 8 , x = 2

Sample Output 2:
-1
*/