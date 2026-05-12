package assignments;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
Problem Statement:
Given a generic tree, find and return the node with second largest value in given tree.
*/

public class SecondLargestNode {
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

    public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root) {
        if (root == null) {
            return null;
        }

        TreeNode<Integer> largest = root;
        TreeNode<Integer> secondLargest = null;

        Queue<TreeNode<Integer>> pendingNodes = new LinkedList<>();
        pendingNodes.add(root);

        while (!pendingNodes.isEmpty()) {
            TreeNode<Integer> front = pendingNodes.remove();

            if (front.data > largest.data) {
                secondLargest = largest;
                largest = front;
            } else if (front.data != largest.data) {
                if (secondLargest == null || front.data > secondLargest.data) {
                    secondLargest = front;
                }
            }

            for (TreeNode<Integer> child : front.children) {
                pendingNodes.add(child);
            }
        }
        return secondLargest;
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

        TreeNode<Integer> secondLargest = findSecondLargest(root);
        System.out.println("Second Largest Node: " + secondLargest.data); // Second Largest Node: 40
    }
}

/*
Time Complexity:
O(n)
- Each node visited once

Space Complexity:
O(n)
- Queue used for level order traversal

Explanation:
- Maintain largest and second largest nodes
- Update them while traversing all nodes
- Return second largest node at the end
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
Second Largest Node: 40
*/

/*
Sample Input 1:
10 3 20 30 40 2 40 50 0 0 0 0

Sample Output 1:
40


Sample Input 2:
5 3 1 2 3 0 0 0

Sample Output 2:
2
*/