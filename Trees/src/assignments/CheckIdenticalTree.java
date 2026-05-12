package assignments;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
Problem Statement:
Given two Generic trees, return true if they are structurally identical.
*/

public class CheckIdenticalTree {
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

    public static void printTree(TreeNode<Integer> root) {
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

    public static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        // checking current node data
        if (!root1.data.equals(root2.data)) {
            return false;
        }

        // checking number of children
        if (root1.children.size() != root2.children.size()) {
            return false;
        }

        // recursively compare child subtrees
        for (int i = 0; i < root1.children.size(); i++) {
            if (!checkIdentical(root1.children.get(i), root2.children.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode<Integer> root1 = new TreeNode<>(4);

        TreeNode<Integer> node1 = new TreeNode<>(2);
        TreeNode<Integer> node2 = new TreeNode<>(3);
        TreeNode<Integer> node3 = new TreeNode<>(1);
        TreeNode<Integer> node4 = new TreeNode<>(5);
        TreeNode<Integer> node5 = new TreeNode<>(6);

        root1.children.add(node1);
        root1.children.add(node2);
        root1.children.add(node3);

        node2.children.add(node4);
        node2.children.add(node5);


        TreeNode<Integer> root2 = new TreeNode<>(4);

        TreeNode<Integer> node6 = new TreeNode<>(2);
        TreeNode<Integer> node7 = new TreeNode<>(3);
        TreeNode<Integer> node8 = new TreeNode<>(1);
        TreeNode<Integer> node9 = new TreeNode<>(5);
        TreeNode<Integer> node10 = new TreeNode<>(6);

        root2.children.add(node6);
        root2.children.add(node7);
        root2.children.add(node8);

        node7.children.add(node9);
        node7.children.add(node10);


        printTree(root1);
        System.out.println();

        printTree(root2);
        System.out.println();

        System.out.println(checkIdentical(root1, root2)); // true
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
- Compare current node data
- Compare number of children
- Recursively compare all child subtrees
*/

/*
Tree Structure:
    4
 /  |  \
2   3   1
   / \
  5   6

Output:
4: 2 3 1
2:
3: 5 6
5:
6:
1:

4: 2 3 1
2:
3: 5 6
5:
6:
1:

true
*/

/*
Sample Input 1:
10 3 20 30 40 2 40 50 0 0 0 0
10 3 20 30 40 2 40 50 0 0 0 0

Sample Output 1:
true


Sample Input 2:
10 3 20 30 40 2 40 50 0 0 0 0
10 3 2 30 40 2 40 50 0 0 0 0

Sample Output 2:
false
*/