package nodeToRootPath_BST;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
Problem Statement:
Given a BST and a node k, return path from node to root.
*/

public class BinaryTreeUse {
    public static void printLevelwise(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return; // base case
        }

        Queue<BinaryTreeNode<Integer>> nodesToPrint = new LinkedList<>();
        nodesToPrint.add(root);

        while (!nodesToPrint.isEmpty()) {
            BinaryTreeNode<Integer> front = nodesToPrint.poll(); // current node
            System.out.print(front.data + ":");

            if (front.left != null) {
                nodesToPrint.add(front.left);
                System.out.print("L:" + front.left.data);
            } else {
                System.out.print("L:-1");
            }

            if (front.right != null) {
                nodesToPrint.add(front.right);
                System.out.print(",R:" + front.right.data);
            } else {
                System.out.print(",R:-1");
            }
            System.out.println();
        }
    }

    public static BinaryTreeNode<Integer> buildTreeUsingInorderPreorder(int[] preOrder, int[] inOrder) {
        return buildTreeFromPreInHelper(preOrder, inOrder,
                0, preOrder.length - 1,
                0, inOrder.length - 1);
    }

    public static BinaryTreeNode<Integer> buildTreeFromPreInHelper(int[] preOrder, int[] inOrder,
                                                                   int siPre, int eiPre, int siIn, int eiIn) {
        if (siPre > eiPre) {
            return null; // base case
        }

        int rootData = preOrder[siPre];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);

        int rootIndex = -1;

        for (int i = siIn; i <= eiIn; i++) {
            if (inOrder[i] == rootData) {
                rootIndex = i;
                break;
            }
        }

        int siPreLeft = siPre + 1;
        int siInLeft = siIn;
        int eiInLeft = rootIndex - 1;

        int leftSubtreeLength = eiInLeft - siInLeft + 1;

        int eiPreLeft = siPreLeft + leftSubtreeLength - 1;

        int siPreRight = eiPreLeft + 1;
        int eiPreRight = eiPre;

        int siInRight = rootIndex + 1;
        int eiInRight = eiIn;

        BinaryTreeNode<Integer> left = buildTreeFromPreInHelper(
                preOrder, inOrder,
                siPreLeft, eiPreLeft,
                siInLeft, eiInLeft);

        BinaryTreeNode<Integer> right = buildTreeFromPreInHelper(
                preOrder, inOrder,
                siPreRight, eiPreRight,
                siInRight, eiInRight);

        root.left = left;
        root.right = right;

        return root;
    }

    // O(h)
    public static ArrayList<Integer> nodeToRootPathBST(BinaryTreeNode<Integer> root, int x) {
        if (root == null) {
            return null; // node not found
        }

        if (root.data == x) {
            ArrayList<Integer> output = new ArrayList<>();
            output.add(root.data);
            return output;
        } else if (x < root.data) {
            ArrayList<Integer> leftOutput = nodeToRootPathBST(root.left, x);

            if (leftOutput != null) {
                leftOutput.add(root.data);
                return leftOutput;
            }
        } else {
            ArrayList<Integer> rightOutput = nodeToRootPathBST(root.right, x);

            if (rightOutput != null) {
                rightOutput.add(root.data);
                return rightOutput;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // predefined BST
        int inOrder[] = {2, 5, 6, 7, 8, 10};
        int preOrder[] = {8, 5, 2, 6, 7, 10};

        BinaryTreeNode<Integer> root = buildTreeUsingInorderPreorder(preOrder, inOrder);
        printLevelwise(root);
        System.out.println();

        ArrayList<Integer> path = nodeToRootPathBST(root, 2);
        if (path == null) {
            System.out.println("Node not found !");
        } else {
            for (int value : path) {
                System.out.print(value + " ");
            }
        }
    }
}

/*
Time Complexity:
O(h)
- BST height traversal

Space Complexity:
O(h)
- Recursive stack + path storage

Explanation:
- Search node using BST property
- Add nodes while returning back
- Final list becomes node to root path
*/

/*
Sample Input 1:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
2

BST 1:
        8
      /   \
     5     10
    / \
   2   6
        \
         7

Sample Output 1:
2 5 8


Sample Input 2:
15 10 20 8 12 17 25 -1 -1 -1 -1 -1 -1 -1 -1
17

BST 2:
          15
        /    \
      10      20
     /  \    /  \
    8   12  17  25

Sample Output 2:
17 20 15


Sample Input 3:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
100

BST 3:
        8
      /   \
     5     10
    / \
   2   6
        \
         7

Sample Output 3:
Node not found !
*/