package takeinput1_LL;
import java.util.Scanner;

public class LinkedListUse {
    // Print linked list
    public static void print(Node<Integer> head) {
        Node<Integer> temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Take input until -1 and create linked list (naive O(n^2))
    public static Node<Integer> takeInput() {
        Scanner s = new Scanner(System.in);
        int data = s.nextInt();

        Node<Integer> head = null;

        while (data != -1) {
            Node<Integer> currentNode = new Node<>(data);

            if (head == null) {
                head = currentNode;
            } else {
                Node<Integer> tail = head;

                while (tail.next != null) {   // traverse to last node
                    tail = tail.next;
                }

                tail.next = currentNode;
            }

            data = s.nextInt();
        }
        return head;
    }

    public static void main(String[] args) {
        Node<Integer> head = takeInput();
        print(head); // e.g. input: 1 2 3 4 -1 → 1 2 3 4
    }
}

/*
Complexity Analysis for takeInput():

Time Complexity:
O(n^2)
- for each node, traverse entire list to find tail

Space Complexity:
O(n)
- n nodes are stored in the linked list

Explanation:
- read input until -1
- insert node at end by traversing from head each time
*/