package assignments.levelwiseLinkedList_BST;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
Problem Statement:
Create separate linked list for every level of Binary Tree.
*/

public class BinaryTreeUse {
    // O(n)
    public static BinaryTreeNode<Integer> takeInputLevelwise() {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter root Data:");
        int rootData = s.nextInt();

        if (rootData == -1) {
            return null; // empty tree
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);

        Queue<BinaryTreeNode<Integer>> pendingChildren = new LinkedList<>();
        pendingChildren.add(root);

        while (!pendingChildren.isEmpty()) {
            BinaryTreeNode<Integer> front = pendingChildren.poll(); // current node

            System.out.println("Enter left child of " + front.data);
            int left = s.nextInt();

            if (left != -1) {
                front.left = new BinaryTreeNode<>(left);
                pendingChildren.add(front.left);
            }

            System.out.println("Enter right child of " + front.data);
            int right = s.nextInt();

            if (right != -1) {
                front.right = new BinaryTreeNode<>(right);
                pendingChildren.add(front.right);
            }
        }
        return root;
    }

    // O(n)
    public static void printLevelwise(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }

        Queue<BinaryTreeNode<Integer>> nodesToPrint = new LinkedList<>();
        nodesToPrint.add(root);

        while (!nodesToPrint.isEmpty()) {
            BinaryTreeNode<Integer> front = nodesToPrint.poll();
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

    // O(n)
    public static ArrayList<LinkedListNode<Integer>> constructLinkedListForEachLevel(BinaryTreeNode<Integer> root) {
        ArrayList<LinkedListNode<Integer>> output = new ArrayList<>();

        if (root == null) {
            return output; // empty tree
        }

        Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
        pendingNodes.add(root);

        while (!pendingNodes.isEmpty()) {
            int levelSize = pendingNodes.size(); // nodes in current level

            LinkedListNode<Integer> head = null;
            LinkedListNode<Integer> tail = null;

            for (int i = 0; i < levelSize; i++) {
                BinaryTreeNode<Integer> currentNode = pendingNodes.poll();
                LinkedListNode<Integer> newNode =
                        new LinkedListNode<>(currentNode.data);

                if (head == null) {
                    head = newNode;
                    tail = newNode;
                } else {
                    tail.next = newNode;
                    tail = newNode;
                }

                if (currentNode.left != null) {
                    pendingNodes.add(currentNode.left);
                }

                if (currentNode.right != null) {
                    pendingNodes.add(currentNode.right);
                }
            }
            output.add(head); // add linked list head
        }
        return output;
    }

    // O(n)
    public static void printLinkedList(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputLevelwise();
        printLevelwise(root);
        System.out.println();

        ArrayList<LinkedListNode<Integer>> output =
                constructLinkedListForEachLevel(root);

        for (LinkedListNode<Integer> head : output) {
            printLinkedList(head);
        }
    }
}

/*
Time Complexity:
O(n)
- Each node visited once

Space Complexity:
O(n)
- Queue + linked list storage

Explanation:
- Traverse tree level by level
- Create linked list for every level
- Store head nodes inside ArrayList
*/

/*
Sample Input 1:
5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1

Tree 1:
        5
      /   \
     6     10
    / \
   2   3
        \
         9

Sample Output 1:
5
6 10
2 3
9


Sample Input 2:
1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1

Tree 2:
         1
       /   \
      2     3
     / \   / \
    4  5  6  7

Sample Output 2:
1
2 3
4 5 6 7
*/