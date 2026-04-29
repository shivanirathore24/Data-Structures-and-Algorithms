package nodeclass_linkedlist;

// Generic node → single element of linked list
public class Node<T> {
    T data;          // stores value
    Node<T> next;    // reference to next node

    public Node(T data) {
        this.data = data;
    }
}