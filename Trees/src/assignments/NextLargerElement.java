package assignments;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
Problem Statement:
Given a generic tree and an integer n, find and return the node with next larger element in the tree.
*/

public class NextLargerElement {
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

    public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n) {
        if (root == null) {
            return null;
        }

        TreeNode<Integer> nextLargerNode = null;
        // current node can be possible answer
        if (root.data > n) {
            nextLargerNode = root;
        }

        // recursively search in child subtrees
        for (TreeNode<Integer> child : root.children) {
            TreeNode<Integer> nextLargerInChild = findNextLargerNode(child, n);

            if (nextLargerInChild != null) {
                if (nextLargerNode == null || nextLargerNode.data > nextLargerInChild.data) {
                    nextLargerNode = nextLargerInChild;
                }
            }
        }
        return nextLargerNode;
    }

    public static void main(String[] args) {
        //TreeNode<Integer> root = takeInput();
        TreeNode<Integer> root = new TreeNode<>(10);

        TreeNode<Integer> node1 = new TreeNode<>(20);
        TreeNode<Integer> node2 = new TreeNode<>(30);
        TreeNode<Integer> node3 = new TreeNode<>(40);
        TreeNode<Integer> node4 = new TreeNode<>(40);
        TreeNode<Integer> node5 = new TreeNode<>(50);

        root.children.add(node1);
        root.children.add(node2);
        root.children.add(node3);

        node2.children.add(node4);
        node2.children.add(node5);

        printTree(root);

        TreeNode<Integer> nextLargerNode = findNextLargerNode(root, 18);
        System.out.println("Next Larger Node: " + nextLargerNode.data);
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
- Traverse all nodes recursively
- Find nodes greater than n
- Return node having minimum value among them
*/

/*
Tree Structure:
       10
   /   |   \
 20   30   40
      / \
    40  50

Output:
10: 20 30 40
20:
30: 40 50
40:
50:
40:
Next Larger Node: 20
*/

/*
Sample Input 1:
18
10 3 20 30 40 2 40 50 0 0 0 0

Sample Output 1:
20


Sample Input 2:
21
10 3 20 30 40 2 40 50 0 0 0 0

Sample Output 2:
30
*/