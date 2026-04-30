package assignments.skipMdeleteN_LL;
import java.util.Scanner;

/*
Problem Statement:
Given a singly linked list and two integers M and N,
retain M nodes then delete next N nodes. Continue this pattern.
Return the modified list.
*/

public class LinkedListUse {
    // Input: 1 2 3 4 5 6 7 8 -1
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

    // Print linked list
    public static void print(Node<Integer> head) {
        Node<Integer> temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    // Core logic: keep M nodes, delete next N nodes
    public static Node<Integer> skipMdeleteN(Node<Integer> head, int M, int N) {
        if (head == null || M == 0) return null;
        if (N == 0) return head;

        Node<Integer> current = head;

        while (current != null) {
            // skip M-1 nodes (stay on Mth node)
            for (int i = 1; i < M && current != null; i++) {
                current = current.next;
            }

            if (current == null) break;

            // start deleting from next node
            Node<Integer> temp = current.next;

            for (int i = 0; i < N && temp != null; i++) {
                temp = temp.next;
            }

            // connect Mth node to next valid node
            current.next = temp;

            current = temp;
        }
        return head;
    }

    public static void main(String[] args) {
        Node<Integer> head = takeInput();
        Scanner s = new Scanner(System.in);
        int M = s.nextInt();
        int N = s.nextInt();

        head = skipMdeleteN(head, M, N);
        print(head);
    }
}

/*
Complexity Analysis:

Time Complexity:
O(n)
- traverse list once

Space Complexity:
O(1)
- no extra space used

Explanation:
- move to Mth node
- skip next N nodes
- reconnect list
- repeat until end
*/

/*
Sample Input 1:
1 2 3 4 5 6 7 8 -1
2 2

Sample Output 1:
1 2 5 6

Sample Input 2:
1 2 3 4 5 6 -1
1 1

Sample Output 2:
1 3 5
*/