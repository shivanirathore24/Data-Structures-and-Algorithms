package binarytree_final;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
Problem Statement:
Perform multiple operations on Binary Tree:
- Input (recursive + levelwise)
- Print (detailed + levelwise)
- Count nodes, largest, height, leaves
- Print nodes at depth K
- Remove leaf nodes
- Check balanced (O(n^2) and O(n))
- Build tree using inorder + preorder / postorder
*/

public class BinaryTreeUse {

    // O(n)
    public static BinaryTreeNode<Integer> takeInputLevelwise() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter root Data:");
        int rootData = s.nextInt();

        if (rootData == -1) return null;   // empty tree

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
    public static int numNodes(BinaryTreeNode<Integer> root) {
        if (root == null) return 0;
        return 1 + numNodes(root.left) + numNodes(root.right);
    }

    // O(n)
    public static int largest(BinaryTreeNode<Integer> root) {
        if (root == null) return Integer.MIN_VALUE;
        return Math.max(root.data, Math.max(largest(root.left), largest(root.right)));
    }

    // O(n)
    public static int height(BinaryTreeNode<Integer> root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    // O(n)
    public static int numLeaves(BinaryTreeNode<Integer> root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return numLeaves(root.left) + numLeaves(root.right);
    }

    // O(n)
    public static void printAtDepthK(BinaryTreeNode<Integer> root, int k) {
        if (root == null) return;
        if (k == 0) {
            System.out.print(root.data + " ");
            return;
        }
        printAtDepthK(root.left, k - 1);
        printAtDepthK(root.right, k - 1);
    }

    // O(n)
    public static BinaryTreeNode<Integer> removeLeaves(BinaryTreeNode<Integer> root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return null;
        root.left = removeLeaves(root.left);
        root.right = removeLeaves(root.right);
        return root;
    }

    // O(n^2)
    public static boolean isBalanced(BinaryTreeNode<Integer> root) {
        if (root == null) return true;

        int lh = height(root.left);
        int rh = height(root.right);

        if (Math.abs(lh - rh) > 1) return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }

    // O(n)
    public static BalancedTreeReturn isBalancedBetter(BinaryTreeNode<Integer> root) {
        if (root == null) {
            BalancedTreeReturn ans = new BalancedTreeReturn();
            ans.height = 0;
            ans.isBalanced = true;
            return ans;
        }

        BalancedTreeReturn left = isBalancedBetter(root.left);
        BalancedTreeReturn right = isBalancedBetter(root.right);

        BalancedTreeReturn ans = new BalancedTreeReturn();
        ans.height = 1 + Math.max(left.height, right.height);

        ans.isBalanced = Math.abs(left.height - right.height) <= 1
                && left.isBalanced && right.isBalanced;

        return ans;
    }

    public static void main(String[] args) {

        BinaryTreeNode<Integer> root = takeInputLevelwise();
        printLevelwise(root);

        System.out.println("Number of nodes :" + numNodes(root));     // e.g. 7
        System.out.println("Largest Node is : " + largest(root));     // e.g. 7
        System.out.println("Height of tree : " + height(root));       // e.g. 3
        System.out.println("Number of Leaves : " + numLeaves(root));  // e.g. 4

        System.out.print("Print at depth K : ");
        printAtDepthK(root, 2);   // e.g. 4 5 6 7
        System.out.println();

        System.out.println("Is balanced ? : " + isBalanced(root));   // e.g. true
        System.out.println("Is balanced ? : " + isBalancedBetter(root).isBalanced); // e.g. true

        BinaryTreeNode<Integer> root2 = removeLeaves(root);
        System.out.println("After Removing Leaves :");  // After Removing Leaves :
        printLevelwise(root2);
    }
}

/*
Sample Input 1:
1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1

Tree:
     1
   /   \
  2     3
 / \   / \
4   5 6   7

Sample Output:
1:L:2,R:3
2:L:4,R:5
3:L:6,R:7
4:L:-1,R:-1
5:L:-1,R:-1
6:L:-1,R:-1
7:L:-1,R:-1

Number of nodes :7
Largest Node is : 7
Height of tree : 3
Number of Leaves : 4
Print at depth K : 4 5 6 7
Is balanced ? : true
Is balanced ? : true

After Removing Leaves :
1:L:2,R:3
2:L:-1,R:-1
3:L:-1,R:-1
*/