package assignments.removeduplicates_LL;
import java.util.Scanner;

/*
Problem Statement:
Given a sorted singly linked list, remove all duplicate nodes.
*/

public class LinkedListUse {
    // Take input: e.g. 1 1 2 3 3 -1
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
        System.out.println();
    }

    // Remove duplicates (sorted list)
    public static Node<Integer> removeDuplicates(Node<Integer> head) {
        if (head == null) return head;

        Node<Integer> curr = head;

        while (curr.next != null) {
            if (curr.data.equals(curr.next.data)) {
                curr.next = curr.next.next;   // skip duplicate
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        // Input: 1 1 2 3 3 -1
        Node<Integer> head = takeInput();
        print(head);  // 1 1 2 3 3
        head = removeDuplicates(head);
        print(head);  // 1 2 3
    }
}

/*
Complexity Analysis for removeDuplicates():

Time Complexity:
O(n)
- traverse list once

Space Complexity:
O(1)
- no extra space used

Explanation:
- compare current node with next node
- skip node if duplicate
- move forward otherwise
*/

/*
Sample Input 1:
1 1 2 3 3 -1

Sample Output 1:
1 2 3

Sample Input 2:
10 10 10 20 30 30 -1

Sample Output 2:
10 20 30
*/