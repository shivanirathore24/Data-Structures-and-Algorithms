package midpoint_LL;
import java.util.Scanner;

/*
Problem Statement:
Find and return the middle node of a singly linked list.
If length is even, return the first middle node.
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
        if (head != null) {
            System.out.println(head.data);
        }
    }

    // Find middle node
    public static Node<Integer> midPoint(Node<Integer> head) {
        if (head == null) return null; // empty list

        Node<Integer> slow = head;
        Node<Integer> fast = head;

        // move fast by 2 and slow by 1
        // condition ensures first middle for even length
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // slow points to middle
    }

    public static void main(String[] args) {
        Node<Integer> head = takeInput();
        Node<Integer> mid = midPoint(head);
        print(mid);
    }
}

/*
Complexity Analysis:

Time Complexity:
O(n)
- list is traversed once using two pointers

Space Complexity:
O(1)
- only two pointers are used, no extra space

Explanation:
- slow moves one step, fast moves two steps
- when fast reaches end, slow is at middle
- condition ensures first middle in even case
*/


/*
Sample Input 1:
1 2 3 4 5 -1

Sample Output 1:
3

Sample Input 2:
1 2 3 4 5 6 -1

Sample Output 2:
3

Sample Input 3:
-1

Sample Output 3:
(no output)
*/