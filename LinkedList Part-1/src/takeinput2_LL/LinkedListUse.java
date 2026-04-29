package takeinput2_LL;
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

    // Take input using tail (optimized O(n))
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
                tail.next = currentNode; // attach at end
                tail = currentNode;      // move tail
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
O(n)
- each node is added in constant time using tail

Space Complexity:
O(n)
- n nodes are stored in the linked list

Explanation:
- read input until -1
- create node and attach using tail pointer
*/