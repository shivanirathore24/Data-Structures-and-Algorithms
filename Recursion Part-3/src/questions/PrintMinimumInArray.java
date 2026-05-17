package questions;

/*
Problem Statement:
Print minimum element in array using recursion.
*/

public class PrintMinimumInArray {
    // O(n)
    public static void printMin1(int[] arr) {
        int min = findMin(arr, 0);
        System.out.println(min); // 1
    }

    // O(n)
    public static int findMin(int[] input, int startIndex) {
        // base case
        if (startIndex == input.length) {
            return Integer.MAX_VALUE;
        }

        int minSmallArray = findMin(input, startIndex + 1);

        // compare current element
        if (input[startIndex] < minSmallArray) {
            return input[startIndex];
        } else {
            return minSmallArray;
        }
    }

    // O(n)
    public static void printMin2(int[] arr, int startIndex, int minimum) {
        // base case
        if (startIndex == arr.length) {
            System.out.println(minimum); // 1
            return;
        }

        int newMinimum = minimum;

        // update minimum
        if (arr[startIndex] < minimum) {
            newMinimum = arr[startIndex];
        }
        printMin2(arr, startIndex + 1, newMinimum);
    }

    public static void main(String[] args) {
        int arr[] = {3, 4, 2, 1, 7, 8};
        printMin1(arr);  // way 1
        printMin2(arr, 0, Integer.MAX_VALUE);  // way 2
    }
}

/*
Time Complexity:
O(n)
- Array is traversed once recursively

Space Complexity:
O(n)
- Recursive stack stores function calls

Explanation:
- findMin() returns minimum recursively
- printMin2() keeps track of current minimum
- Compare every element with minimum value
*/

/*
Sample Input 1:
3 4 2 1 7 8

Sample Output 1:
1
1


Sample Input 2:
9 5 11 2 6

Sample Output 2:
2
2
*/