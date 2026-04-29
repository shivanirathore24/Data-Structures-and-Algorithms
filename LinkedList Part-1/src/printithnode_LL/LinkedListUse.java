package printithnode_LL;

public class LinkedListUse {
    // Create: 10 → 20 → 30 → 40 → 50
    public static Node<Integer> createLinkedList() {
        Node<Integer> n1 = new Node<>(10);
        Node<Integer> n2 = new Node<>(20);
        Node<Integer> n3 = new Node<>(30);
        Node<Integer> n4 = new Node<>(40);
        Node<Integer> n5 = new Node<>(50);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
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

    // Print i-th node
    public static void printIthNode(Node<Integer> head, int i) {
        int position = 0;
        Node<Integer> temp = head;

        while (temp != null) {
            if (position == i) {
                System.out.println(temp.data);
                return;
            }
            temp = temp.next;
            position++;
        }
    }

    public static void main(String[] args) {
        Node<Integer> head = createLinkedList();
        print(head); // 10 20 30 40 50
        printIthNode(head, 3); // 40
        printIthNode(head, 7); // (no output)
    }
}

/*
Complexity Analysis for printIthNode():

Time Complexity:
O(n)
- traverse nodes until position i

Space Complexity:
O(1)
- only one temp pointer used

Explanation:
- move from head to i-th position
- print node data if found
*/

