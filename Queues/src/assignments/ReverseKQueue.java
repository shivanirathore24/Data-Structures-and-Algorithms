package assignments;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
Problem Statement:
Reverse first K elements of a queue
*/

public class ReverseKQueue {
    // O(n)
    public static Queue<Integer> reverseKElements(Queue<Integer> input, int k) {
        if (input.isEmpty() || k > input.size() || k <= 0) {
            return input;
        }

        Stack<Integer> stack = new Stack<>();

        // push first k elements into stack
        for (int i = 0; i < k; i++) {
            stack.push(input.poll());
        }

        // add back to queue (reversed)
        while (!stack.isEmpty()) {
            input.add(stack.pop());
        }

        // move remaining elements
        int remaining = input.size() - k;
        for (int i = 0; i < remaining; i++) {
            input.add(input.poll());
        }

        return input;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        int arr[] = {1, 2, 3, 4, 5};

        for (int x : arr) {
            queue.add(x);
        }

        reverseKElements(queue, 3);

        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        } // 3 2 1 4 5
    }
}

/*
Time Complexity:
O(n)
- Each element processed once

Space Complexity:
O(k)
- Stack stores first k elements

Explanation:
- Reverse first k using stack
- Then rotate remaining queue elements

Sample Input 1:
1 2 3 4 5
k = 3

Sample Output 1:
3 2 1 4 5

Sample Input 2:
10 20 30 40 50 60
k = 4

Sample Output 2:
40 30 20 10 50 60
*/