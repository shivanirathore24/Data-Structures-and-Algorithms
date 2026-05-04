package assignments.replaceNodeWithDepth_BT;
import java.util.Scanner;

/*
Problem Statement:
For a given binary tree, replace each node's data with its depth.
Root is at depth 0.
Print the modified tree in InOrder traversal.
*/

public class BinaryUse {
    // O(n)
    public static BinaryTreeNode<Integer> takeTreeInputBetter(boolean isRoot, int parentData, boolean isLeft) {
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
        root.left = takeTreeInputBetter(false, rootData, true);   // left
        root.right = takeTreeInputBetter(false, rootData, false); // right

        return root;
    }

    // O(n)
    public static void replaceWithDepth(BinaryTreeNode<Integer> root, int depth) {
        if (root == null) {
            return;   // base case
        }
        root.data = depth;   // replace with depth
        replaceWithDepth(root.left, depth + 1);   // left
        replaceWithDepth(root.right, depth + 1);  // right
    }

    // O(n)
    public static void printInOrder(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        printInOrder(root.left);
        System.out.print(root.data + " ");
        printInOrder(root.right);
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeTreeInputBetter(true, 0, true);
        replaceWithDepth(root, 0);
        printInOrder(root);
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
- Replace each node with its depth
- Root = 0, children = depth + 1
- Print tree using InOrder traversal
*/

/*
Sample Input:
1 2 4 -1 -1 5 -1 -1 3 6 -1 -1 7 -1 -1

Tree:
     1
   /   \
  2     3
 / \   / \
4   5 6   7

After Replacement:
     0
   /   \
  1     1
 / \   / \
2   2 2   2

Sample Output:
2 1 2 0 2 1 2
*/