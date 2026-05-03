package queue_using_array;

public class QueueUsingArray {
    private int[] data;
    private int front;
    private int rear;
    private int size;

    public QueueUsingArray()
    {
        data = new int[5];   // default capacity
        front = -1;
        rear = -1;
    }

    public QueueUsingArray(int capacity)
    {
        data = new int[capacity];   // custom capacity
        front = -1;
        rear = -1;
    }

    // O(1)
    public int size() {
        return size;   // return current size
    }

    // O(1)
    public boolean isEmpty() {
        return size == 0;   // check empty
    }

    // O(1)
    public void enqueue(int elem) throws QueueFullException {
        if (size == data.length) {
            throw new QueueFullException();   // overflow
        }

        if (size == 0) {
            front = 0;   // initialize front
        }

        rear++;
        data[rear] = elem;   // insert element
        size++;
    }

    // O(1)
    public int front() throws QueueEmptyException {
        if (size == 0) {
            throw new QueueEmptyException();   // underflow
        }
        return data[front];   // return front element
    }

    // O(1)
    public int dequeue() throws QueueEmptyException {
        if (size == 0) {
            throw new QueueEmptyException();   // underflow
        }

        int temp = data[front];
        front++;      // move front
        size--;

        if (size == 0) {
            front = -1;
            rear = -1;   // reset queue
        }
        return temp;
    }
}