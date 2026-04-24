package assignments;

import java.util.Arrays;

/*
Problem Statement:
Given an array and a number X,
find total number of triplets whose sum = X.

Note:
Array may contain duplicates.
*/

public class TripletSum {
    public static int tripletSum(int[] arr, int num) {
        int n = arr.length;
        int count = 0;

        Arrays.sort(arr); // sort array

        // fix first element
        for (int i = 0; i < n - 2; i++) {
            int j = i + 1;
            int k = n - 1;
            int target = num - arr[i];

            // two-pointer for remaining sum
            while (j < k) {
                if (arr[j] + arr[k] > target) {
                    k--;
                }
                else if (arr[j] + arr[k] < target) {
                    j++;
                }
                else {
                    // case: same elements
                    if (arr[j] == arr[k]) {
                        int total = k - j + 1;
                        count += (total * (total - 1)) / 2;
                        break;
                    }

                    // count duplicates on left
                    int tempJ = j;
                    int countJ = 0;
                    while (tempJ <= k && arr[tempJ] == arr[j]) {
                        countJ++;
                        tempJ++;
                    }

                    // count duplicates on right
                    int tempK = k;
                    int countK = 0;
                    while (tempK >= tempJ && arr[tempK] == arr[k]) {
                        countK++;
                        tempK--;
                    }
                    count += countJ * countK;
                    j = tempJ;
                    k = tempK;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        int num = 12;
        System.out.println(tripletSum(arr, num)); // 5
    }
}

/*
Time Complexity:
Sorting → O(n log n)
Loop + two-pointer → O(n^2)
Overall → O(n^2)

Space Complexity:
O(1) → no extra memory used

Explanation:
- sort the array
- fix one element (i)
- find remaining pair using two pointers (j, k)
- if sum matches → count pairs
- handle duplicates to count correctly
*/

/*
Sample Input 1:
1 2 3 4 5 6 7
12

Sample Output 1:
5

Sample Input 2:
1 2 3 4 5 6 7
19

Sample Output 2:
0

Sample Input 3:
2 -5 8 -6 0 5 10 11 -3
10

Sample Output 3:
5
*/