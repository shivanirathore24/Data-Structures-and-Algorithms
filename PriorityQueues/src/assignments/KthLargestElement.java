package assignments;
import java.util.PriorityQueue;

/*
Problem Statement:
Find kth largest element in the array.
*/

public class KthLargestElement {
    // O(n log k)
    public static int kthLargest(int n, int[] input, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        // insert first k elements
        for (int i = 0; i < k; i++) {
            pq.add(input[i]);
        }

        // process remaining elements
        for (int i = k; i < n; i++) {
            if (pq.peek() < input[i]) {
                pq.poll();
                pq.add(input[i]);
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int arr[] = {9, 4, 8, 7, 11, 3};
        int k = 2;
        System.out.println(kthLargest(arr.length, arr, k)); // 9
    }
}

/*
Time Complexity:
O(n log k)
- Heap operations take O(log k)

Space Complexity:
O(k)
- Priority Queue stores k elements

Explanation:
- Maintain Min Priority Queue of size k
- Remove smaller elements when larger element is found
- Root of heap becomes kth largest element
*/

/*
Sample Input 1:
9 4 8 7 11 3
2

Sample Output 1:
9


Sample Input 2:
2 6 10 11 13 4 1 20
4

Sample Output 2:
10
*/