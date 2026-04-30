package assignments.bubblesort_LL;
import java.util.Scanner;

/*
Problem Statement:
Given a singly linked list of integers, sort it using Bubble Sort.
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

    private static int length(Node<Integer> head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }

    public static Node<Integer> bubbleSort(Node<Integer> head) {
        int n = length(head);

        for (int i = 0; i < n - 1; i++) {
            Node<Integer> prev = null;
            Node<Integer> curr = head;

            for (int j = 0; j < n - i - 1; j++) {
                if (curr.data <= curr.next.data) {
                    prev = curr;
                    curr = curr.next;
                } else {
                    // swap adjacent nodes
                    if (prev == null) {
                        Node<Integer> fwd = curr.next;
                        head = fwd;
                        curr.next = fwd.next;
                        fwd.next = curr;
                        prev = fwd;
                    } else {
                        Node<Integer> fwd = curr.next;
                        prev.next = fwd;
                        curr.next = fwd.next;
                        fwd.next = curr;
                        prev = fwd;
                    }
                }
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Node<Integer> head = takeInput();
        head = bubbleSort(head);
        print(head);
    }
}

/*
Complexity Analysis:

Time Complexity:
O(n^2)
- nested traversal for bubble sort passes

Space Complexity:
O(1)
- no extra space used

Explanation:
- find length of list
- compare adjacent nodes
- swap nodes by changing links
- repeat passes until list is sorted
*/

/*
Sample Input 1:
10 9 8 7 6 5 4 3 -1

Sample Output 1:
3 4 5 6 7 8 9 10

Sample Input 2:
10 -5 9 90 5 67 1 89 -1

Sample Output 2:
-5 1 5 9 10 67 89 90
*/
