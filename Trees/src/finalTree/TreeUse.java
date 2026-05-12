package finalTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
Problem Statement:
Perform different operations on Generic Tree.
*/

public class TreeUse {
    // O(n)
    public static TreeNode<Integer> takeInput() {
        Scanner s = new Scanner(System.in);

        Queue<TreeNode<Integer>> pendingNodes = new LinkedList<>();

        System.out.println("Enter the root data:");
        int rootData = s.nextInt();

        if (rootData == -1) {
            return null; // empty tree
        }

        TreeNode<Integer> root = new TreeNode<>(rootData);
        pendingNodes.add(root);

        while (!pendingNodes.isEmpty()) {
            TreeNode<Integer> front = pendingNodes.remove(); // current node

            System.out.println("Enter the no. of children for: " + front.data);
            int numChild = s.nextInt();

            for (int i = 0; i < numChild; i++) {
                System.out.println("Enter the " + i + "th child data for: " + front.data);
                int childData = s.nextInt();

                TreeNode<Integer> childNode = new TreeNode<>(childData);
                front.children.add(childNode);
                pendingNodes.add(childNode);
            }
        }
        return root;
    }

    // O(n)
    public static void printTree1(TreeNode<Integer> root) { // preorder
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");

        for (int i = 0; i < root.children.size(); i++) {
            TreeNode<Integer> child = root.children.get(i);
            printTree1(child);
        }
    }

    // O(n)
    public static void printTree2(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + ": ");

        for (int i = 0; i < root.children.size(); i++) {
            System.out.print(root.children.get(i).data + " ");
        }

        System.out.println();
        for (int i = 0; i < root.children.size(); i++) {
            TreeNode<Integer> child = root.children.get(i);
            printTree2(child);
        }
    }

    // O(n)
    public static void printLevelWise(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // current level nodes

            for (int i = 0; i < levelSize; i++) {
                TreeNode<Integer> current = queue.poll();
                System.out.print(current.data + " ");

                for (int j = 0; j < current.children.size(); j++) {
                    queue.offer(current.children.get(j));
                }
            }
            System.out.println();
        }
    }

    // O(n)
    public static int numberOfNodes(TreeNode<Integer> root) {
        int count = 1;

        for (int i = 0; i < root.children.size(); i++) {
            int childCount = numberOfNodes(root.children.get(i));
            count += childCount;
        }
        return count;
    }

    // O(n)
    public static int sumOfAllNodes(TreeNode<Integer> root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int sum = 0;
        for (int i = 0; i < root.children.size(); i++) {
            sum += sumOfAllNodes(root.children.get(i));
        }
        return root.data + sum;
    }

    // O(n)
    public static int numNodeGreater(TreeNode<Integer> root, int x) {
        if (root == null) {
            return 0;
        }

        int count = 0;

        if (root.data > x) {
            count++;
        }

        for (TreeNode<Integer> child : root.children) {
            count += numNodeGreater(child, x);
        }
        return count;
    }

    // O(n)
    public static int getHeight(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        int ans = 0;
        for (TreeNode<Integer> child : root.children) {
            int childHeight = getHeight(child);

            if (childHeight > ans) {
                ans = childHeight;
            }
        }
        return ans + 1;
    }

    // O(n)
    public static int countLeafNodes(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        if (root.children.size() == 0) {
            return 1; // leaf node
        }

        int count = 0;
        for (TreeNode<Integer> child : root.children) {
            count += countLeafNodes(child);
        }
        return count;
    }

    // O(n)
    public static void printPostOrderTraversal(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }

        for (TreeNode<Integer> child : root.children) {
            printPostOrderTraversal(child);
        }
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(4);

        TreeNode<Integer> node1 = new TreeNode<>(2);
        TreeNode<Integer> node2 = new TreeNode<>(3);
        TreeNode<Integer> node3 = new TreeNode<>(1);
        TreeNode<Integer> node4 = new TreeNode<>(5);
        TreeNode<Integer> node5 = new TreeNode<>(6);

        root.children.add(node1);
        root.children.add(node2);
        root.children.add(node3);

        node2.children.add(node4);
        node2.children.add(node5);

        printTree2(root);
        System.out.println();

        System.out.println("Number of nodes: " + numberOfNodes(root));
        System.out.println("Sum of nodes: " + sumOfAllNodes(root));
        System.out.println("No. of nodes greater than X: " + numNodeGreater(root, 3));
        System.out.println("Height of tree: " + getHeight(root));
        System.out.println("Count leaf nodes: " + countLeafNodes(root));

        System.out.println("Post-Order Traversal:");
        printPostOrderTraversal(root);
    }
}

/*
Time Complexity:
O(n)
- Each operation visits every node once

Space Complexity:
O(h)
- Recursive stack height

Explanation:
- Perform preorder, postorder and level order traversal
- Find height, sum and node count
- Count leaf nodes and nodes greater than X
*/

/*
Tree Structure:
        4
     /  |  \
    2   3   1
       / \
      5   6

Sample Output:
4: 2 3 1
2:
3: 5 6
5:
6:
1:

Number of nodes: 6
Sum of nodes: 21
No. of nodes greater than X: 3
Height of tree: 3
Count leaf nodes: 4
Post-Order Traversal:
2 5 6 3 1 4
*/