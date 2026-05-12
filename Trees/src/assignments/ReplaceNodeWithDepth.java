package assignments;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
Problem Statement:
In a given Generic Tree, replace each node with its depth value.
*/

public class ReplaceNodeWithDepth {
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

    public static void replaceWithDepthValue(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        replaceWithDepthValue(root, 0);
    }

    private static void replaceWithDepthValue(TreeNode<Integer> root, int depth) {
        // replacing current node data with depth
        root.data = depth;

        // recursively update child nodes
        for (TreeNode<Integer> child : root.children) {
            replaceWithDepthValue(child, depth + 1);
        }
    }

    public static void main(String[] args) {
        //TreeNode<Integer> root = takeInput();
        TreeNode<Integer> root = new TreeNode<>(10);

        TreeNode<Integer> node1 = new TreeNode<>(20);
        TreeNode<Integer> node2 = new TreeNode<>(30);
        TreeNode<Integer> node3 = new TreeNode<>(40);
        TreeNode<Integer> node4 = new TreeNode<>(50);
        TreeNode<Integer> node5 = new TreeNode<>(60);

        root.children.add(node1);
        root.children.add(node2);
        root.children.add(node3);

        node2.children.add(node4);
        node2.children.add(node5);

        printTree(root);
        System.out.println();

        replaceWithDepthValue(root);
        printTree(root);
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
- Replace current node data with its depth
- Increase depth while moving to child nodes
- Recursively update entire tree
*/

/*
Tree Structure:
       10
   /   |   \
 20   30   40
      / \
    50  60

Output:
10: 20 30 40
20:
30: 50 60
50:
60:
40:

0: 1 1 1
1:
1: 2 2
2:
2:
1:
*/

/*
Sample Input 1:
10 3 20 30 40 2 40 50 0 0 0 0

Sample Output 1:
0
1 1 1
2 2


Sample Input 2:
1 2 2 3 0 1 4 0

Sample Output 2:
0
1 1
2
*/