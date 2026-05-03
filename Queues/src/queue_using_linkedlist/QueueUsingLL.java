package queue_using_linkedlist;

public class QueueUsingLL<T> {
    private Node<T> front;
    private Node<T> rear;
    int size;

    public QueueUsingLL() {
        front = null;
        rear = null;
        size = 0;
    }

    // O(1)
    public int size() {
        return size;   // return size
    }

    // O(1)
    public boolean isEmpty() {
        return size == 0;   // check empty
    }

    // O(1)
    public void enqueue(T elem) {
        Node<T> newNode = new Node<>(elem);
        size++;

        if (rear == null) {
            front = newNode;   // first element
            rear = newNode;
        } else {
            rear.next = newNode;   // attach at end
            rear = newNode;
        }
    }

    // O(1)
    public T front() throws QueueEmptyException {
        if (front == null) {
            throw new QueueEmptyException();   // empty queue
        }
        return front.data;
    }

    // O(1)
    public T dequeue() throws QueueEmptyException {
        if (front == null) {
            throw new QueueEmptyException();   // empty queue
        }

        T temp = front.data;
        front = front.next;   // move front

        if (front == null) {
            rear = null;   // reset queue
        }

        size--;
        return temp;
    }
}