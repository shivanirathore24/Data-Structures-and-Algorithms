package assignments;
import java.util.HashMap;

/*
Problem Statement:
Find the length of the longest subarray whose sum is zero.
*/

public class LongestSubArrayZeroSum {
    // O(n)
    public static int lengthOfLongestSubsetWithZeroSum(int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;

        // create prefix sum array
        for (int i = 1; i < n; i++) {
            arr[i] += arr[i - 1];
        }

        int len = 0;
        for (int i = 0; i < n; i++) {
            // subarray from 0 to i has sum 0
            if (arr[i] == 0) {
                if (len < i + 1) {
                    len = i + 1;
                }
            }
            // repeated prefix sum found
            else if (map.containsKey(arr[i])) {
                if (len < i - map.get(arr[i])) {
                    len = i - map.get(arr[i]);
                }
            }
            // store first occurrence of prefix sum
            else {
                map.put(arr[i], i);
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int arr[] = {6, 3, -1, 2, -4, 3, 1, -2, 20};
        System.out.println(lengthOfLongestSubsetWithZeroSum(arr)); // 5
    }
}

/*
Time Complexity:
O(n)
- Array is traversed once

Space Complexity:
O(n)
- HashMap stores prefix sums

Explanation:
- Calculate prefix sums of array
- If same prefix sum repeats,
  subarray between them has sum 0
- Track maximum subarray length
*/

/*
Sample Input 1:
95 -97 -387 -435 -5 -70 897 127 23 284

Sample Output 1:
5

Sample Input 2:
6 3 -1 2 -4 3 1 -2 20

Sample Output 2:
5
*/