package assignments.maxMinInBinaryTree;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
Problem Statement:
Find minimum and maximum value in Binary Tree.
*/

public class BinaryTreeUse {
    // O(n)
    public static BinaryTreeNode<Integer> takeInputLevelwise() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter root Data:");
        int rootData = s.nextInt();

        if (rootData == -1) return null;

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        Queue<BinaryTreeNode<Integer>> pendingChildren = new LinkedList<>();
        pendingChildren.add(root);

        while (!pendingChildren.isEmpty()) {
            BinaryTreeNode<Integer> front = pendingChildren.poll();

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
        if (root == null) return;

        Queue<BinaryTreeNode<Integer>> nodesToPrint = new LinkedList<>();
        nodesToPrint.add(root);

        while (!nodesToPrint.isEmpty()) {
            BinaryTreeNode<Integer> front = nodesToPrint.poll();
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
    public static Pair<Integer, Integer> getMinAndMax(BinaryTreeNode<Integer> root) {
        if (root == null) return new Pair<>(Integer.MAX_VALUE, Integer.MIN_VALUE);   // base case

        Pair<Integer, Integer> left = getMinAndMax(root.left);    // left subtree
        Pair<Integer, Integer> right = getMinAndMax(root.right);  // right subtree

        int min = Math.min(root.data, Math.min(left.minimum, right.minimum));   // minimum
        int max = Math.max(root.data, Math.max(left.maximum, right.maximum));   // maximum

        return new Pair<>(min, max);   // result
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputLevelwise();
        printLevelwise(root);

        Pair<Integer, Integer> pair = getMinAndMax(root);
        System.out.println("Minimum :" + pair.minimum);
        System.out.println("Maximum :" + pair.maximum);
    }
}

/*
Time Complexity:
O(n) - each node visited once

Space Complexity:
O(h) - recursion stack

Explanation:
- Traverse tree recursively
- Compare root with left and right subtree results

Sample Input 1:
8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1

Tree 1:
        8
      /   \
     3     10
    / \      \
   1   6      14
      / \     /
     4   7   13

Sample Output 1:
1 14


Sample Input 2:
10 20 60 -1 -1 3 50 -1 -1 -1 -1

Tree 2:
        10
       /  \
     20    60
          /
         3
          \
           50

Sample Output 2:
3 60
*/