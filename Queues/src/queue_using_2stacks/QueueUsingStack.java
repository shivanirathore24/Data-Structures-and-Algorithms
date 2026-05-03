package queue_using_2stacks;
import java.util.Stack;


public class QueueUsingStack {
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public QueueUsingStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    // O(1)
    public int size() {
        return s1.size();
    }

    // O(1)
    public boolean isEmpty() {
        return s1.isEmpty();
    }

    // O(1)
    public void enqueue(int element) {
        s1.push(element);   // push into main stack
    }

    // O(n)
    public int dequeue() {
        if (s1.isEmpty()) {
            return -1;   // empty queue
        }

        // move all elements to s2
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        int front = s2.pop();   // remove front element

        // move back to s1
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        return front;
    }

    // O(n)
    public int front() {
        if (s1.isEmpty()) {
            return -1;
        }

        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        int front = s2.peek();   // get front element

        // restore
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        return front;
    }
}