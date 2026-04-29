package insertnode_LL;

// Node → stores data and next reference
public class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
    }
}