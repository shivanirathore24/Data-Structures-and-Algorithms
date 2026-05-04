package binarytree_traversal;
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
    public static void preOrder(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;   // base case
        }
        System.out.print(root.data + " ");   // root
        preOrder(root.left);                // left
        preOrder(root.right);               // right
    }

    // O(n)
    public static void postOrder(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;   // base case
        }
        postOrder(root.left);               // left
        postOrder(root.right);              // right
        System.out.print(root.data + " ");  // root
    }

    // O(n)
    public static void inOrder(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;   // base case
        }
        inOrder(root.left);                 // left
        System.out.print(root.data + " ");  // root
        inOrder(root.right);                // right
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeTreeInputBetter(true, 0, true);
        printTreeDetailed(root);

        System.out.print("PreOrder Traversal: ");
        preOrder(root);
        System.out.println();

        System.out.print("PostOrder Traversal: ");
        postOrder(root);
        System.out.println();

        System.out.print("InOrder Traversal: ");
        inOrder(root);
        System.out.println();
    }
}

/*
Sample Input 1:
1 2 -1 4 -1 -1 3 5 -1 -1 -1

Tree 1:
   1
 /   \
2     3
 \   /
  4 5

PreOrder Traversal:
1 2 4 3 5

PostOrder Traversal:
4 2 5 3 1

InOrder Traversal:
2 4 1 5 3


Sample Input 2:
1 2 4 -1 -1 5 -1 -1 3 6 -1 -1 7 -1 -1

Tree 2:
     1
   /   \
  2     3
 / \   / \
4   5 6   7

PreOrder Traversal:
1 2 4 5 3 6 7

PostOrder Traversal:
4 5 2 6 7 3 1

InOrder Traversal:
4 2 5 1 6 3 7
*/
