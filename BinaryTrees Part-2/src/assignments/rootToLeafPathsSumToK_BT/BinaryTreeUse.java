package assignments.rootToLeafPathsSumToK_BT;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
Problem Statement:
Print all root-to-leaf paths whose sum equals K.
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
    public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {
        helper(root, k, "");
    }

    private static void helper(BinaryTreeNode<Integer> root, int k, String path) {
        if (root == null) return;   // base case

        if (root.left == null && root.right == null) {   // leaf node
            if (k == root.data) {
                System.out.println(path + root.data + " "); // print path
            }
            return;
        }

        helper(root.left, k - root.data, path + root.data + " ");   // left
        helper(root.right, k - root.data, path + root.data + " ");  // right
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputLevelwise();
        System.out.println("Enter value of K:");
        int k = new Scanner(System.in).nextInt();
        rootToLeafPathsSumToK(root, k);
    }
}

/*
Time Complexity:
O(n) - each node visited once

Space Complexity:
O(h) - recursion stack

Explanation:
- Traverse tree recursively
- Track remaining sum and path
- Print path when leaf and sum matches
*/

/*
Sample Input 1:
2 3 9 4 8 -1 2 4 -1 -1 -1 6 -1 -1 -1 -1 -1
13

Tree 1:
        2
      /   \
     3     9
    / \      \
   4   8      2
  /
 4

Sample Output 1:
2 3 4 4
2 3 8


Sample Input 2:
5 6 7 2 3 -1 1 -1 -1 -1 9 -1 -1 -1 -1
13

Tree 2:
        5
      /   \
     6     7
    / \      \
   2   3      1
        \
         9

Sample Output 2:
5 6 2
5 7 1
*/