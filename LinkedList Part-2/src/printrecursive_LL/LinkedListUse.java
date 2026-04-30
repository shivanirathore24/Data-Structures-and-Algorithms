package printrecursive_LL;
import java.util.Scanner;

/*
Problem Statement:
Print a singly linked list using recursion (forward and reverse order).
*/

public class LinkedListUse {
    public static Node<Integer> takeInput() {
        Scanner s = new Scanner(System.in);
        int data = s.nextInt();

        Node<Integer> head = null, tail = null;

        while (data != -1) {
            Node<Integer> newNode = new Node<>(data);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }

            data = s.nextInt();
        }
        return head;
    }

    // Forward recursion
    public static void printR(Node<Integer> head) {
        if (head == null) return;

        System.out.print(head.data + "  "); // print then go next
        printR(head.next);
    }

    // Reverse recursion
    public static void printReverseR(Node<Integer> head) {
        if (head == null) return;

        printReverseR(head.next);           // go till end first
        System.out.print(head.data + "  "); // print while returning
    }

    public static void main(String[] args) {
        // Input: 2 6 8 10 15 -1
        Node<Integer> head = takeInput();

        printR(head);          // 2  6  8  10  15
        System.out.println();

        printReverseR(head);   // 15  10  8  6  2
    }
}

/*
Complexity Analysis:

Time Complexity:
O(n)
- each node is visited once in recursion

Space Complexity:
O(n)
- recursion stack holds n function calls

Explanation:
- forward: print then recurse
- reverse: recurse then print
*/