package insertrecursive_LL;
import java.util.Scanner;

/*
Problem Statement:
Insert a node at position 'pos' using recursion.
If pos > length, return list unchanged.
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

    // Insert node recursively
    public static Node<Integer> insertR(Node<Integer> head, int elem, int pos) {
        // invalid case → position beyond length
        if (head == null && pos > 0) return head;

        // base case → insert here
        if (pos == 0) {
            Node<Integer> newNode = new Node<>(elem);
            newNode.next = head;
            return newNode;
        }

        // recursive call
        head.next = insertR(head.next, elem, pos - 1);

        // reconnect while returning
        return head;
    }

    public static void main(String[] args) {
        // Case 1
        // Input: 1 5 6 7 -1
        Node<Integer> head = takeInput();
        head = insertR(head, 20, 2);
        print(head);   // 1  5  20  6  7

        // Case 2
        // Input: 1 5 6 7 -1
        head = takeInput();
        head = insertR(head, 99, 0);
        print(head);   // 99  1  5  6  7

        // Case 3
        // Input: 1 5 6 7 -1
        head = takeInput();
        head = insertR(head, 50, 10);
        print(head);   // 1  5  6  7
    }
}

/*
Complexity Analysis for insertR():

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