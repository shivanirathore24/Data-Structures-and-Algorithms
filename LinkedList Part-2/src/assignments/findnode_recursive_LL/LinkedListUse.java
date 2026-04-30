package assignments.findnode_recursive_LL;
import java.util.Scanner;

/*
Problem Statement:
Given a singly linked list of integers and an integer n,
find and return the index of first occurrence of 'n'.
Return -1 if not found. Use recursion.
*/

public class LinkedListUse {
    // Take input: e.g. 3 4 5 2 6 1 9 -1
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

    // Core logic → find index recursively
    public static int findNodeRec(Node<Integer> head, int n) {
        if (head == null) {
            return -1;
        }

        if (head.data.equals(n)) {
            return 0;
        }

        int smallAns = findNodeRec(head.next, n);

        if (smallAns == -1) {
            return -1;
        }
        return smallAns + 1;
    }

    public static void main(String[] args) {
        Node<Integer> head = takeInput();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        System.out.println(findNodeRec(head, n));
    }
}

/*
Complexity Analysis:

Time Complexity:
O(n)
- traverse each node once

Space Complexity:
O(n)
- recursion call stack

Explanation:
- recursively search node
- return 0 when found
- add +1 while backtracking
- return -1 if not found
*/

/*
Sample Input 1:
3 4 5 2 6 1 9 -1
100

Sample Output 1:
-1

Sample Input 2:
10 20010 30 400 600 -1
20010

Sample Output 2:
1

Sample Input 3:
100 200 300 400 9000 -34 -1
-34

Sample Output 3:
5
*/