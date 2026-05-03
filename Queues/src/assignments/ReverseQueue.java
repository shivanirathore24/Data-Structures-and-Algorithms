package assignments;
import java.util.LinkedList;
import java.util.Queue;

/*
Problem Statement:
Reverse a queue without using any extra data structure.
*/

public class ReverseQueue {
    // O(n)
    public static void reverseQueue(Queue<Integer> input) {
        if (input.size() <= 1) {
            return;   // base case
        }
        int front = input.poll();   // remove front
        reverseQueue(input);        // reverse remaining
        input.add(front);           // add at rear
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);

        reverseQueue(queue);

        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");   // 40 30 20 10
        }
    }
}

/*
Time Complexity:
O(n)
- Each element processed once via recursion

Space Complexity:
O(n)
- Recursion stack used

Explanation:
- Remove front element
- Recursively reverse remaining queue
- Insert removed element at rear
- This makes first element become last

Sample Input 1:
10 20 30 40

Sample Output 1:
40 30 20 10

Sample Input 2:
1 2 3 4 5 10

Sample Output 2:
10 5 4 3 2 1
*/