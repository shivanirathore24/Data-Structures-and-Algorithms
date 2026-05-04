package numberOfNodes_BT;
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
    public static int numNodes(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;   // no node
        }
        int leftCount = numNodes(root.left);    // left count
        int rightCount = numNodes(root.right);  // right count

        return 1 + leftCount + rightCount;   // total nodes
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeTreeInputBetter(true, 0, true);
        printTreeDetailed(root);
        System.out.println("Number of Nodes : " + numNodes(root));
        // Number of Nodes : 5
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
Number of Nodes : 7


Sample Input 2:
10 20 40 -1 -1 -1 30 -1 50 -1 -1

Tree 2:
     10
    /  \
  20    30
  /       \
40         50

Sample Output 2:
Number of Nodes : 5
*/