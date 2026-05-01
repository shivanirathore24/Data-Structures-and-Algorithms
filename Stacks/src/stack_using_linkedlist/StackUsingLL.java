package stack_using_linkedlist;

public class StackUsingLL<T> {
    private LinkedListNode<T> head;
    private int size;

    // O(1)
    public int size() {
        return size;   // return current size
    }

    // O(1)
    public boolean isEmpty() {
        return size == 0;
    }

    // O(1)
    public void push(T elem) {
        LinkedListNode<T> newNode = new LinkedListNode<T>(elem);
        newNode.next = head;   // link new node to current head
        head = newNode;        // move head to new node
        size++;
        System.out.println(head.data);
    }

    // O(1)
    public T top() throws StackEmptyException {
        if (head == null) {
            throw new StackEmptyException();   // underflow
        }
        return head.data;   // return top element
    }

    // O(1)
    public T pop() throws StackEmptyException {
        if (head == null) {
            throw new StackEmptyException();   // underflow
        }
        // remove from front (LIFO)
        T temp = head.data;
        head = head.next;
        size--;
        return temp;
    }
}