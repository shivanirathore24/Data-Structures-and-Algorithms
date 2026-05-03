package queue_collection;
import java.util.LinkedList;
import java.util.Queue;

public class QueueCollections {
    public static void main(String[] args) {
        // Queue is an interface, implemented by LinkedList
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add(10);  // add element
        queue.add(20);
        queue.add(30);   // Queue: 10 → 20 → 30

        System.out.println(queue.size());     // 3
        System.out.println(queue.isEmpty());  // false
        System.out.println(queue.remove());   // 10
        System.out.println(queue.poll());     // 20
        System.out.println(queue.peek());     // 30
        System.out.println(queue.element());  // 30
    }
}

/*
add()
→ Inserts element at rear of queue
→ Throws exception if capacity restriction exists and queue is full

remove()
→ Removes and returns front element
→ Throws exception if queue is empty

poll()
→ Removes and returns front element
→ Returns null if queue is empty (safe alternative of remove)

peek()
→ Returns front element without removing it
→ Returns null if queue is empty (safe)

element()
→ Returns front element without removing it
→ Throws exception if queue is empty (strict version of peek)
 */