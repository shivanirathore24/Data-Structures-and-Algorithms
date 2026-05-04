package numberOfLeafNodes_BT;
import java.util.Scanner;

public class BinaryUse {
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
        System.out.println();   // new line

        printTreeDetailed(root.left);   // left subtree
        printTreeDetailed(root.right);  // right subtree
    }

    public static BinaryTreeNode<Integer> takeTreeInputBetter(boolean isRoot, int parentData, boolean isLeft) {
        if (isRoot) {
            System.out.println("Enter root data:");   // prompt
        } else {
            if (isLeft) {
                System.out.println("Enter left child of " + parentData);   // left prompt
            } else {
                System.out.println("Enter right child of " + parentData);   // right prompt
            }
        }
        Scanner s = new Scanner(System.in);
        int rootData = s.nextInt();   // input

        if (rootData == -1) {
            return null;   // no node
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
        BinaryTreeNode<Integer> leftChild = takeTreeInputBetter(false, rootData, true);   // left child
        BinaryTreeNode<Integer> rightChild = takeTreeInputBetter(false, rootData, false); // right child

        root.left = leftChild;
        root.right = rightChild;

        return root;
    }

    public static int numLeaves(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;   // base case
        }
        if (root.left == null && root.right == null) {
            return 1;   // leaf node
        }
        return numLeaves(root.left) + numLeaves(root.right);   // total leaves
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeTreeInputBetter(true, 0, true);
        printTreeDetailed(root);
        System.out.println("Number of Leaf Nodes: " + numLeaves(root));
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

Sample Output 1:
Number of Leaf Nodes: 4


Sample Input 2:
10 20 40 -1 -1 50 -1 -1 30 -1 60 -1 -1

Tree 2:
    10
   /  \
  20   30
 / \     \
40 50     60

Sample Output 2:
Number of Leaf Nodes: 3
*/