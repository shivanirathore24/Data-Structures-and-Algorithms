package assignments.nodesWithoutSiblings_BT;
import java.util.Scanner;

/*
Problem Statement:
For a given Binary Tree of integers, print all the nodes
which do not have any siblings.
*/

public class BinaryTreeUse{
    // O(n)
    public static BinaryTreeNode<Integer> takeBinaryTreeInput(boolean isRoot, int parentData, boolean isLeft) {
        if (isRoot) {
            System.out.println("Enter root data:");
        } else if (isLeft) {
            System.out.println("Enter left child of " + parentData);
        } else {
            System.out.println("Enter right child of " + parentData);
        }

        Scanner s = new Scanner(System.in);
        int rootData = s.nextInt();

        if (rootData == -1) {
            return null;   // no node
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);

        root.left = takeBinaryTreeInput(false, rootData, true);   // left
        root.right = takeBinaryTreeInput(false, rootData, false); // right

        return root;
    }

    // O(n)
    public static void printBinaryTree(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;   // base case
        }

        System.out.print(root.data + ": ");   // print node
        if (root.left != null) {
            System.out.print("L" + root.left.data + ", ");   // left child
        }

        if (root.right != null) {
            System.out.print("R" + root.right.data);   // right child
        }
        System.out.println();

        printBinaryTree(root.left);   // left subtree
        printBinaryTree(root.right);  // right subtree
    }

    // O(n)
    public static void printNodesWithoutSiblings(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;   // base case
        }

        // only right child exists
        if (root.left == null && root.right != null) {
            System.out.print(root.right.data + " ");
        }
        // only left child exists
        else if (root.left != null && root.right == null) {
            System.out.print(root.left.data + " ");
        }

        printNodesWithoutSiblings(root.left);   // left
        printNodesWithoutSiblings(root.right);  // right
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeBinaryTreeInput(true, 0, true);
        printBinaryTree(root);

        System.out.print("Nodes without siblings: ");
        printNodesWithoutSiblings(root);
    }
}

/*
Time Complexity:
O(n)
- Each node is visited once

Space Complexity:
O(h)
- Recursive stack

Explanation:
- If a node has only one child → that child has no sibling
- Print that child
- Traverse entire tree
*/

/*
Sample Input 1:
5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1

Tree:
      5
    /   \
   6     10
  / \      \
 2   3      9

Sample Output 1:
Nodes without siblings: 9


Sample Input 2:
1 2 -1 4 -1 -1 3 -1 5 -1 -1

Tree:
   1
 /   \
2     3
 \     \
  4     5

Sample Output 2:
4 5
*/