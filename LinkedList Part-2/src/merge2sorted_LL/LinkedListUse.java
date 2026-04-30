package merge2sorted_LL;
import java.util.Scanner;

/*
Problem Statement:
Merge two sorted singly linked lists into one sorted list.
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

    // merge two sorted linked lists
    public static Node<Integer> merge(Node<Integer> head1, Node<Integer> head2) {
        if (head1 == null) return head2;  // if first list empty
        if (head2 == null) return head1;  // if second list empty

        Node<Integer> t1 = head1, t2 = head2;
        Node<Integer> head = null, tail = null;

        // initialize head and tail
        if (t1.data <= t2.data) {
            head = t1; tail = t1;
            t1 = t1.next;
        } else {
            head = t2; tail = t2;
            t2 = t2.next;
        }

        // merge remaining nodes
        while (t1 != null && t2 != null) {
            if (t1.data <= t2.data) {
                tail.next = t1;   // attach from list1
                tail = t1;
                t1 = t1.next;
            } else {
                tail.next = t2;   // attach from list2
                tail = t2;
                t2 = t2.next;
            }
        }

        // attach remaining list
        if (t1 != null) {
            tail.next = t1;   // remaining part of list1
        } else {
            tail.next = t2;   // remaining part of list2
        }

        return head;
    }

    public static void main(String[] args) {
        // Input:
        // 1 3 5 7 -1
        // 2 4 6 8 -1
        Node<Integer> head1 = takeInput();
        Node<Integer> head2 = takeInput();

        Node<Integer> head = merge(head1, head2);
        print(head);   // 1  2  3  4  5  6  7  8
    }
}

/*
Complexity Analysis:

Time Complexity:
O(n + m)
- each node from both lists is processed exactly once

Space Complexity:
O(1)
- no extra space used, only pointer manipulation

Explanation:
- choose smaller node first to start list
- compare nodes and attach smaller one
- continue until one list ends
- attach remaining part directly
*/