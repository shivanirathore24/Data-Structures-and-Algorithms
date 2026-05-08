package assignments.BSTtoLinkedList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
Problem Statement:
Given a BST, convert it into a sorted linked list.
Return the head of linked list.
*/

public class BinaryTreeUse {
    public static void printLevelwise(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return; // base case
        }

        Queue<BinaryTreeNode<Integer>> nodesToPrint = new LinkedList<>();
        nodesToPrint.add(root);

        while (!nodesToPrint.isEmpty()) {
            BinaryTreeNode<Integer> front = nodesToPrint.poll(); // current node
            System.out.print(front.data + ":");

            if (front.left != null) {
                nodesToPrint.add(front.left);
                System.out.print("L:" + front.left.data);
            } else {
                System.out.print("L:-1");
            }

            if (front.right != null) {
                nodesToPrint.add(front.right);
                System.out.print(",R:" + front.right.data);
            } else {
                System.out.print(",R:-1");
            }

            System.out.println();
        }
    }

    public static BinaryTreeNode<Integer> buildTreeUsingInorderPreorder(int[] preOrder, int[] inOrder) {
        return buildTreeFromPreInHelper(preOrder, inOrder,
                0, preOrder.length - 1,
                0, inOrder.length - 1);
    }

    public static BinaryTreeNode<Integer> buildTreeFromPreInHelper(int[] preOrder, int[] inOrder,
                                                                   int siPre, int eiPre, int siIn, int eiIn) {
        if (siPre > eiPre) {
            return null; // base case
        }

        int rootData = preOrder[siPre];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);

        int rootIndex = -1;

        for (int i = siIn; i <= eiIn; i++) {
            if (inOrder[i] == rootData) {
                rootIndex = i;
                break;
            }
        }

        int siPreLeft = siPre + 1;
        int siInLeft = siIn;
        int eiInLeft = rootIndex - 1;

        int leftSubtreeLength = eiInLeft - siInLeft + 1;

        int eiPreLeft = siPreLeft + leftSubtreeLength - 1;

        int siPreRight = eiPreLeft + 1;
        int eiPreRight = eiPre;

        int siInRight = rootIndex + 1;
        int eiInRight = eiIn;

        BinaryTreeNode<Integer> left = buildTreeFromPreInHelper(
                preOrder, inOrder,
                siPreLeft, eiPreLeft,
                siInLeft, eiInLeft);

        BinaryTreeNode<Integer> right = buildTreeFromPreInHelper(
                preOrder, inOrder,
                siPreRight, eiPreRight,
                siInRight, eiInRight);

        root.left = left;
        root.right = right;

        return root;
    }

    // O(n)
    public static LinkedListNode<Integer> constructLinkedList(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return null;
        }

        Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
        BinaryTreeNode<Integer> curr = root;

        LinkedListNode<Integer> head = null;
        LinkedListNode<Integer> prev = null;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();

            LinkedListNode<Integer> newNode = new LinkedListNode<>(curr.data);

            if (head == null) {
                head = newNode;
                prev = newNode;
            } else {
                prev.next = newNode;
                prev = newNode;
            }

            curr = curr.right;
        }
        return head;
    }

    public static void print(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    // O(n)
    public static LinkedListNode<Integer> constructLinkedList1(BinaryTreeNode<Integer> root) {
        return constructLinkedListHelper(root).head;
    }

    private static PairOfNodeElem constructLinkedListHelper(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return new PairOfNodeElem();
        }

        LinkedListNode<Integer> newNode = new LinkedListNode<>(root.data);

        PairOfNodeElem leftList = constructLinkedListHelper(root.left);   // left subtree
        PairOfNodeElem rightList = constructLinkedListHelper(root.right); // right subtree

        PairOfNodeElem pair = new PairOfNodeElem();

        if (leftList.tail != null) {
            leftList.tail.next = newNode;
        }

        newNode.next = rightList.head;

        if (leftList.head != null) {
            pair.head = leftList.head;
        } else {
            pair.head = newNode;
        }

        if (rightList.tail != null) {
            pair.tail = rightList.tail;
        } else {
            pair.tail = newNode;
        }

        return pair;
    }

    public static void main(String[] args) {
        // predefined BST
        int inOrder[] = {2, 5, 6, 7, 9, 10};
        int preOrder[] = {9, 5, 2, 6, 7, 10};

        BinaryTreeNode<Integer> root = buildTreeUsingInorderPreorder(preOrder, inOrder);
        printLevelwise(root);

        System.out.println();

        LinkedListNode<Integer> head = constructLinkedList(root);
        print(head);

        System.out.println();

        LinkedListNode<Integer> head1 = constructLinkedList1(root);
        print(head1);
    }
}

/*
Time Complexity:
O(n)
- Each node visited once

Space Complexity:
O(h)
- Stack / recursion height

Explanation:
- Inorder traversal of BST gives sorted order
- Create linked list nodes during traversal
*/

/*
Sample Input 1:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1

BST 1:
        8
      /   \
     5     10
    / \
   2   6
        \
         7

Sample Output 1:
2 5 6 7 8 10


Sample Input 2:
15 10 20 8 12 17 25 -1 -1 -1 -1 -1 -1 -1 -1

BST 2:
          15
        /    \
      10      20
     /  \    /  \
    8   12  17  25

Sample Output 2:
8 10 12 15 17 20 25
*/