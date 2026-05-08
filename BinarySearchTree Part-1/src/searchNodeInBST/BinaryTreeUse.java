package searchNodeInBST;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
Problem Statement:
Given a BST and an integer K, check whether K is present in BST or not.
*/

public class BinaryTreeUse {
    // O(n)
    public static BinaryTreeNode<Integer> takeInputLevelwise() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter root Data:");
        int rootData = s.nextInt();

        if (rootData == -1) return null;   // empty tree

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        Queue<BinaryTreeNode<Integer>> pendingChildren = new LinkedList<>();
        pendingChildren.add(root);

        while (!pendingChildren.isEmpty()) {
            BinaryTreeNode<Integer> front = pendingChildren.poll();   // current node

            System.out.println("Enter left child of " + front.data);
            int left = s.nextInt();
            if (left != -1) {
                front.left = new BinaryTreeNode<>(left);
                pendingChildren.add(front.left);
            }

            System.out.println("Enter right child of " + front.data);
            int right = s.nextInt();
            if (right != -1) {
                front.right = new BinaryTreeNode<>(right);
                pendingChildren.add(front.right);
            }
        }
        return root;
    }

    // O(n)
    public static void printLevelwise(BinaryTreeNode<Integer> root) {
        if (root == null) return;   // base case

        Queue<BinaryTreeNode<Integer>> nodesToPrint = new LinkedList<>();
        nodesToPrint.add(root);

        while (!nodesToPrint.isEmpty()) {
            BinaryTreeNode<Integer> front = nodesToPrint.poll();   // current node
            System.out.print(front.data + ":");

            if (front.left != null) {
                nodesToPrint.add(front.left);
                System.out.print("L:" + front.left.data);
            } else System.out.print("L:-1");

            if (front.right != null) {
                nodesToPrint.add(front.right);
                System.out.print(",R:" + front.right.data);
            } else System.out.print(",R:-1");

            System.out.println();
        }
    }

    // O(n)
    public static BinaryTreeNode<Integer> buildTreeUsingInorderPreorder(int[] preOrder, int[] inOrder) {
        return buildTreeHelper(preOrder, inOrder, 0, preOrder.length - 1,
                0, inOrder.length - 1);
    }

    private static BinaryTreeNode<Integer> buildTreeHelper(int[] preOrder, int[] inOrder,
                                                           int siPre, int eiPre,
                                                           int siIn, int eiIn) {
        if (siPre > eiPre) return null;   // base case

        int rootData = preOrder[siPre];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);

        int rootIndex = -1;
        for (int i = siIn; i <= eiIn; i++) {
            if (inOrder[i] == rootData) {
                rootIndex = i;
                break;
            }
        }

        int leftSubtreeLength = rootIndex - siIn;

        root.left = buildTreeHelper(preOrder, inOrder,
                siPre + 1,
                siPre + leftSubtreeLength,
                siIn,
                rootIndex - 1);   // left subtree

        root.right = buildTreeHelper(preOrder, inOrder,
                siPre + leftSubtreeLength + 1,
                eiPre,
                rootIndex + 1,
                eiIn);   // right subtree

        return root;
    }

    // O(log n) for balanced BST
    public static boolean searchBST(BinaryTreeNode<Integer> root, int k) {
        if (root == null) return false;   // base case
        if (root.data == k) return true;   // found

        if (k < root.data) {
            return searchBST(root.left, k);   // search left
        }
        return searchBST(root.right, k);   // search right
    }

    public static void main(String[] args) {
        int inOrder[] = {1, 2, 3, 4, 5, 6, 7};
        int preOrder[] = {4, 2, 1, 3, 6, 5, 7};

        BinaryTreeNode<Integer> root = buildTreeUsingInorderPreorder(preOrder, inOrder);
        printLevelwise(root);

        Scanner s = new Scanner(System.in);
        System.out.println("Enter value to search:");
        int k = s.nextInt();

        System.out.println(searchBST(root, k)); // e.g. true
    }
}

/*
Time Complexity:
O(log n) - search follows one path in BST

Space Complexity:
O(h) - recursion stack

Explanation:
- Compare K with current node
- Move left if smaller
- Move right if greater

Sample Input 1:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
2
*/

/*
Tree 1:
        8
      /   \
     5     10
    / \
   2   6
        \
         7

Sample Output 1:
true


Sample Input 2:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
12

Tree 2:
        8
      /   \
     5     10
    / \
   2   6
        \
         7

Sample Output 2:
false
*/