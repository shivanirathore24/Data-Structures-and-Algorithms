package assignments.levelOrderTraversal_BT;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
Problem Statement:
Print Binary Tree level wise such that each level is printed in a new line.
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
    public static void levelOrderTraversal(BinaryTreeNode<Integer> root) {
        if (root == null) return;   // base case

        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();   // nodes in current level

            for (int i = 0; i < size; i++) {
                BinaryTreeNode<Integer> node = queue.poll();
                System.out.print(node.data + " ");   // print node

                if (node.left != null) queue.add(node.left);   // left
                if (node.right != null) queue.add(node.right); // right
            }
            System.out.println();   // new line after each level
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputLevelwise();
        levelOrderTraversal(root);   // prints level order
    }
}

/*
Time Complexity:
O(n) - each node processed once

Space Complexity:
O(n) - queue stores nodes

Explanation:
- Use queue for level order traversal
- Process nodes level by level using size
*/

/*
Sample Input 1:
10 20 30 40 50 -1 60 -1 -1 -1 -1 -1 -1

Tree 1:
       10
     /    \
   20      30
  /  \       \
40   50       60

Sample Output 1:
10
20 30
40 50 60


Sample Input 2:
8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1

Tree 2:
        8
      /   \
     3     10
    / \      \
   1   6      14
      / \     /
     4   7   13

Sample Output 2:
8
3 10
1 6 14
4 7 13
*/