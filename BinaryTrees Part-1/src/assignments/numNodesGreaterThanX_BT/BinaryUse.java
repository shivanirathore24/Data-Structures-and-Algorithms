package assignments.numNodesGreaterThanX_BT;
import java.util.Scanner;

/*
Problem Statement:
For a given binary tree of integers and an integer X,
find and return the total number of nodes whose data is greater than X.
*/

public class BinaryUse {
    // O(n)
    public static void printTreeDetailed(BinaryTreeNode<Integer> root) {
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

        printTreeDetailed(root.left);   // left subtree
        printTreeDetailed(root.right);  // right subtree
    }

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
        root.left = takeTreeInputBetter(false, rootData, true);   // left child
        root.right = takeTreeInputBetter(false, rootData, false); // right child

        return root;
    }

    // O(n)
    public static int countNodesGreaterThanX(BinaryTreeNode<Integer> root, int x) {
        if (root == null) {
            return 0;   // no node
        }

        int count = (root.data > x) ? 1 : 0;   // current node

        count += countNodesGreaterThanX(root.left, x);   // left
        count += countNodesGreaterThanX(root.right, x);  // right

        return count;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeTreeInputBetter(true, 0, true);
        int x = 5;
        System.out.println(countNodesGreaterThanX(root, x));   // 3
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
- Traverse all nodes using recursion
- If node value > X → count it
- Add results from left and right subtree
*/

/*
Sample Input 1:
1 4 2 3 -1 -1 -1 -1 -1
2

Sample Output 1:
2

Sample Input 2:
5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
5

Sample Output 2:
3
*/