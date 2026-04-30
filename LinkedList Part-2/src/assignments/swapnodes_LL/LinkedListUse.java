package assignments.swapnodes_LL;
import java.util.Scanner;

/*
Problem Statement:
Given a singly linked list, swap two nodes at positions i and j.
Do not swap data, swap nodes by changing links.
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
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static Node<Integer> swapNodes(Node<Integer> head, int i, int j) {
        if (head == null || i == j) return head;

        Node<Integer> currentNode = head, prev = null;

        Node<Integer> firstNode = null, secondNode = null;
        Node<Integer> firstNodePrev = null, secondNodePrev = null;

        int pos = 0;
        // traverse to locate both nodes and their previous nodes
        while (currentNode != null) {
            if (pos == i) {
                firstNode = currentNode;
                firstNodePrev = prev;
            } else if (pos == j) {
                secondNode = currentNode;
                secondNodePrev = prev;
            }

            prev = currentNode;
            currentNode = currentNode.next;
            pos++;
        }

        // if any index is invalid, return original list
        if (firstNode == null || secondNode == null) return head;

        // reconnect previous nodes to opposite targets
        if (firstNodePrev != null) {
            firstNodePrev.next = secondNode;
        } else {
            head = secondNode; // first node was head
        }

        if (secondNodePrev != null) {
            secondNodePrev.next = firstNode;
        } else {
            head = firstNode; // second node was head
        }

        // swap next pointers of the two nodes
        Node<Integer> temp = firstNode.next;
        firstNode.next = secondNode.next;
        secondNode.next = temp;

        return head;
    }

    public static void main(String[] args) {
        Node<Integer> head = takeInput();
        Scanner s = new Scanner(System.in);
        int i = s.nextInt();
        int j = s.nextInt();

        head = swapNodes(head, i, j);
        print(head);
    }
}

/*
Complexity Analysis:

Time Complexity:
O(n)
- traverse list once to find both nodes

Space Complexity:
O(1)
- no extra space used

Explanation:
- traverse to locate i-th and j-th nodes
- track their previous nodes
- reconnect previous pointers
- swap next links of both nodes
*/

/*
Sample Input 1:
1 2 3 4 5 -1
1 3

Sample Output 1:
1 4 3 2 5

Sample Input 2:
10 20 30 40 50 -1
0 4

Sample Output 2:
50 20 30 40 10
*/