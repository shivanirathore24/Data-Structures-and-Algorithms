package timeComplexity;

import java.util.Arrays;

/*
Problem Statement:
You are given two integer arrays ARR1 and ARR2 of size N and M.
Print their intersection.
Intersection means common elements present in both arrays.

Note:
- Arrays can contain duplicate elements
- Each element should be printed as many times as it appears in both arrays
- Output should be in ascending order
*/

public class IntersectionOfArray {
    public static void intersectionOfArray(int[] arr1, int[] arr2) {
        // sort both arrays
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int i = 0, j = 0;
        // two-pointer traversal
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == arr2[j]) {
                System.out.print(arr1[i] + " ");
                i++;
                j++;
            }
            else if (arr1[i] < arr2[j]) {
                i++;
            }
            else {
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int arr1[] = {6, 2, 6, 2, 1, 9, 8};
        int arr2[] = {3, 6, 8, 2, 9};
        intersectionOfArray(arr1, arr2); // 2 6 8 9
    }
}

/*
Time Complexity:
Sorting → O(n log n)
Traversal → O(n)
Overall → O(n log n)

Space Complexity:
O(1) → only pointers used

Explanation:
- sort both arrays
- use two pointers to compare elements
- move pointers based on smaller value
*/

/*
Sample Input 1:
2 6 8 5 4 3
2 3 4 7

Sample Output 1:
2 3 4

Sample Input 2:
2 6 1 2
1 2 3 4 2

Sample Output 2:
1 2 2
*/