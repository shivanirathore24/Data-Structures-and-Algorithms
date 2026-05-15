package inbuiltPriorityQueue;
import java.util.PriorityQueue;

/*
Problem Statement:
Demonstrate Inbuilt Priority Queue in Java.
By default, Java PriorityQueue works as Min Priority Queue.
*/

public class InbuiltPQ {
    public static void main(String[] args) {
        int arr[] = {4, 3, 7, 6, 9, 8, 10, 1, 2};

        // by default -> Min Priority Queue
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // insert elements
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }

        System.out.println(pq);

        // print elements in increasing order
        while (!pq.isEmpty()) {
            System.out.println(pq.peek());
            pq.poll();
        }
    }
}

/*
Time Complexity:
Insertion : O(log n)
Peek      : O(1)
Poll      : O(log n)

Space Complexity:
O(n)
- Priority Queue stores all elements

Explanation:
- Java PriorityQueue is internally implemented using Min Heap
- peek() returns minimum element
- poll() removes minimum element
- Elements come out in increasing order
*/

/*
Sample Input:
4 3 7 6 9 8 10 1 2

Sample Output:
1
2
3
4
6
7
8
9
10
*/