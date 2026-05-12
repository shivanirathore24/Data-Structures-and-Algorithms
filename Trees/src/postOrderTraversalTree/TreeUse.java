package postOrderTraversalTree;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
Problem Statement:
Given a generic tree, print the post-order traversal of given tree.
*/

public class TreeUse {
    public static void printTree(TreeNode<Integer> root) {  //kind of pre-order
        if (root == null) {
            return;
        }

        //printing as pre-order
        System.out.print(root.data + ": ");
        for (int i = 0; i < root.children.size(); i++) {
            System.out.print(root.children.get(i).data + " ");
        }
        System.out.println();

        for (int i = 0; i < root.children.size(); i++) {
            TreeNode<Integer> child = root.children.get(i);
            printTree(child);
        }
    }

    public static TreeNode<Integer> takeInput() {
        Scanner s = new Scanner(System.in);
        Queue<TreeNode<Integer>> pendingNodes = new LinkedList<>();
        System.out.println("Enter the root data:");
        int rootData = s.nextInt();

        if (rootData == -1) {
            return null;
        }

        TreeNode<Integer> root = new TreeNode<Integer>(rootData);
        pendingNodes.add(root);

        while (!pendingNodes.isEmpty()) {
            // processing current node level-wise
            TreeNode<Integer> front = pendingNodes.remove();

            System.out.println("Enter the no. of children for: " + front.data);
            int numChild = s.nextInt();

            for (int i = 0; i < numChild; i++) {
                System.out.println("Enter the " + i + "th child data for: " + front.data);
                int childData = s.nextInt();

                TreeNode<Integer> childNode = new TreeNode<>(childData);

                // connecting child with current node
                front.children.add(childNode);

                // adding child for further processing
                pendingNodes.add(childNode);
            }
        }

        return root;
    }

    public static void printPostOrderTraversal(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }

        // first visit all child nodes
        for (TreeNode<Integer> child : root.children) {
            printPostOrderTraversal(child);
        }
        // then print current node
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        //TreeNode<Integer> root = takeInput();
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

        printPostOrderTraversal(root); // 2 5 6 3 1 4
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
- First recursively visit all child nodes
- Print current node after children
- This follows post-order traversal
*/

/*
Tree Structure:
    4
 /  |  \
2   3   1
   / \
  5   6
*/

/*
Output:
2 5 6 3 1 4
*/

/*
Sample Input 1:
10 3 20 30 40 2 400 50 0 0 0 0

Sample Output 1:
400 50 20 30 40 10


Sample Input 2:
1 2 2 3 1 4 0 0

Sample Output 2:
4 2 3 1
*/