package assignments;
import java.util.HashMap;

/*
Problem Statement:
Find and return the element with maximum frequency in the array.
If multiple elements have same maximum frequency,
return the element that appears first in the array.
*/

public class MaxFrequencyNumber {
    // O(n)
    public static int maxFrequencyNumber(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // store frequency of elements
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        int max = 0;
        int maxKey = Integer.MIN_VALUE;

        // find element with maximum frequency
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) > max) {
                max = map.get(arr[i]);
                maxKey = arr[i];
            }
        }
        return maxKey;
    }

    public static void main(String[] args) {
        int arr[] = {32, 14, 14, 76, 14, 32, 32, 29};
        System.out.println(maxFrequencyNumber(arr)); // 32
    }
}

/*
Time Complexity:
O(n)
- Array is traversed twice

Space Complexity:
O(n)
- HashMap stores frequencies of elements

Explanation:
- Store frequency of every element in HashMap
- Traverse array again to find maximum frequency
- First occurring element is automatically selected in tie case
*/

/*
Sample Input 1:
32 14 14 76 14 32 32 29

Sample Output 1:
32

Sample Input 2:
6 12 6 11 12 6 1 6

Sample Output 2:
6
*/