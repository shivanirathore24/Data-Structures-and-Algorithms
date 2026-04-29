package nodeclass_linkedlist;

public class LinkedListUse {
    // Creates linked list: 10 → 20 → 30 → 40
    public static Node<Integer> createLinkedList() {
        Node<Integer> n1 = new Node<>(10);
        Node<Integer> n2 = new Node<>(20);
        Node<Integer> n3 = new Node<>(30);
        Node<Integer> n4 = new Node<>(40);
        // connect nodes
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        return n1; // head node
    }

    // Hardcoded print (works only for fixed size list)
    public static void print1(Node<Integer> head) {
        System.out.println(head.data);
        System.out.println(head.next.data);
        System.out.println(head.next.next.data);
        System.out.println(head.next.next.next.data);
    }

    // Traversal by modifying head
    public static void print2(Node<Integer> head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next; // move to next node
        }
        System.out.println();
    }

    // Traversal using temp (best practice, head unchanged)
    public static void print3(Node<Integer> head) {
        Node<Integer> temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next; // move to next node
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node<Integer> head = createLinkedList();
        // print1(head); // not scalable
        print2(head);
        print3(head);
    }
}