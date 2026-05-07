package assignments.createInsertDuplicateNode_BT;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
Problem Statement:
For a given Binary Tree, duplicate every node and insert it as the left child of itself.
*/

public class BinaryTreeUse {
    // O(n)
    public static BinaryTreeNode<Integer> takeInputLevelwise() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter root Data:");
        int rootData = s.nextInt();

        if (rootData == -1) return null;

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode<Integer> front = queue.poll();

            System.out.println("Enter left child of " + front.data);
            int left = s.nextInt();
            if (left != -1) {
                front.left = new BinaryTreeNode<>(left);
                queue.add(front.left);
            }

            System.out.println("Enter right child of " + front.data);
            int right = s.nextInt();
            if (right != -1) {
                front.right = new BinaryTreeNode<>(right);
                queue.add(front.right);
            }
        }
        return root;
    }

    // O(n)
    public static void printLevelwise(BinaryTreeNode<Integer> root) {
        if (root == null) return;

        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode<Integer> front = queue.poll();
            System.out.print(front.data + ":");

            if (front.left != null) {
                queue.add(front.left);
                System.out.print("L:" + front.left.data);
            } else System.out.print("L:-1");

            if (front.right != null) {
                queue.add(front.right);
                System.out.print(",R:" + front.right.data);
            } else System.out.print(",R:-1");

            System.out.println();
        }
    }

    // O(n)
    public static void insertDuplicateNode(BinaryTreeNode<Integer> root) {
        if (root == null) return;

        BinaryTreeNode<Integer> duplicate = new BinaryTreeNode<>(root.data);
        duplicate.left = root.left;   // attach original left
        root.left = duplicate;        // insert duplicate

        insertDuplicateNode(duplicate.left); // original left subtree
        insertDuplicateNode(root.right);     // right subtree
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputLevelwise();
        printLevelwise(root);

        insertDuplicateNode(root);
        System.out.println("After inserting duplicate at left:"); // After inserting duplicate at left:
        printLevelwise(root);
    }
}

/*
Time Complexity:
O(n)
- Each node visited once

Space Complexity:
O(h)
- Recursive stack height

Explanation:
- Create duplicate node for each node
- Insert it to left
- Original left subtree shifts down
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

After Duplicate:
                 10
               /  \
             10    30
            /     /
          20     30
         /  \       \
       20   50       60
      /     /       /
    40     50      60
   /
 40

Sample Output 1:
10:L:10,R:30
10:L:20,R:-1
30:L:30,R:60
20:L:20,R:50
30:L:-1,R:-1
60:L:60,R:-1
20:L:40,R:-1
50:L:50,R:-1
60:L:-1,R:-1
40:L:40,R:-1
50:L:-1,R:-1
40:L:-1,R:-1


Sample Input 2:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1

Tree 2:
        8
      /   \
     5     10
    / \
   2   6
        \
         7

After Duplicate:
                8
               / \
              8   10
             /   /
            5   10
           /
          5
         / \
        2   6
       /     \
      2       6
             /
            7
           /
          7

Sample Output 2:
8:L:8,R:10
8:L:5,R:-1
5:L:5,R:6
5:L:2,R:-1
2:L:2,R:-1
2:L:-1,R:-1
6:L:6,R:7
6:L:-1,R:-1
7:L:7,R:-1
7:L:-1,R:-1
10:L:10,R:-1
10:L:-1,R:-1
*/