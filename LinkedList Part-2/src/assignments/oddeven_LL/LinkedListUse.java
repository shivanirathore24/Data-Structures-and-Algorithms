package assignments.oddeven_LL;
import java.util.Scanner;

/*
Problem Statement:
For a given singly linked list of integers, arrange the nodes such that
all the even number nodes are placed after all the odd number nodes.
The relative order of odd and even terms should remain unchanged.

Note:
- Do not create a new list
- Rearrange nodes, not data
*/

public class LinkedListUse {
    // Take input: e.g. 1 4 5 2 -1
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

    // Rearrange odd-even
    public static Node<Integer> arrangeOddEven(Node<Integer> head) {
        if (head == null) {
            return head;
        }

        Node<Integer> oddHead = null, oddTail = null;
        Node<Integer> evenHead = null, evenTail = null;

        Node<Integer> temp = head;

        while (temp != null) {
            if (temp.data % 2 != 0) {
                if (oddHead == null) {
                    oddHead = temp;
                    oddTail = temp;
                } else {
                    oddTail.next = temp;
                    oddTail = temp;
                }
            } else {
                if (evenHead == null) {
                    evenHead = temp;
                    evenTail = temp;
                } else {
                    evenTail.next = temp;
                    evenTail = temp;
                }
            }
            temp = temp.next;
        }

        // If no odd or no even nodes
        if (oddHead == null) {
            return evenHead;
        }

        if (evenHead == null) {
            return oddHead;
        }

        // connect odd and even lists
        oddTail.next = evenHead;
        evenTail.next = null;

        return oddHead;
    }

    // Print list (for testing)
    public static void print(Node<Integer> head) {
        Node<Integer> temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node<Integer> head = takeInput();
        head = arrangeOddEven(head);
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
- separate odd and even nodes using pointers
- maintain original order
- connect odd list with even list at end
*/

/*
Sample Input 1:
1 4 5 2 -1

Sample Output 1:
1 5 4 2

Sample Input 2:
1 11 3 6 8 0 9 -1

Sample Output 2:
1 11 3 9 6 8 0
*/