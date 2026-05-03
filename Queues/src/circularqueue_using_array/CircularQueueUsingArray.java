package circularqueue_using_array;

public class CircularQueueUsingArray {
    private int[] data;
    private int front;
    private int rear;
    private int size;

    public CircularQueueUsingArray() {
        data = new int[10];   // default capacity
        front = -1;
        rear = -1;
    }

    public CircularQueueUsingArray(int capacity) {
        data = new int[capacity];   // custom capacity
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

    // O(1)
    public void enqueue(int elem) throws QueueFullException {
        if (size == data.length) {
            throw new QueueFullException();   // queue full
        }

        if (size == 0) {
            front = 0;   // initialize front
        }
        // rear++;
        // if(rear == data.length)
        // {
        //     rear = 0;
        // }
        rear = (rear + 1) % data.length;   // circular increment
        data[rear] = elem;
        size++;
    }

    // O(1)
    public int front() throws QueueEmptyException {
        if (size == 0) {
            throw new QueueEmptyException();   // empty queue
        }
        return data[front];
    }

    // O(1)
    public int dequeue() throws QueueEmptyException {
        if (size == 0) {
            throw new QueueEmptyException();   // empty queue
        }

        int temp = data[front];
        // front++;
        // if(front == data.length)
        // {
        //     front = 0;
        // }
        front = (front + 1) % data.length;   // circular move
        size--;

        if (size == 0) {
            front = -1;
            rear = -1;   // reset queue
        }
        return temp;
    }
}