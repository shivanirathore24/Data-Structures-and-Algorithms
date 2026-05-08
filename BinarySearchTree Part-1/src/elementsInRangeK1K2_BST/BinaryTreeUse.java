package elementsInRangeK1K2_BST;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
Problem Statement:
Print all BST elements lying between k1 and k2 in increasing order.
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
    public static void elementsInRangeK1K2(BinaryTreeNode<Integer> root, int k1, int k2) {
        if (root == null) return;   // base case

        if (root.data < k1) {
            elementsInRangeK1K2(root.right, k1, k2);   // search right
        } else if (root.data > k2) {
            elementsInRangeK1K2(root.left, k1, k2);   // search left
        } else {
            elementsInRangeK1K2(root.left, k1, k2);   // inorder left

            System.out.print(root.data + " ");   // node in range

            elementsInRangeK1K2(root.right, k1, k2);   // inorder right
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputLevelwise();
        printLevelwise(root);

        Scanner s = new Scanner(System.in);

        System.out.println("Enter value of K1:");
        int k1 = s.nextInt();

        System.out.println("Enter value of K2:");
        int k2 = s.nextInt();

        elementsInRangeK1K2(root, k1, k2);
    }
}

/*
Time Complexity:
O(n) - each node visited at most once

Space Complexity:
O(h) - recursion stack

Explanation:
- Use BST property to skip unnecessary nodes
- Inorder traversal prints elements in sorted order
*/

/*
Sample Input 1:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
6 10

Tree 1:
        8
      /   \
     5     10
    / \
   2   6
        \
         7

Sample Output 1:
6 7 8 10


Sample Input 2:
15 10 20 8 12 17 25 -1 -1 -1 -1 -1 -1 -1 -1
10 20

Tree 2:
          15
        /    \
      10      20
     /  \    /  \
    8   12  17  25

Sample Output 2:
10 12 15 17 20
*/