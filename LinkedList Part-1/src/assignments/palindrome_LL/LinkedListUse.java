package assignments.palindrome_LL;
import java.util.Scanner;

/*
Problem Statement:
Check whether a singly linked list is a palindrome.
*/

public class LinkedListUse {
    // Take input: e.g. 1 2 3 2 1 -1
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

    // Reverse linked list
    private static Node<Integer> reverse(Node<Integer> head) {
        Node<Integer> curr = head;
        Node<Integer> prev = null;
        Node<Integer> next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // Check palindrome
    public static boolean isPalindrome(Node<Integer> head) {
        if (head == null || head.next == null) return true;

        // find middle
        Node<Integer> slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse second half
        Node<Integer> secondHead = slow.next;
        slow.next = null;
        secondHead = reverse(secondHead);

        // compare
        Node<Integer> first = head;
        Node<Integer> second = secondHead;

        while (second != null) {
            if (!first.data.equals(second.data)) {
                return false;
            }
            first = first.next;
            second = second.next;
        }

        // restore list
        secondHead = reverse(secondHead);
        slow.next = secondHead;

        return true;
    }

    public static void main(String[] args) {
        // Input: 1 2 3 2 1 -1
        Node<Integer> head = takeInput();
        print(head);  // 1 2 3 2 1
        System.out.println(isPalindrome(head));  // true
    }
}

/*
Complexity Analysis for isPalindrome():

Time Complexity:
O(n)
- traverse list multiple times

Space Complexity:
O(1)
- no extra space used

Explanation:
- find middle using fast & slow
- reverse second half
- compare both halves
- restore original list
*/

/*
Sample Input 1:
1 2 3 2 1 -1

Sample Output 1:
true

Sample Input 2:
1 2 3 4 -1

Sample Output 2:
false
*/