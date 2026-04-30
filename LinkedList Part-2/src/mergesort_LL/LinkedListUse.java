package mergesort_LL;
import java.util.Scanner;

/*
Problem Statement:
Sort a singly linked list using Merge Sort.
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

    // find middle using slow-fast pointer
    public static Node<Integer> findMid(Node<Integer> head) {
        if (head == null) return head;

        Node<Integer> slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;          // move by 1
            fast = fast.next.next;     // move by 2
        }

        return slow;   // middle node
    }

    // merge two sorted linked lists
    public static Node<Integer> merge(Node<Integer> head1, Node<Integer> head2) {
        if (head1 == null) return head2;   // first list empty
        if (head2 == null) return head1;   // second list empty

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
                tail.next = t1;    // attach from list1
                tail = t1;
                t1 = t1.next;
            } else {
                tail.next = t2;    // attach from list2
                tail = t2;
                t2 = t2.next;
            }
        }

        // attach leftover
        if (t1 != null) {
            tail.next = t1;   // remaining list1
        } else {
            tail.next = t2;   // remaining list2
        }

        return head;
    }

    // merge sort on linked list
    public static Node<Integer> mergeSort(Node<Integer> head) {
        if (head == null || head.next == null) return head;   // base case

        Node<Integer> mid = findMid(head);

        Node<Integer> half1 = head;
        Node<Integer> half2 = mid.next;
        mid.next = null;   // break list

        half1 = mergeSort(half1);   // sort left
        half2 = mergeSort(half2);   // sort right

        return merge(half1, half2); // merge both
    }

    public static void main(String[] args) {
        // Input: 6 5 1 3 2 4 -1
        Node<Integer> head = takeInput();
        head = mergeSort(head);
        print(head);   // 1  2  3  4  5  6
    }
}

/*
Time Complexity:
O(n log n)
- list is divided log n times and merged in linear time

Space Complexity:
O(log n)
- recursion stack due to divide process

Explanation:
- find middle using slow-fast pointer
- split list into two halves
- recursively sort both halves
- merge sorted halves
*/