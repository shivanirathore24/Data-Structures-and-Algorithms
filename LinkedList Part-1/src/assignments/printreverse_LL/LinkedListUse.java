package assignments.printreverse_LL;
import java.util.Scanner;

/*
Problem Statement:
Given a singly linked list, print its elements in reverse order.
Do not modify the list structure.
*/

public class LinkedListUse {
    // Take input: e.g. 1 2 3 4 -1
    public static Node<Integer> takeInput() {
        Scanner s = new Scanner(System.in);
        int data = s.nextInt();

        Node<Integer> head = null, tail = null;

        while (data != -1) {
            Node<Integer> currentNode = new Node<>(data);

            if (head == null) {
                head = currentNode;
                tail = currentNode;
            } else {
                tail.next = currentNode;
                tail = currentNode;
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

    // Print in reverse (recursive)
    public static void printReverse(Node<Integer> head) {
        if (head == null) return;
        printReverse(head.next);
        System.out.print(head.data + " ");
    }

    public static void main(String[] args) {
        // Input: 1 2 3 4 -1
        Node<Integer> head = takeInput();
        print(head);           // 1 2 3 4
        System.out.println();
        printReverse(head);    // 4 3 2 1
    }
}

/*
Complexity Analysis for printReverse():

Time Complexity:
O(n)
- visit each node once

Space Complexity:
O(n)
- recursive call stack

Explanation:
- go till last node using recursion
- print while returning back
*/

/*
Sample Input 1:
1 2 3 4 -1

Sample Output 1:
4 3 2 1

Sample Input 2:
5 10 15 -1

Sample Output 2:
15 10 5
*/



