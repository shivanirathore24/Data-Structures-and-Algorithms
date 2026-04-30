package reverserecursive_LL;
import java.util.Scanner;

/*
Problem Statement:
Reverse a singly linked list using recursion.
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

    // 1. O(n^2) recursive reverse
    public static Node<Integer> reverseR(Node<Integer> head) {
        if (head == null || head.next == null) return head; // base case

        Node<Integer> smallHead = reverseR(head.next); // reverse rest

        Node<Integer> tail = smallHead;
        while (tail.next != null) { // move to last node
            tail = tail.next;
        }

        tail.next = head;  // attach current node at end
        head.next = null;  // break original link

        return smallHead;
    }


    // 2. O(n) reverse using DoubleNode
    public static DoubleNode reverseRBetter(Node<Integer> head) {

        if (head == null || head.next == null) {
            return new DoubleNode(head, head); // single node → head & tail
        }

        DoubleNode smallAns = reverseRBetter(head.next); // reverse rest

        smallAns.tail.next = head; // attach node in O(1)
        head.next = null;          // break original link

        return new DoubleNode(smallAns.head, head); // update tail
    }

    // helper → return only head
    public static Node<Integer> reverseRBetter1(Node<Integer> head) {
        DoubleNode ans = reverseRBetter(head);
        return ans.head;
    }


    // 3. O(n) best recursive reverse
    public static Node<Integer> reverseRBest(Node<Integer> head) {
        if (head == null || head.next == null) return head; // base case

        Node<Integer> smallHead = reverseRBest(head.next); // reverse rest

        Node<Integer> reversedTail = head.next; // next becomes tail
        reversedTail.next = head;               // reverse link
        head.next = null;                       // break original link

        return smallHead;
    }

    public static void main(String[] args) {
        // Input: 1 2 3 4 -1
        Node<Integer> head = takeInput();

        // head = reverseR(head);
        // head = reverseRBetter1(head);
        head = reverseRBest(head);
        print(head);   // 4  3  2  1
    }
}

/*
Complexity Analysis:

For reverseR():
Time Complexity:
O(n^2)
- for each recursive call, we traverse to the last node

Space Complexity:
O(n)
- recursion stack stores all calls till end

Explanation:
- reverse smaller list first
- traverse to last node
- attach current node


For reverseRBetter():
Time Complexity:
O(n)
- each node is processed once without extra traversal

Space Complexity:
O(n)
- recursion stack keeps function calls

Explanation:
- reverse smaller list
- use tail reference to connect node directly
- avoid repeated traversal


For reverseRBest():
Time Complexity:
O(n)
- each node link is reversed exactly once

Space Complexity:
O(n)
- recursion stack depth equals number of nodes

Explanation:
- reverse smaller list
- directly flip next pointer
- no extra structure needed
*/