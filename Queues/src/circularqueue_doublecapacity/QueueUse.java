package circularqueue_doublecapacity;

public class QueueUse {
    public static void main(String[] args) throws QueueFullException, QueueEmptyException {
        CircularQueueUsingArray queue = new CircularQueueUsingArray(5);
        int curr[] = {10, 20, 30, 40, 50};

        for (int elem : curr) {
            queue.enqueue(elem);
        }

        System.out.println("Size :" + queue.size());   // Size :5
        System.out.println("Is Empty ? " + queue.isEmpty());   // false
        System.out.println("First element in Queue : " + queue.front());   // 10

        // delete two elements → 10, 20
        queue.dequeue();
        queue.dequeue();

        System.out.println("Size :" + queue.size());   // Size :3

        queue.enqueue(60);   // triggers resize
        queue.enqueue(70);

        System.out.println(queue.front());   // 30
        System.out.println("Size :" + queue.size());   // Size :5
    }
}