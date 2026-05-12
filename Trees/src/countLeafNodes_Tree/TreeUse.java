package countLeafNodes_Tree;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
Problem Statement:
Given a generic tree, count and return the number of leaf nodes present in the given tree.
*/

public class TreeUse {
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

    public static int countLeafNodes(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        // leaf node found
        if (root.children.size() == 0) {
            return 1;
        }

        int count = 0;
        // recursively count leaf nodes in child subtrees
        for (TreeNode<Integer> child : root.children) {
            count += countLeafNodes(child);
        }
        return count;
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

        printTree(root);
        System.out.println("Leaf Nodes: " + countLeafNodes(root)); // Leaf Nodes: 4
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
- If node has no children, it is a leaf node
- Recursively count leaf nodes in all child subtrees
- Return total leaf node count
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
4: 2 3 1
2:
3: 5 6
5:
6:
1:
Leaf Nodes: 4
*/

/*
Sample Input 1:
10 3 20 30 40 2 40 50 0 0 0 0

Sample Output 1:
4


Sample Input 2:
1 2 2 3 0 1 4 0

Sample Output 2:
2
*/