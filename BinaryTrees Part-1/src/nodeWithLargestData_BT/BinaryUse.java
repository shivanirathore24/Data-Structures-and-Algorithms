package nodeWithLargestData_BT;
import java.util.Scanner;

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
    public static int largest(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return -1;   // no node
        }
        int leftMax = largest(root.left);    // left max
        int rightMax = largest(root.right);  // right max

        return Math.max(root.data, Math.max(leftMax, rightMax));   // largest value
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeTreeInputBetter(true, 0, true);
        printTreeDetailed(root);
        System.out.println("Largest: " + largest(root));
    }
}

/*
Sample Input:
1 2 4 -1 -1 5 -1 -1 3 6 -1 -1 7 -1 -1

Tree:
     1
   /   \
  2     3
 / \   / \
4   5 6   7

Sample Output:
Largest: 7
*/