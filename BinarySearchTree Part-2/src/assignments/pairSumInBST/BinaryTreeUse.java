package assignments.pairSumInBST;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/*
Problem Statement:
Find all pairs in BST whose sum is equal to S.
*/

public class BinaryTreeUse {
    // O(n)
    public static BinaryTreeNode<Integer> takeInputLevelwise() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter root Data:");
        int rootData = s.nextInt();

        if (rootData == -1) {
            return null; // empty tree
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);

        Queue<BinaryTreeNode<Integer>> pendingChildren = new LinkedList<>();
        pendingChildren.add(root);

        while (!pendingChildren.isEmpty()) {
            BinaryTreeNode<Integer> front = pendingChildren.poll(); // current node
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
        if (root == null) {
            return;
        }

        Queue<BinaryTreeNode<Integer>> nodesToPrint = new LinkedList<>();
        nodesToPrint.add(root);

        while (!nodesToPrint.isEmpty()) {
            BinaryTreeNode<Integer> front = nodesToPrint.poll();
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

    // O(n)
    public static int countNodes(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    // O(n)
    public static void printNodesSumToS(BinaryTreeNode<Integer> root, int s) {
        if (root == null) {
            return;
        }

        int totalCount = countNodes(root);
        int count = 0;

        Stack<BinaryTreeNode<Integer>> inorder = new Stack<>();
        Stack<BinaryTreeNode<Integer>> revInorder = new Stack<>();
        BinaryTreeNode<Integer> temp = root;

        // push all left nodes
        while (temp != null) {
            inorder.push(temp);
            temp = temp.left;
        }

        temp = root;

        // push all right nodes
        while (temp != null) {
            revInorder.push(temp);
            temp = temp.right;
        }

        while (count < totalCount - 1) {
            BinaryTreeNode<Integer> top1 = inorder.peek();
            BinaryTreeNode<Integer> top2 = revInorder.peek();

            // pair found
            if (top1.data + top2.data == s) {
                System.out.println(top1.data + " " + top2.data);
                BinaryTreeNode<Integer> top = top1;
                inorder.pop();
                count++;

                if (top.right != null) {
                    top = top.right;

                    while (top != null) {
                        inorder.push(top);
                        top = top.left;
                    }
                }

                top = top2;
                revInorder.pop();
                count++;

                if (top.left != null) {
                    top = top.left;

                    while (top != null) {
                        revInorder.push(top);
                        top = top.right;
                    }
                }
            }

            // sum greater than target
            else if (top1.data + top2.data > s) {
                BinaryTreeNode<Integer> top = top2;
                revInorder.pop();
                count++;

                if (top.left != null) {
                    top = top.left;

                    while (top != null) {
                        revInorder.push(top);
                        top = top.right;
                    }
                }
            }

            // sum smaller than target
            else {
                BinaryTreeNode<Integer> top = top1;
                inorder.pop();
                count++;

                if (top.right != null) {
                    top = top.right;

                    while (top != null) {
                        inorder.push(top);
                        top = top.left;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputLevelwise();
        printLevelwise(root);

        Scanner s = new Scanner(System.in);
        System.out.println("Enter required sum:");
        int sum = s.nextInt();

        System.out.println("Pairs are:");
        printNodesSumToS(root, sum);
    }
}

/*
Time Complexity:
O(n)
- Each node visited once

Space Complexity:
O(h)
- Two stacks store tree height nodes

Explanation:
- Use inorder and reverse inorder traversal
- Two stacks work like two pointers
- Print pair when sum becomes equal to S
*/

/*
Sample Input 1:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
12

Tree 1:
        8
      /   \
     5     10
    / \
   2   6
        \
         7

Sample Output 1:
2 10
5 7


Sample Input 2:
15 10 20 8 12 16 25 -1 -1 -1 -1 -1 -1 -1 -1
28

Tree 2:
         15
       /    \
     10      20
    /  \    /  \
   8   12  16  25

Sample Output 2:
8 20
12 16
*/