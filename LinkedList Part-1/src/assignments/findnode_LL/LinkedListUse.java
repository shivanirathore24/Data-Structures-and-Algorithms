package assignments.findnode_LL;
import java.util.Scanner;

/*
Problem Statement:
Given a singly linked list, return the index (0-based) of element 'N'.
Return -1 if not found.
*/

public class LinkedListUse {
    // Take input: e.g. 3 4 5 2 6 1 9 -1
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
        System.out.println();
    }

    // Find index of element
    public static int findNode(Node<Integer> head, int elem) {
        int pos = 0;
        while (head != null) {
            if (head.data == elem) {
                return pos;
            }
            head = head.next;
            pos++;
        }
        return -1;
    }

    public static void main(String[] args) {
        // Input: 3 4 5 2 6 1 9 -1
        Node<Integer> head = takeInput();
        print(head);  // 3 4 5 2 6 1 9
        System.out.println(findNode(head, 5));  // 2
        System.out.println(findNode(head, 24));  // -1
    }
}

/*
Complexity Analysis for findNode():

Time Complexity:
O(n)
- traverse list until element is found or end

Space Complexity:
O(1)
- no extra space used

Explanation:
- move from head to null
- compare each node with target
- return index if found else -1
*/

/*
Sample Input 1:
3 4 5 2 6 1 9 -1
5

Sample Output 1:
2

Sample Input 2:
10 20 30 40 50 60 70 -1
6

Sample Output 2:
-1
*/