package diameter_binarytree;
import java.util.Scanner;

/*
Problem Statement:
For a given Binary Tree, find and return the diameter.
Diameter = maximum number of nodes on the longest path between two leaf nodes.
*/

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
        root.left = takeTreeInputBetter(false, rootData, true);   // left subtree
        root.right = takeTreeInputBetter(false, rootData, false); // right subtree

        return root;
    }

    // O(n)
    public static void printTreeDetailed(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;   // base case
        }

        System.out.print(root.data + ": ");   // print node
        if (root.left != null) {
            System.out.print("L" + root.left.data + ", ");   // left
        }
        if (root.right != null) {
            System.out.print("R" + root.right.data);   // right
        }
        System.out.println();

        printTreeDetailed(root.left);   // left subtree
        printTreeDetailed(root.right);  // right subtree
    }

    // O(n)
    public static int height(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;   // base case
        }

        int leftHeight = height(root.left);    // left height
        int rightHeight = height(root.right);  // right height

        return 1 + Math.max(leftHeight, rightHeight);
    }

    // O(n^2)
    public static int diameterOfBinaryTree(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);     // left height
        int rightHeight = height(root.right);   // right height

        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);

        return Math.max(leftHeight + rightHeight + 1,
                Math.max(leftDiameter, rightDiameter));   // best path
    }

    // O(n)
    public static int diameterOfBinaryTreeBetter(BinaryTreeNode<Integer> root) {
        return diameterHelper(root).diameter;
    }

    private static Pair diameterHelper(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return new Pair(0, 0);   // (diameter, height)
        }

        Pair left = diameterHelper(root.left);   // left result
        Pair right = diameterHelper(root.right); // right result

        int height = 1 + Math.max(left.height, right.height);
        int dist = left.height + right.height + 1;   // path through root
        int diameter = Math.max(dist, Math.max(left.diameter, right.diameter));

        return new Pair(height, diameter);
    }


    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeTreeInputBetter(true, 0, true);
        printTreeDetailed(root);

        System.out.println("Diameter : " + diameterOfBinaryTree(root));
        System.out.println("Diameter : " + diameterOfBinaryTreeBetter(root));
    }
}

/*
Time Complexity:
- Basic → O(n^2)
- Better → O(n)

Space Complexity:
O(h)
- Recursive stack height

Explanation:
- Basic: checks diameter using height repeatedly
- Better: computes height + diameter together
*/

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
Diameter : 5


Sample Input 2:
1 2 3 4 -1 -1 -1 -1 -1

Tree 2:
     1
    /
   2
  /
 3
/
4

Sample Output 2:
Diameter : 4


Sample Input 3:
1 2 -1 4 -1 -1 3 -1 5 -1 -1

Tree 3:
     1
   /   \
  2     3
   \     \
    4     5

Sample Output 3:
Diameter : 5
*/