package assignments;
import java.util.Arrays;

/*
Problem Statement:
Count number of pairs in array whose sum = num.

Note:
- Array may contain duplicate elements
*/

public class PairSum {
    public static int pairSum(int[] arr, int num) {
        Arrays.sort(arr);

        int start = 0;
        int end = arr.length - 1;
        int count = 0;

        while (start < end) {
            int sum = arr[start] + arr[end];
            if (sum < num) {
                start++;
            }
            else if (sum > num) {
                end--;
            }
            else {
                int startVal = arr[start];
                int endVal = arr[end];
                // same elements → use combination
                if (startVal == endVal) {
                    int total = end - start + 1;
                    count += (total * (total - 1)) / 2;
                    return count;
                }
                // count duplicates from left
                int tempStart = start + 1;
                while (tempStart <= end && arr[tempStart] == startVal) {
                    tempStart++;
                }
                // count duplicates from right
                int tempEnd = end - 1;
                while (tempEnd >= tempStart && arr[tempEnd] == endVal) {
                    tempEnd--;
                }

                int countLeft = tempStart - start;
                int countRight = end - tempEnd;

                count += countLeft * countRight;
                start = tempStart;
                end = tempEnd;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 6, 2, 5, 4, 3, 2, 4};
        int num = 7;
        System.out.println(pairSum(arr, num)); // 7
    }
}

/*
Time Complexity:
Sorting → O(n log n)
Traversal → O(n)
Overall → O(n log n)

Space Complexity:
O(1) → only pointers/variables used

Explanation:
- sort array first to apply two pointer approach
- move start and end based on sum comparison
- count duplicates properly to handle repeated elements
*/

/*
Sample Input 1:
1 3 6 2 5 4 3 2 4
7

Sample Output 1:
7

Sample Input 2:
2 8 10 5 -2 5
10

Sample Output 2:
2
*/