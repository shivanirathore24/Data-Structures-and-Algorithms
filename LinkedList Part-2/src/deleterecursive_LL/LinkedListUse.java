package deleterecursive_LL;
import java.util.Scanner;

/*
Problem Statement:
Delete node at position 'pos' using recursion.
If pos >= length, return list unchanged.
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

    public static void print(Node<Integer> head) {
        Node<Integer> temp = head;

        while (temp != null) {
            System.out.print(temp.data + "  ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Delete node recursively
    public static Node<Integer> deleteR(Node<Integer> head, int pos) {
        if (head == null) return head;

        // base case → delete current node
        if (pos == 0) {
            return head.next;
        }

        // recursive call
        head.next = deleteR(head.next, pos - 1);

        // reconnect while returning
        return head;
    }

    public static void main(String[] args) {
        // Case 1
        // Input: 2 6 8 10 -1
        Node<Integer> head = takeInput();
        head = deleteR(head, 2);
        print(head);   // 2  6  10

        // Case 2
        // Input: 2 6 8 10 -1
        head = takeInput();
        head = deleteR(head, 0);
        print(head);   // 6  8  10

        // Case 3
        // Input: 2 6 8 10 -1
        head = takeInput();
        head = deleteR(head, 10);
        print(head);   // 2  6  8  10
    }
}

/*
Complexity Analysis for deleteR():

Time Complexity:
O(n)
- recursive calls till position

Space Complexity:
O(n)
- recursion stack

Explanation:
- base case at pos = 0
- reduce problem (pos - 1)
- reconnect links while returning
*/