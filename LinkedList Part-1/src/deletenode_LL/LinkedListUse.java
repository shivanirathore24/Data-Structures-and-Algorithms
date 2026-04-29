package deletenode_LL;
import java.util.Scanner;

public class LinkedListUse {
    // Take input: e.g. 3 4 5 2 6 1 9 -1
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

    // Delete node at given position
    public static Node<Integer> delete(Node<Integer> head, int pos) {
        if (head == null || pos < 0) return head;

        // delete head
        if (pos == 0) {
            return head.next;
        }

        int count = 0;
        Node<Integer> prev = head;

        // reach (pos-1)
        while (count < pos - 1 && prev != null) {
            prev = prev.next;
            count++;
        }

        // valid deletion
        if (prev != null && prev.next != null) {
            prev.next = prev.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        // Input (enter 3 times): 3 4 5 2 6 1 9 -1
        Node<Integer> head1 = takeInput();
        head1 = delete(head1, 3);
        print(head1);   // pos=3 → 3 4 5 6 1 9

        Node<Integer> head2 = takeInput();
        head2 = delete(head2, 0);
        print(head2);   // pos=0 → 4 5 2 6 1 9

        Node<Integer> head3 = takeInput();
        head3 = delete(head3, 10);
        print(head3);   // pos=10 → 3 4 5 2 6 1 9 (no change)
    }
}

/*
Complexity Analysis for delete():

Time Complexity:
O(n)
- traverse list to reach position

Space Complexity:
O(1)
- no extra space used

Explanation:
- handle pos = 0 separately
- move to (pos-1) node
- update links to remove node
*/