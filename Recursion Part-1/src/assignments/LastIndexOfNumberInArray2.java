package assignments;

/*
Problem Statement:
Given an array of length N and an integer x, return the last index of x using recursion, or -1 if not present.
*/

public class LastIndexOfNumberInArray2 {
    public static int lastIndexBetter(int a[], int x, int si) {
        // base case
        if (si == a.length) {
            return -1;
        }

        // recursive call
        int k = lastIndexBetter(a, x, si + 1);

        // calculation
        if (k != -1) {
            return k;
        } else {
            if (a[si] == x) {
                return si;
            } else {
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {3, 4, 7, 5, 9, 7, 6, 5};
        System.out.println(lastIndexBetter(arr, 7, 0)); // 5
        System.out.println(lastIndexBetter(arr, 2, 0)); // -1
    }
}

/*
Time Complexity:
O(n)
- Each element is processed once

Space Complexity:
O(n)
- Recursion stack

Explanation:
- base case: when index reaches end → return -1
- go till end first
- while returning, check elements
- first match during backtracking = last occurrence
*/

/*
Sample Input 1:
9 8 10 8 , x = 8

Sample Output 1:
3

Sample Input 2:
9 8 10 8 , x = 2

Sample Output 2:
-1
*/