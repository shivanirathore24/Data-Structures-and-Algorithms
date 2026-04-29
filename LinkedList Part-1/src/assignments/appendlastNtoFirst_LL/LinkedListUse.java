package assignments.appendlastNtoFirst_LL;
import java.util.Scanner;

/*
Problem Statement:
Append last N nodes of a linked list to the front and return new head.
*/

public class LinkedListUse {
    // Take input
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

    // Print list
    public static void print(Node<Integer> head) {
        Node<Integer> temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // WAY 1: Length-based
    public static Node<Integer> appendLastNToFirst_Way1(Node<Integer> head, int n) {
        if (head == null || n == 0) return head;

        int length = 0;
        Node<Integer> temp = head;

        while (temp != null) {
            length++;
            temp = temp.next;
        }

        int splitPos = length - n;

        Node<Integer> prev = head;
        for (int i = 1; i < splitPos; i++) {
            prev = prev.next;
        }

        Node<Integer> newHead = prev.next;
        prev.next = null;

        Node<Integer> tail = newHead;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = head;

        return newHead;
    }

    // WAY 2: Two-pointer (BEST)
    public static Node<Integer> appendLastNToFirst_Way2(Node<Integer> head, int n) {
        if (head == null || n == 0) return head;

        Node<Integer> fast = head;
        Node<Integer> slow = head;

        // move fast n steps ahead
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // move both pointers
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        Node<Integer> newHead = slow.next;
        slow.next = null;
        fast.next = head;

        return newHead;
    }

    public static void main(String[] args) {
        // Input: 1 2 3 4 5 -1 , n = 3
        Node<Integer> head = takeInput();

        Node<Integer> head1 = appendLastNToFirst_Way1(head, 3);
        print(head1);   // Way-1 → 3 4 5 1 2

        Node<Integer> head2 = appendLastNToFirst_Way2(head, 3);
        print(head2);   // Way-2 → 3 4 5 1 2
    }
}

/*
Complexity Analysis:

Way-1 (Length-based):
Time Complexity:
O(n)
- traverse list multiple times

Space Complexity:
O(1)
- no extra space used

Way-2 (Two-pointer):
Time Complexity:
O(n)
- single traversal

Space Complexity:
O(1)
- no extra space used

Explanation:
- Way-1: find length → split → reconnect
- Way-2: maintain gap of n → split → reconnect
*/

/*
Sample Input 1:
1 2 3 4 5 -1
3

Sample Output 1:
3 4 5 1 2

Sample Input 2:
10 20 30 40 50 60 -1
5

Sample Output 2:
20 30 40 50 60 10
*/