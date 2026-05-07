package assignments.printNodeKDistFromNode_BT;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
Problem Statement:
Print all nodes at distance K from a given target node.
*/

public class BinaryTreeUse {
    // O(n)
    public static BinaryTreeNode<Integer> takeInputLevelwise() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter root Data:");
        int rootData = s.nextInt();

        if (rootData == -1) return null;

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        Queue<BinaryTreeNode<Integer>> pendingChildren = new LinkedList<>();
        pendingChildren.add(root);

        while (!pendingChildren.isEmpty()) {
            BinaryTreeNode<Integer> front = pendingChildren.poll();   // current node

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
    public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int target, int k) {
        helper(root, target, k);
    }

    private static int helper(BinaryTreeNode<Integer> root, int target, int k) {
        if (root == null) return -1;   // base case

        if (root.data == target) {
            printDepthK(root, k);   // print subtree nodes
            return 0;
        }

        int left = helper(root.left, target, k);
        if (left != -1) {
            if (left + 1 == k) {
                System.out.println(root.data);
            } else {
                printDepthK(root.right, k - left - 2);
            }
            return left + 1;
        }

        int right = helper(root.right, target, k);
        if (right != -1) {
            if (right + 1 == k) {
                System.out.println(root.data);
            } else {
                printDepthK(root.left, k - right - 2);
            }
            return right + 1;
        }

        return -1;
    }

    private static void printDepthK(BinaryTreeNode<Integer> root, int k) {
        if (root == null) return;

        if (k == 0) {
            System.out.println(root.data);
            return;
        }

        printDepthK(root.left, k - 1);
        printDepthK(root.right, k - 1);
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputLevelwise();

        Scanner s = new Scanner(System.in);
        System.out.println("Enter target node:");
        int target = s.nextInt();   // input target first

        System.out.println("Enter value of K:");
        int k = s.nextInt();        // then K

        nodesAtDistanceK(root, target, k);
    }
}

/*
Time Complexity:
O(n) - each node visited once

Space Complexity:
O(h) - recursion stack

Explanation:
- Find target node using recursion
- Print nodes at distance K in subtree and ancestors

Sample Input 1:
5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
3 1

Tree 1:
        5
      /   \
     6     10
    / \
   2   3
        \
         9

Sample Output 1:
9
6


Sample Input 2:
1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
3 3

Tree 2:
        1
      /   \
     2     3
    / \   / \
   4   5 6   7

Sample Output 2:
4
5
*/