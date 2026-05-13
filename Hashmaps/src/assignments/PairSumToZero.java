package assignments;
import java.util.HashMap;

/*
Problem Statement:
Given a random integer array A of size N.
Find and print the count of pair of elements in the array which sum up to 0.
Array can contain duplicate elements as well.
*/

public class PairSumToZero {
    // O(n)
    public static int PairSum(int[] input, int size) {
        if (size == 0) {
            return 0;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        // store frequency of elements
        for (int key : input) {
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }

        int countPairs = 0;
        // count pairs whose sum is zero
        for (Integer i : map.keySet()) {
            if (map.containsKey(-i) && i != 0) {
                countPairs =
                        countPairs + (map.get(i) * map.get(-i));
            }
        }

        countPairs = countPairs / 2;

        // handle zero separately
        if (map.containsKey(0)) {
            int val = map.get(0);
            countPairs =
                    countPairs + (val * (val - 1)) / 2;
        }
        return countPairs;
    }

    public static void main(String[] args) {
        int arr[] = {2, 1, -2, 2, 3};
        System.out.println(PairSum(arr, arr.length)); // 2
    }
}

/*
Time Complexity:
O(n)
- Array and HashMap are traversed once

Space Complexity:
O(n)
- HashMap stores frequencies of elements

Explanation:
- Store frequency of every element in HashMap
- Check whether negative value exists
- Multiply frequencies to count valid pairs
- Handle 0 separately using combination formula
*/

/*
Sample Input 1:
2 1 -2 2 3

Sample Output 1:
2

Sample Input 2:
0 0 0 2 -2 3 -3

Sample Output 2:
5
*/