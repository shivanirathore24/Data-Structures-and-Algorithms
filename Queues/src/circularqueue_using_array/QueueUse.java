package circularqueue_using_array;

public class QueueUse {
    public static void main(String[] args) throws QueueFullException, QueueEmptyException {
        CircularQueueUsingArray queue = new CircularQueueUsingArray();
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

        queue.enqueue(60);   // ✔ works (space reused)
        queue.enqueue(70);   // ✔ works

        System.out.println(queue.front());   // 30
        System.out.println("Size :" + queue.size());   // Size :5
    }
}