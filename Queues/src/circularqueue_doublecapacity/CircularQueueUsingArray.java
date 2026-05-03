package circularqueue_doublecapacity;

public class CircularQueueUsingArray {
    private int[] data;
    private int front;
    private int rear;
    private int size;

    public CircularQueueUsingArray() {
        data = new int[10];
        front = -1;
        rear = -1;
    }

    public CircularQueueUsingArray(int capacity) {
        data = new int[capacity];
        front = -1;
        rear = -1;
    }

    // O(1)
    public int size() {
        return size;
    }

    // O(1)
    public boolean isEmpty() {
        return size == 0;
    }

    // O(1) amortized
    public void enqueue(int elem) throws QueueFullException {
        if (size == data.length) {
            System.out.println("Capacity Before Doubling : " + data.length);
            // Capacity Before Doubling : 10
            doubleCapacity();
        }

        if (size == 0) {
            front = 0; //front++;
        }
        rear = (rear + 1) % data.length;
        data[rear] = elem;
        size++;
    }

    // O(n)
    private void doubleCapacity() {
        int temp[] = data;
        data = new int[2 * temp.length];

        int index = 0;
        // copy from front → end
        for (int i = front; i < temp.length; i++) {
            data[index++] = temp[i];
        }

        // copy from 0 → front-1
        for (int i = 0; i < front; i++) {
            data[index++] = temp[i];
        }

        front = 0;
        rear = temp.length - 1;

        System.out.println("Capacity after Doubling : " + data.length);
        // Capacity after Doubling : 20
    }

    // O(1)
    public int front() throws QueueEmptyException {
        if (size == 0) {
            throw new QueueEmptyException();
        }
        return data[front];
    }

    // O(1)
    public int dequeue() throws QueueEmptyException {
        if (size == 0) {
            throw new QueueEmptyException();
        }

        int temp = data[front];
        front = (front + 1) % data.length;
        size--;

        if (size == 0) {
            front = -1;
            rear = -1;
        }
        return temp;
    }
}