package assignments.kreverse_LL;
import java.util.Scanner;

/*
Problem Statement:
Reverse the linked list in groups of size k.
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

    public static Node<Integer> kReverse(Node<Integer> head, int k) {
        if (head == null || k == 0 || k == 1) return head;

        Node<Integer> current = head;
        Node<Integer> prev = null;
        Node<Integer> fwd = null;

        int count = 0;

        // reverse first k nodes
        while (count < k && current != null) {
            fwd = current.next;
            current.next = prev;
            prev = current;
            current = fwd;
            count++;
        }

        // connect with remaining list
        if (fwd != null) {
            head.next = kReverse(fwd, k);
        }
        return prev;
    }

    public static void main(String[] args) {
        Node<Integer> head = takeInput();
        Scanner s = new Scanner(System.in);

        int k = s.nextInt();
        head = kReverse(head, k);
        print(head);
    }
}

/*
Complexity Analysis:

Time Complexity:
O(n)
- traverse entire list once in groups

Space Complexity:
O(n/k)
- recursion calls for each group

Explanation:
- reverse first k nodes
- recursively process remaining list
- connect reversed block with next part
- repeat until list ends
*/

/*
Sample Input 1:
1 2 3 4 5 6 7 8 9 10 -1
4

Sample Output 1:
4 3 2 1 8 7 6 5 10 9

Sample Input 2:
1 2 3 4 5 -1
0

Sample Output 2:
1 2 3 4 5
*/
