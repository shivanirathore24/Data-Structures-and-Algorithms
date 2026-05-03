package queue_using_2stacks;

public class QueueUse {
    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println(queue.size());    // 3
        System.out.println(queue.isEmpty()); // false
        System.out.println(queue.dequeue()); // 10
        System.out.println(queue.front());   // 20
    }
}