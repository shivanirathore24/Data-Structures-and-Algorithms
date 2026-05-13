package assignments;
import java.util.HashMap;

/*
Problem Statement:
Find the count of all pairs having absolute difference K.
*/

public class PairsWithDifferenceK {
    // O(n)
    public static int getPairsWithDifferenceK(int arr[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int pairCount = 0;

        for (int item : arr) {
            int p1 = item + k;
            boolean flag = false;

            // special case for k = 0
            if (item == p1) {
                flag = true;
            }

            // check item + k
            if (map.containsKey(p1)) {
                pairCount += map.get(p1);
            }

            int p2 = item - k;

            // check item - k
            if (map.containsKey(p2) && !flag) {
                pairCount += map.get(p2);
            }

            // update frequency
            if (map.containsKey(item)) {
                map.put(item, map.get(item) + 1);
            } else {
                map.put(item, 1);
            }
        }
        return pairCount;
    }

    public static void main(String[] args) {
        int arr[] = {2, -1, 3, 5, 6, 0, -1, 2, 6};
        int k = 3;
        System.out.println(getPairsWithDifferenceK(arr, k)); // 9
    }
}

/*
Time Complexity:
O(n)
- Array is traversed once

Space Complexity:
O(n)
- HashMap stores frequency of elements

Explanation:
- Store elements in HashMap with frequencies
- Check whether item + k or item - k exists
- Count valid pairs formed by all occurrences
- Handle k = 0 separately to avoid same pair counting twice
*/

/*
Sample Input 1:
5 1 2 4
3

Sample Output 1:
2

Sample Input 2:
4 4 4 4
0

Sample Output 2:
6
*/