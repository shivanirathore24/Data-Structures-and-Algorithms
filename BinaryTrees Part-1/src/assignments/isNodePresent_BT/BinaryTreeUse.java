package assignments.isNodePresent_BT;
import java.util.Scanner;

/*
Problem Statement:
For a given Binary Tree of type integer and a number X,
find whether a node exists in the tree with data X or not.
*/

public class BinaryTreeUse {
    // O(n)
    public static BinaryTreeNode<Integer> takeBinaryTreeInput(boolean isRoot, int parentData, boolean isLeft) {
        if (isRoot) {
            System.out.println("Enter root data :");
        } else {
            if (isLeft) {
                System.out.println("Enter left child of " + parentData);
            } else {
                System.out.println("Enter right child of " + parentData);
            }
        }
        Scanner s = new Scanner(System.in);
        int rootData = s.nextInt();

        if (rootData == -1) {
            return null;
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
        BinaryTreeNode<Integer> leftChild = takeBinaryTreeInput(false, rootData, true);
        BinaryTreeNode<Integer> rightChild = takeBinaryTreeInput(false, rootData, false);

        root.left = leftChild;
        root.right = rightChild;

        return root;
    }

    // O(n)
    public static void printBinaryTree(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + ": ");
        if (root.left != null) {
            System.out.print("L" + root.left.data + ", ");
        }
        if (root.right != null) {
            System.out.print("R" + root.right.data);
        }
        System.out.println();

        printBinaryTree(root.left);
        printBinaryTree(root.right);
    }

    // O(n)
    public static boolean isNodePresent(BinaryTreeNode<Integer> root, int x) {
        if (root == null) {
            return false;   // no node
        }
        if (root.data == x) {
            return true;   // found
        }

        return isNodePresent(root.left, x) || isNodePresent(root.right, x);   // search
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeBinaryTreeInput(true, 0, true);
        printBinaryTree(root);

        System.out.println("Enter node data you want check present or not :");
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();

        System.out.println(isNodePresent(root, x));
    }
}

/*
Time Complexity:
O(n)
- Each node is visited once

Space Complexity:
O(h)
- Recursive stack depends on tree height

Explanation:
- Traverse tree using recursion
- If node equals X → return true
- Otherwise check left and right subtree
*/

/*
Sample Input 1:
8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1
7

Sample Output 1:
true

Sample Input 2:
2 3 4 -1 -1 -1 -1
10

Sample Output 2:
false
*/