package assignments;
import java.util.ArrayList;
import java.util.PriorityQueue;

/*
Problem Statement:
Find k largest elements from the array using Priority Queue.
*/

public class KLargestElement {
    // O(n log k)
    public static void printKLargest1(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        // insert first k elements
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }

        // process remaining elements
        for (int i = k; i < arr.length; i++) {
            if (pq.peek() < arr[i]) {
                pq.poll();
                pq.add(arr[i]);
            }
        }

        // print k largest elements
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }

    // O(n log k)
    public static ArrayList<Integer> printKLargest2(int[] arr, int k) {
        ArrayList<Integer> output = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        // insert first k elements
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }

        // process remaining elements
        for (int i = k; i < arr.length; i++) {
            if (pq.peek() < arr[i]) {
                pq.poll();
                pq.add(arr[i]);
            }
        }

        // store k largest elements
        while (!pq.isEmpty()) {
            output.add(pq.poll());
        }
        return output;
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 6, 3, 7, 2, 9, 8};
        int k = 3;

        ArrayList<Integer> output = printKLargest2(arr, k);

        for (int i : output) {
            System.out.println(i);
        } // 7 8 9
    }
}

/*
Time Complexity:
O(n log k)
- Each insertion/removal in Priority Queue takes O(log k)

Space Complexity:
O(k)
- Priority Queue stores only k elements

Explanation:
- Maintain Min Priority Queue of size k
- Smallest among k largest elements stays at root
- Replace root if larger element is found
- Remaining elements in heap are k largest elements
*/

/*
Sample Input 1:
2 12 9 16 10 5 3 20 25 11 1 8 6
4

Sample Output 1:
12
16
20
25


Sample Input 2:
4 1 6 3 7 2 9 8
3

Sample Output 2:
7
8
9
*/