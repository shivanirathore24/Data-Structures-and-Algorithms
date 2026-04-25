package assignments;

/*
Problem Statement:
Given an array of length N and an integer x, return true if x is present in the array using recursion, otherwise false.
*/

public class CheckNumberInArray2 {
    public static boolean checkNumberBetter(int input[], int x, int si) {
        // base case
        if (si == input.length) {
            return false;
        }
        // check current element
        if (input[si] == x) {
            return true;
        }
        // recursive call
        return checkNumberBetter(input, x, si + 1);
    }

    public static void main(String[] args) {
        int arr[] = {2, 8, -5, 7, -9};
        System.out.println(checkNumberBetter(arr, 7, 0));  // true
    }
}

/*
Time Complexity:
O(n)
- Each element is checked once

Space Complexity:
O(n)
- Only recursion stack used

Explanation:
- base case: when index reaches end, return false
- check current element
- move forward using index
- no extra array → efficient
*/

/*
Sample Input 1:
2 8 -5 7 -9 , x = 7

Sample Output 1:
true

Sample Input 2:
2 8 -5 7 -9 , x = 10

Sample Output 2:
false
*/