package assignments.largestBST;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
Problem Statement:
Find height of largest BST present inside Binary Tree.
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
    public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        BSTSubtreeReturn result = findLargestBST(root);
        return result.height;
    }

    // O(n)
    private static BSTSubtreeReturn findLargestBST(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return new BSTSubtreeReturn(
                    true,
                    0,
                    Integer.MAX_VALUE,
                    Integer.MIN_VALUE
            ); // base case
        }

        BSTSubtreeReturn leftResult = findLargestBST(root.left);   // left subtree
        BSTSubtreeReturn rightResult = findLargestBST(root.right); // right subtree

        // current subtree is BST
        if (leftResult.isBST &&
                rightResult.isBST &&
                root.data > leftResult.max &&
                root.data < rightResult.min) {

            int height =
                    Math.max(leftResult.height, rightResult.height) + 1;

            int min = Math.min(root.data, leftResult.min);
            int max = Math.max(root.data, rightResult.max);

            return new BSTSubtreeReturn(true, height, min, max);
        }

        // not a BST
        return new BSTSubtreeReturn(
                false,
                Math.max(leftResult.height, rightResult.height),
                Integer.MIN_VALUE,
                Integer.MAX_VALUE
        );
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputLevelwise();
        printLevelwise(root);
        System.out.println();

        int ans = largestBSTSubtree(root);
        System.out.println("Height of Largest BST : " + ans);
    }
}

/*
Time Complexity:
O(n)
- Each node visited once

Space Complexity:
O(h)
- Recursive stack height

Explanation:
- Check whether current subtree is BST
- Store min, max and height information
- Return maximum BST height found
*/

/*
Sample Input 1:
5 10 6 2 3 -1 -1 -1 -1 -1 9 -1 -1

Tree 1:
         5
       /   \
     10     6
    / \
   2   3
        \
         9

Sample Output 1:
2


Sample Input 2:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1

Tree 2:
        8
      /   \
     5     10
    / \
   2   6
        \
         7

Sample Output 2:
4
*/