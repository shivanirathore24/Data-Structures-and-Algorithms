package assignments;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
Problem Statement:
Given a tree, find and return the node for which sum of data of all children and the node itself is maximum.
*/

public class MaxSumNode {
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

    public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root) {
        return maxSumNodeHelper(root).node;
    }

    public static MaxNodePair<Integer> maxSumNodeHelper(TreeNode<Integer> root) {
        if (root == null) {
            MaxNodePair<Integer> pair = new MaxNodePair<>();
            pair.node = null;
            pair.sum = Integer.MIN_VALUE;
            return pair;
        }

        int sum = root.data;
        // adding immediate children data
        for (TreeNode<Integer> child : root.children) {
            sum += child.data;
        }

        MaxNodePair<Integer> ans = new MaxNodePair<>();
        ans.node = root;
        ans.sum = sum;

        // recursively check all child subtrees
        for (TreeNode<Integer> child : root.children) {
            MaxNodePair<Integer> childAns = maxSumNodeHelper(child);

            if (childAns.sum > ans.sum) {
                ans = childAns;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        //TreeNode<Integer> root = takeInput();
        TreeNode<Integer> root = new TreeNode<>(5);

        TreeNode<Integer> node1 = new TreeNode<>(1);
        TreeNode<Integer> node2 = new TreeNode<>(2);
        TreeNode<Integer> node3 = new TreeNode<>(3);
        TreeNode<Integer> node4 = new TreeNode<>(15);
        TreeNode<Integer> node5 = new TreeNode<>(4);
        TreeNode<Integer> node6 = new TreeNode<>(5);
        TreeNode<Integer> node7 = new TreeNode<>(6);

        root.children.add(node1);
        root.children.add(node2);
        root.children.add(node3);

        node1.children.add(node4);

        node2.children.add(node5);
        node2.children.add(node6);

        node3.children.add(node7);

        printTree(root);

        TreeNode<Integer> node = maxSumNode(root);
        System.out.println("Node with max sum of children: " + node.data); // Node with max sum of children: 1
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
- Calculate sum of current node and immediate children
- Compare with answers from child subtrees
- Return node having maximum sum
*/

/*
Tree Structure:
        5
    /   |   \
   1    2    3
  /    / \    \
15    4   5    6

Output:
5: 1 2 3
1: 15
15:
2: 4 5
4:
5:
3: 6
6:
Node with max sum of children: 1
*/

/*
Sample Input 1:
5 3 1 2 3 1 15 2 4 5 1 6 0 0 0 0

Sample Output 1:
1


Sample Input 2:
10 2 20 30 0 1 40 0

Sample Output 2:
30
*/