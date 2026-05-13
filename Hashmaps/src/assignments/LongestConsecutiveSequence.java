package assignments;
import java.util.ArrayList;
import java.util.HashMap;

/*
Problem Statement:
Find the longest possible sequence of consecutive numbers.
Return starting and ending element of the sequence.
If two sequences have same length, return the one
whose starting element appears first in the array.
*/

public class LongestConsecutiveSequence {
    // O(n)
    public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {
        ArrayList<Integer> output = new ArrayList<>();

        HashMap<Integer, Boolean> map = new HashMap<>();
        HashMap<Integer, Integer> lenMap = new HashMap<>();

        // mark all numbers as unvisited
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], true);
        }

        int maxStart = -1;
        int maxLen = 0;

        for (int i : arr) {
            if (map.get(i)) {
                int currStart = i;
                int currLen = 1;

                map.put(i, false);
                int ahead = i + 1;

                // check forward sequence
                while (map.containsKey(ahead)) {
                    currLen++;
                    map.put(ahead, false);
                    ahead++;
                }

                int before = i - 1;

                // check backward sequence
                while (map.containsKey(before)) {
                    currLen++;
                    currStart = before;
                    map.put(before, false);
                    before--;
                }

                // update longest sequence
                if (currLen >= maxLen) {
                    maxLen = currLen;
                    maxStart = currStart;

                    lenMap.put(maxStart, maxLen);
                }
            }
        }

        // handle equal length sequence case
        for (int i = 0; i < arr.length; i++) {
            if (lenMap.containsKey(arr[i]) && lenMap.get(arr[i]) >= maxLen) {
                maxStart = arr[i];
                maxLen = lenMap.get(arr[i]);
                break;
            }
        }
        output.add(maxStart);

        // sequence length = 1
        if (maxLen == 1) {
            return output;
        }

        output.add(maxStart + maxLen - 1);
        return output;
    }

    public static void main(String[] args) {
        int arr[] = {3, 7, 2, 1, 9, 8, 41};
        System.out.println(longestConsecutiveIncreasingSequence(arr)); // [7, 9]
    }
}

/*
Time Complexity:
O(n)
- Every element is visited at most once

Space Complexity:
O(n)
- HashMaps store array elements and sequence lengths

Explanation:
- Store all elements in HashMap
- Expand sequence forward and backward
- Track longest consecutive sequence
- Handle equal length sequences using original order
*/

/*
Sample Input 1:
2 12 9 16 10 5 3 20 25 11 1 8 6

Sample Output 1:
[8, 12]


Sample Input 2:
3 7 2 1 9 8 41

Sample Output 2:
[7, 9]


Sample Input 3:
15 24 23 12 19 11 16

Sample Output 3:
[15, 16]
*/