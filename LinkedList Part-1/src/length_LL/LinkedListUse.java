package length_LL;

public class LinkedListUse {
    // Create: 10 → 20 → 30 → 40
    public static Node<Integer> createLinkedList() {
        Node<Integer> n1 = new Node<>(10);
        Node<Integer> n2 = new Node<>(20);
        Node<Integer> n3 = new Node<>(30);
        Node<Integer> n4 = new Node<>(40);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        return n1;
    }

    // Print linked list
    public static void print(Node<Integer> head) {
        Node<Integer> temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Calculate length of linked list
    public static int length(Node<Integer> head) {
        int count = 0;
        Node<Integer> temp = head;

        while (temp != null) {
            count++;          // count nodes
            temp = temp.next;
        }
        return count;
    }

    public static void main(String[] args) {
        Node<Integer> head = createLinkedList();
        print(head);  // 10 20 30 40
        System.out.println(length(head));  // 4
    }
}


/*
Complexity Analysis for length():

Time Complexity:
O(n)
- traverse all nodes once

Space Complexity:
O(1)
- only one temp pointer used

Explanation:
- move from head to null
- count each node
*/