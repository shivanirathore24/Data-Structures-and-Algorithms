package assignments.LCAOfBST;
import java.util.LinkedList;
import java.util.Queue;

/*
Problem Statement:
Given a BST and two nodes, find Lowest Common Ancestor (LCA).
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
    public static int getLCA(BinaryTreeNode<Integer> root, int a, int b) {
        if (root == null) {
            return -1; // node not found
        }

        if (root.data > a && root.data > b) {
            return getLCA(root.left, a, b); // both in left
        }

        if (root.data < a && root.data < b) {
            return getLCA(root.right, a, b); // both in right
        }

        boolean firstExists = search(root, a);
        boolean secondExists = search(root, b);

        if (firstExists && secondExists) {
            return root.data; // LCA found
        }

        if (firstExists) {
            return a; // only first exists
        }

        if (secondExists) {
            return b; // only second exists
        }

        return -1; // both absent
    }

    // O(h)
    public static boolean search(BinaryTreeNode<Integer> root, int x) {
        if (root == null) {
            return false;
        }

        if (root.data == x) {
            return true;
        }

        if (x < root.data) {
            return search(root.left, x);
        }

        return search(root.right, x);
    }

    public static void main(String[] args) {
        // predefined BST
        int inOrder[] = {2, 5, 6, 7, 8, 10};
        int preOrder[] = {8, 5, 2, 6, 7, 10};

        BinaryTreeNode<Integer> root = buildTreeUsingInorderPreorder(preOrder, inOrder);

        printLevelwise(root);

        System.out.println();

        System.out.println(getLCA(root, 2, 10)); // 8
        System.out.println(getLCA(root, 2, 6));  // 5
        System.out.println(getLCA(root, 12, 78)); // -1
    }
}

/*
Time Complexity:
O(h)
- BST search height

Space Complexity:
O(h)
- Recursive stack

Explanation:
- Move left if both nodes are smaller
- Move right if both nodes are greater
- Otherwise current node becomes LCA
*/

/*
Sample Input 1:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
2 10

BST 1:
        8
      /   \
     5     10
    / \
   2   6
        \
         7

Sample Output 1:
8


Sample Input 2:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
2 6

BST 2:
        8
      /   \
     5     10
    / \
   2   6
        \
         7

Sample Output 2:
5


Sample Input 3:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
12 78

BST 3:
        8
      /   \
     5     10
    / \
   2   6
        \
         7

Sample Output 3:
-1
*/