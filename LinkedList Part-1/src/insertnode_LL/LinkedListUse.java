package insertnode_LL;
import java.util.Scanner;

public class LinkedListUse {
    // Take input: e.g. 1 2 3 -1
    public static Node<Integer> takeInput() {
        Scanner s = new Scanner(System.in);
        int data = s.nextInt();

        Node<Integer> head = null, tail = null;

        while (data != -1) {
            Node<Integer> currentNode = new Node<>(data);

            if (head == null) {
                head = currentNode;
                tail = currentNode;
            } else {
                tail.next = currentNode;
                tail = currentNode;
            }

            data = s.nextInt();
        }
        return head;
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

    // Insert node at given position
    public static Node<Integer> insert(Node<Integer> head, int elem, int pos) {
        if (pos < 0) return head;

        Node<Integer> newNode = new Node<>(elem);

        // insert at head
        if (pos == 0) {
            newNode.next = head;
            return newNode;
        }

        int count = 0;
        Node<Integer> prev = head;
        // reach (pos-1)
        while (count < pos - 1 && prev != null) {
            prev = prev.next;
            count++;
        }

        // valid position
        if (prev != null) {
            newNode.next = prev.next;
            prev.next = newNode;
        }
        return head;
    }

    public static void main(String[] args) {
        // Input (enter 3 times): 1 2 3 -1

        Node<Integer> head1 = takeInput();
        head1 = insert(head1, 24, 0);
        print(head1);   // pos=0 → 24 1 2 3

        Node<Integer> head2 = takeInput();
        head2 = insert(head2, 24, 2);
        print(head2);   // pos=2 → 1 2 24 3

        Node<Integer> head3 = takeInput();
        head3 = insert(head3, 24, 6);
        print(head3);   // pos=6 → 1 2 3 (no change)
    }
}

/*
Complexity Analysis for insert():

Time Complexity:
O(n)
- traverse list to reach position

Space Complexity:
O(1)
- only one new node created

Explanation:
- handle pos = 0 separately
- move to (pos-1) node
- adjust links to insert node
*/