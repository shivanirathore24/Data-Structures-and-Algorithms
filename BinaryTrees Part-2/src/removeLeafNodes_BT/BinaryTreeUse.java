package removeLeafNodes_BT;
import java.util.Scanner;

public class BinaryTreeUse {
    // O(n)
    public static BinaryTreeNode<Integer> takeTreeInputBetter(boolean isRoot, int parentData, boolean isLeft) {
        if (isRoot) {
            System.out.println("Enter root data");   // root input
        } else {
            if (isLeft) {
                System.out.println("Enter left child of " + parentData);   // left input
            } else {
                System.out.println("Enter right child of " + parentData);  // right input
            }
        }
        Scanner s = new Scanner(System.in);
        int rootData = s.nextInt();   // read value

        if (rootData == -1) {
            return null;   // no node
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        root.left = takeTreeInputBetter(false, rootData, true);   // build left
        root.right = takeTreeInputBetter(false, rootData, false); // build right

        return root;
    }

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
    public static BinaryTreeNode<Integer> removeLeaves(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return null;   // base case
        }
        if (root.left == null && root.right == null) {
            return null;   // remove leaf node
        }

        root.left = removeLeaves(root.left);   // process left
        root.right = removeLeaves(root.right); // process right

        return root;   // return updated tree
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeTreeInputBetter(true, 0, true);
        printTreeDetailed(root);

        BinaryTreeNode<Integer> root1 = removeLeaves(root);   // updated root
        System.out.println("After Removing Leaves :"); // e.g. After Removing Leaves :
        printTreeDetailed(root1);
    }
}

/*
Sample Input 1:
1 2 4 -1 -1 5 -1 -1 3 6 -1 -1 7 -1 -1

Tree 1:
     1
   /   \
  2     3
 / \   / \
4   5 6   7

After Removing Leaves:
     1
   /   \
  2     3

Sample Output 1:
1: L2, R3
2:
3:


Sample Input 2:
10 20 40 -1 -1 -1 30 -1 50 -1 -1

Tree 2:
     10
    /  \
  20    30
  /       \
40         50

After Removing Leaves:
     10
    /  \
  20    30

Sample Output 2:
10: L20, R30
20:
30:
*/