package assignments;

/*
Problem Statement:
Given an array of length N and an integer x, return true if x is present in the array using recursion, otherwise false.
*/

public class CheckNumberInArray1 {
    public static boolean checkNumber(int input[], int x) {
        // base case
        if (input.length == 0) {
            return false;
        }
        // check first element
        if (input[0] == x) {
            return true;
        }
        // create smaller array
        int smallArray[] = new int[input.length - 1];
        for (int i = 1; i < input.length; i++) {
            smallArray[i - 1] = input[i];
        }
        // recursive call
        boolean smallOutput = checkNumber(smallArray, x);
        return smallOutput;
    }

    public static void main(String[] args) {
        int arr[] = {2, 8, -5, 7, -9};
        System.out.println(checkNumber(arr, 7));  // true
    }
}

/*
Time Complexity:
O(n^2)
- New array created in each call → O(n)
- Total calls = n

Space Complexity:
O(n^2)
- Recursive stack + extra arrays

Explanation:
- base case: if array becomes empty, return false
- check first element
- create smaller array excluding first element
- recursively check remaining array
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