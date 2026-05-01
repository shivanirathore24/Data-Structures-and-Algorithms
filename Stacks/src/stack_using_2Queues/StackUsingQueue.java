package stack_using_2queues;
import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    private Queue<Integer> q1;   // main queue
    private Queue<Integer> q2;   // helper queue
    private int size;

    public StackUsingQueue() {
        q1 = new LinkedList<>();   // queue implementation
        q2 = new LinkedList<>();
        size = 0;
    }

    // O(1)
    public int size() {
        return size;
    }

    // O(1)
    public boolean isEmpty() {
        return size == 0;
    }

    // O(1)
    public void push(int element) {
        q1.add(element);   // enqueue element
        size++;
    }

    // O(n)
    public int pop() {
        if (q1.isEmpty()) {
            return -1;   // underflow
        }

        while (q1.size() > 1) {
            q2.add(q1.poll());   // move elements except last
        }

        int ans = q1.poll();   // last element (LIFO)

        while (!q2.isEmpty()) {
            q1.add(q2.poll());   // restore elements
        }
        size--;
        return ans;
    }

    // O(n)
    public int top() {
        if (q1.isEmpty()) {
            return -1;   // underflow
        }

        while (q1.size() > 1) {
            q2.add(q1.poll());   // move elements
        }
        int ans = q1.poll();   // get last element
        q2.add(ans);           // put it back

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;             // swap queues
        return ans;
    }
}